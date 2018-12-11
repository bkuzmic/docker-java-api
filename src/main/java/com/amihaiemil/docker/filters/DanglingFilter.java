package com.amihaiemil.docker.filters;

import java.util.Collection;
import java.util.Collections;

public class DanglingFilter implements Filter {

    private final boolean dangling;

    public DanglingFilter(boolean dangling) {
        this.dangling = dangling;
    }

    @Override
    public String name() {
        return "dangling";
    }

    @Override
    public Collection<String> values() {
        return Collections.singletonList(String.valueOf(this.dangling));
    }
}
