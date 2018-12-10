package com.amihaiemil.docker.filters;

import java.util.Collection;

public interface Filter {

    String name();

    Collection<String> values();

}
