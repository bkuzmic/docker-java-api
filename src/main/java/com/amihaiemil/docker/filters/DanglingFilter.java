package com.amihaiemil.docker.filters;

import javax.json.JsonObjectBuilder;

/**
 * Dangling filter.
 * @author Boris Kuzmic (boris.kuzmic@gmail.com)
 * @since 0.0.7
 */
public final class DanglingFilter implements Filter {

    /**
     * Flag if Docker object is dangling.
     */
    private final boolean dangling;

    /**
     * Ctor.
     * @param dangling Flag if Docker object is dangling.
     */
    public DanglingFilter(final boolean dangling) {
        this.dangling = dangling;
    }

    @Override
    public String name() {
        return "dangling";
    }

    @Override
    public void addAsJson(final JsonObjectBuilder builder) {
        builder.add(this.name(), String.valueOf(this.dangling));
    }

}
