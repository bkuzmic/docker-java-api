package com.amihaiemil.docker.filters;

import java.util.Set;
import javax.json.Json;
import javax.json.JsonObjectBuilder;

/**
 * Set of Docker filters for sending to server REST API.
 * @author Boris Kuzmic (boris.kuzmic@gmail.com)
 * @since 0.0.7
 */
public final class DockerFilters {

    /**
     * Set of Filter objects.
     */
    private final Set<Filter> filters;

    /**
     * Ctor.
     * @param filters Set of Filter objects.
     */
    public DockerFilters(final Set<Filter> filters) {
        this.filters = filters;
    }

    /**
     * Represents Set of Filters as Json String.
     * @return Json String.
     */
    public String toJson() {
        JsonObjectBuilder json = Json.createObjectBuilder();
        this.filters.forEach(f -> f.addAsJson(json));
        return json.build().toString();
    }

}
