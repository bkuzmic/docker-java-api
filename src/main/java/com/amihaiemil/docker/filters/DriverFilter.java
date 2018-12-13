package com.amihaiemil.docker.filters;

import javax.json.JsonObjectBuilder;

/**
 * Driver filter.
 * @author Boris Kuzmic (boris.kuzmic@gmail.com)
 * @since 0.0.7
 */
public final class DriverFilter implements Filter {

    /**
     * Name of the driver.
     */
    private final String driverName;

    /**
     * Ctor.
     * @param driverName Name of the driver.
     */
    public DriverFilter(final String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String name() {
        return "driver";
    }

    @Override
    public void addAsJson(final JsonObjectBuilder builder) {
        builder.add(this.name(), this.driverName);
    }
}
