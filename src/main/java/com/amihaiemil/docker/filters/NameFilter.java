package com.amihaiemil.docker.filters;

import javax.json.JsonObjectBuilder;

/**
 * Name filter.
 * @author Boris Kuzmic (boris.kuzmic@gmail.com)
 * @since 0.0.7
 */
public final class NameFilter implements Filter {

    /**
     * Name of Docker object (container, volume, image).
     */
    private final String name;

    /**
     * Ctor.
     * @param name Name of Docker object.
     */
    public NameFilter(final String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return "name";
    }

    @Override
    public void addAsJson(final JsonObjectBuilder builder) {
        builder.add(this.name(), this.name);
    }
}
