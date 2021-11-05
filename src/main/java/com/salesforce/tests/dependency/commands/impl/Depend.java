package com.salesforce.tests.dependency.commands.impl;

import com.salesforce.tests.dependency.commands.ICommand;
import com.salesforce.tests.dependency.commands.pojo.DependentPackage;

import java.util.ArrayList;

public class Depend implements ICommand {

    @Override
    public void execute(java.util.List<String> packages) {

        DependentPackage  dependents =  Dependencies.getInstance().getDependency(packages.get(0));

        //package executed first time
        if(dependents == null){
            dependents = new DependentPackage();
            dependents.setStatus("unInstalled");
            dependents.setName(packages.get(0));
        }

        //get the list of all dependents packages
        java.util.List<DependentPackage> dependentPackageList = dependents.getDependentPackageList();

        if(dependentPackageList ==  null) {
            dependentPackageList = new ArrayList<>();
        }


        //iterate all packages and add it to dependent packages list
        for (int i = 1; i < packages.size(); i++) {
            DependentPackage dependentPackage = new DependentPackage();
            dependentPackage.setName(packages.get(i));
            dependentPackage.setStatus("unInstalled");

            dependentPackageList.add(dependentPackage);
        }
        dependents.setDependentPackageList(dependentPackageList);
        Dependencies.getInstance().addDendency(packages.get(0), dependents);

    }
}
