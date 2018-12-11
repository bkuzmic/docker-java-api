package com.amihaiemil.docker.filters;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LabelFilter implements Filter {

    private final String key;
    private List<String> values;

    public LabelFilter(String key) {
        this.key = key;
    }

    public LabelFilter(String key, String... values) {
        this(key);
        this.values = Arrays.asList(values);
    }

    @Override
    public String name() {
        return "label";
    }

    @Override
    public Collection<String> values() {
        if (this.values == null) {
            return Collections.singletonList(this.key);
        }
        return this.values.stream()
            .map(v -> String.format("%s:%s", this.key, v))
            .collect(Collectors.toList());
    }
}
