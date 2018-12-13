package com.amihaiemil.docker.filters;

import javax.json.JsonObjectBuilder;

/**
 * Client abstraction for filtering mages, volume, containers.
 * @author Boris Kuzmic (boris.kuzmic@gmail.com)
 * @since 0.0.7
 */
public interface Filter {

    /**
     * Filter name representing key in filter map.
     * @return Name of the filter.
     */
    String name();

    /**
     * Create Filter Json representation using builder.
     * @param builder Json Object Builder.
     */
    void addAsJson(final JsonObjectBuilder builder);

}
