package com.amihaiemil.docker.filters;

import java.util.Collection;
import java.util.Collections;

public class NameFilter implements Filter {

    private final String name;

    public NameFilter(String name) {
        this.name = name;
    }

    @Override
    public String name() {
        return "name";
    }

    @Override
    public Collection<String> values() {
        return Collections.singletonList(name);
    }
}
