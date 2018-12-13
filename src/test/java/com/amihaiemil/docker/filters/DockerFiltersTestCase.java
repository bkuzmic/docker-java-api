package com.amihaiemil.docker.filters;

import java.io.StringReader;
import java.util.HashSet;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Unit tests for {@link DockerFilters}.
 * @author Boris Kuzmic (boris.kuzmic@gmail.com)
 * @since 0.0.7
 */
public final class DockerFiltersTestCase {


    /**
     * Makes Set of Filters and verifies that correct Json String is returned.
     */
    @Test
    public void testToJson() {
        Set<Filter> filterSet = new HashSet<>();
        filterSet.add(new DanglingFilter(false));
        filterSet.add(new LabelFilter("test", "val1", "val2"));
        filterSet.add(new NameFilter("volume1"));

        DockerFilters filters = new DockerFilters(filterSet);
        JsonReader jsonReader = Json.createReader(
            new StringReader(filters.toJson()));
        JsonObject json = jsonReader.readObject();
        MatcherAssert.assertThat(
            "Dangling should be false",
            json.getString("dangling"),
            new IsEqual<>("false")
        );
        MatcherAssert.assertThat(
            "Label should be an array and first element is 'test:val1'",
            json.getJsonArray("label").getString(0),
            new IsEqual<>("test:val1")
        );
        MatcherAssert.assertThat(
            "Name should be volume1",
            json.getString("name"),
            new IsEqual<>("volume1")
        );
    }

}
