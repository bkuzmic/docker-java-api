package com.amihaiemil.docker.filters;

import java.io.StringReader;
import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import org.hamcrest.MatcherAssert;
import org.hamcrest.core.IsEqual;
import org.junit.Test;

public class DockerFiltersTestCase {

    @Test
    public void testToJson() {
        DockerFilters filters = new DockerFilters(
            new DanglingFilter(false),
            new LabelFilter("test", "val1", "val2"),
            new NameFilter("volume1")
        );
        JsonReader jsonReader = Json.createReader(
            new StringReader(filters.toJson()));
        JsonObject json = jsonReader.readObject();
        MatcherAssert.assertThat(
            "Dangling should be false",
            json.getString("dangling"),
            new IsEqual<>("false")
        );
        MatcherAssert.assertThat(
            "Label should be an array and first element is test:val1",
            json.getJsonArray("label").getString(0),
            new IsEqual<>("test:val1")
        );
        MatcherAssert.assertThat(
            "Name should be volume1",
            json.getString("name"),
            new IsEqual<>("volume1")
        );
    }

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
            "Label should be 'abc'",
            json.getString("label"),
            new IsEqual<>("abc")
        );
    }

}
