package com.amihaiemil.docker.filters;

import java.util.Collection;
import java.util.Collections;

public class DriverFilter implements Filter {

    private final String driverName;

    public DriverFilter(String driverName) {
        this.driverName = driverName;
    }

    @Override
    public String name() {
        return "driver";
    }

    @Override
    public Collection<String> values() {
        return Collections.singletonList(this.driverName);
    }
}
