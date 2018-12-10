package com.amihaiemil.docker.filters;

import java.util.Collection;
import java.util.Collections;

public class DanglingFilter implements Filter {

    private final Boolean dangling;

    public DanglingFilter(Boolean dangling) {
        this.dangling = dangling;
    }

    @Override
    public String name() {
        return "dangling";
    }

    @Override
    public Collection<String> values() {
        return Collections.singletonList(this.dangling.toString());
    }
}
