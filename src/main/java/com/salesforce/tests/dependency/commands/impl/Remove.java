package com.salesforce.tests.dependency.commands.impl;

import com.salesforce.tests.dependency.commands.ICommand;
import com.salesforce.tests.dependency.commands.pojo.DependentPackage;

public class Remove implements ICommand {
    @Override
    public void execute(java.util.List<String> packages) {

        DependentPackage  dependents =  Dependencies.getInstance().getDependency(packages.get(0));

        if(dependents == null){
            System.out.println(packages.get(0) +" is not installed");
        }else{
            System.out.println("Removing "+packages.get(0));

            for (DependentPackage dependentPackage: dependents.getDependentPackageList()) {
                System.out.println("Removing "+ dependentPackage.getName());

                dependentPackage.setStatus("unInstalled");
            }
            dependents.setStatus("unInstalled");
        }

    }
}
