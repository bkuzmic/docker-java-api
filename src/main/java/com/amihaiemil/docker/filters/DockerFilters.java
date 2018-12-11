package com.amihaiemil.docker.filters;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

public class DockerFilters {

    private final Set<Filter> filters;

    public DockerFilters(Filter... filters) {
        this.filters = new HashSet<>();
        this.filters.addAll(Arrays.asList(filters));
    }

    public String toJson() {
        JsonObjectBuilder json = Json.createObjectBuilder();
        this.filters.forEach(
            f -> {
                if (f.values().size() > 1) {
                    final JsonArrayBuilder array = Json.createArrayBuilder();
                    f.values().forEach(array::add);
                    json.add(f.name(), array);
                } else if (f.values().size() == 1){
                    json.add(f.name(), f.values().iterator().next());
                }
            }
        );
        return json.build().toString();
    }

}
