package com.amihaiemil.docker.filters;

import java.util.HashSet;
import java.util.Set;

/**
 * Builder for preparing Volume filters.
 * @author Boris Kuzmic (boris.kuzmic@gmail.com)
 * @since 0.0.7
 */
public final class VolumeDockerFiltersBuilder {

    /**
     * Set of Filter objects.
     */
    private final Set<Filter> filters;

    /**
     * Ctor.
     *
     */
    public VolumeDockerFiltersBuilder() {
        this(new HashSet<>());
    }

    /**
     * Private constructor.
     * @param filters Set of Filter objects
     */
    private VolumeDockerFiltersBuilder(final Set<Filter> filters) {
        this.filters = filters;
    }

    /**
     * Add Dangling Filter.
     * @param danglingFilter Dangling Filter.
     * @return New VolumeDockerFiltersBuilder with added filter
     */
    public VolumeDockerFiltersBuilder dangling(
        final DanglingFilter danglingFilter) {
        this.filters.add(danglingFilter);
        return new VolumeDockerFiltersBuilder(this.filters);
    }

    /**
     * Add Driver Filter.
     * @param driverFilter Driver Filter.
     * @return New VolumeDockerFiltersBuilder with added filter
     */
    public VolumeDockerFiltersBuilder driver(final DriverFilter driverFilter) {
        this.filters.add(driverFilter);
        return new VolumeDockerFiltersBuilder(this.filters);
    }

    /**
     * Add Label Filter.
     * @param labelFilter Label Filter.
     * @return New VolumeDockerFiltersBuilder with added filter
     */
    public VolumeDockerFiltersBuilder label(final LabelFilter labelFilter) {
        this.filters.add(labelFilter);
        return new VolumeDockerFiltersBuilder(this.filters);
    }

    /**
     * Add Name Filter.
     * @param nameFilter Name Filter.
     * @return New VolumeDockerFiltersBuilder with added filter
     */
    public VolumeDockerFiltersBuilder name(final NameFilter nameFilter) {
        this.filters.add(nameFilter);
        return new VolumeDockerFiltersBuilder(this.filters);
    }

    /**
     * Build complete DockerFilters object.
     * @return New DockerFilters with all the added filters.
     */
    public DockerFilters build() {
        return new DockerFilters(this.filters);
    }

}
