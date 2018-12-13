package com.amihaiemil.docker.filters;

import java.util.Arrays;
import java.util.List;
import javax.json.Json;
import javax.json.JsonArrayBuilder;
import javax.json.JsonObjectBuilder;

/**
 * Label filter.
 * @author Boris Kuzmic (boris.kuzmic@gmail.com)
 * @since 0.0.7
 */
public final class LabelFilter implements Filter {

    /**
     * Label key.
     */
    private final String key;

    /**
     * Label values.
     */
    private List<String> values;

    /**
     * Ctor. with key.
     * @param key Label key.
     */
    public LabelFilter(final String key) {
        this.key = key;
    }

    /**
     * Ctor. with key and values.
     * @param key Label key.
     * @param values Label values.
     */
    public LabelFilter(final String key, final String... values) {
        this(key);
        this.values = Arrays.asList(values);
    }

    @Override
    public String name() {
        return "label";
    }

    @Override
    public void addAsJson(final JsonObjectBuilder builder) {
        if (this.values!=null && !this.values.isEmpty()) {
            JsonArrayBuilder arrayBuilder = Json.createArrayBuilder();
            this.values.forEach(
                v -> arrayBuilder.add(String.format("%s:%s", this.key, v))
            );
            builder.add(this.name(), arrayBuilder);
        } else {
            builder.add(this.name(), this.key);
        }
    }
}
