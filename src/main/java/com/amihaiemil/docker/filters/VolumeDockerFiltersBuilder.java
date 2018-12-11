package com.amihaiemil.docker.filters;

public class VolumeDockerFiltersBuilder {

    private DanglingFilter danglingFilter;
    private DriverFilter driverFilter;
    private LabelFilter labelFilter;
    private NameFilter nameFilter;

    public VolumeDockerFiltersBuilder() {
    }

    public VolumeDockerFiltersBuilder dangling(
        DanglingFilter danglingFilter) {
        this.danglingFilter = danglingFilter;
        return this;
    }

    public VolumeDockerFiltersBuilder driver(DriverFilter driverFilter) {
        this.driverFilter = driverFilter;
        return this;
    }

    public VolumeDockerFiltersBuilder label(LabelFilter labelFilter) {
        this.labelFilter = labelFilter;
        return this;
    }

    public VolumeDockerFiltersBuilder name(NameFilter nameFilter) {
        this.nameFilter = nameFilter;
        return this;
    }

    public DockerFilters build() {
        return new DockerFilters(
            this.danglingFilter,
            this.driverFilter,
            this.labelFilter,
            this.nameFilter
        );
    }

}
