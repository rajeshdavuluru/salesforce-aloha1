package com.salesforce.tests.dependency.commands.pojo;

import java.util.List;

/*
    DependentPackage is a package and its dependencies.
    Its a pojo with Name, status and dependent packages
 */
public class DependentPackage {

    private String name;

    private String status;

    private List<DependentPackage> dependentPackageList;

    public DependentPackage(){
        this.status = "unInstalled";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<DependentPackage> getDependentPackageList() {
        return dependentPackageList;
    }

    public void setDependentPackageList(List<DependentPackage> dependentPackageList) {
        this.dependentPackageList = dependentPackageList;
    }
}
