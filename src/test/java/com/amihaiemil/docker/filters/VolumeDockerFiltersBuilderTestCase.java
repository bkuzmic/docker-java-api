package com.amihaiemil.docker.filters;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

/**
 * Unit tests for {@link VolumeDockerFiltersBuilder}.
 * @author Boris Kuzmic (boris.kuzmic@gmail.com)
 * @since 0.0.7
 */
public final class VolumeDockerFiltersBuilderTestCase {

    /**
     * Builder can create all possible Volume filters and convert them
     * to Json String.
     */
    @Test
    public void testVolumeDockerFiltersBuilder() {
        DockerFilters filters = new VolumeDockerFiltersBuilder()
            .dangling(new DanglingFilter(false))
            .driver(new DriverFilter("local"))
            .label(new LabelFilter("abc"))
            .name(new NameFilter("volume2"))
            .build();
        JsonReader jsonReader = Json.createReader(
            new StringReader(filters.toJson()));
        JsonObject json = jsonReader.readObject();
        MatcherAssert.assertThat(
            "Dangling should be false",
            json.getString("dangling"),
            new IsEqual<>("false")
        );
        MatcherAssert.assertThat(
            "Driver should be local",
            json.getString("driver"),
            new IsEqual<>("local")
        );
        MatcherAssert.assertThat(
            "Label should be 'abc'",
            json.getString("label"),
            new IsEqual<>("abc")
        );
    }

}
