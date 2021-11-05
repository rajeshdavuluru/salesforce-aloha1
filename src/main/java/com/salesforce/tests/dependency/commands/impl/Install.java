package com.salesforce.tests.dependency.commands.impl;

import com.salesforce.tests.dependency.commands.ICommand;
import com.salesforce.tests.dependency.commands.pojo.DependentPackage;

public class Install implements ICommand {

    @Override
    public void execute(java.util.List<String> packages) {

        DependentPackage  dependents =  Dependencies.getInstance().getDependency(packages.get(0));

        //if no package found in the dependencies
        if(dependents == null){
            dependents = new DependentPackage();
        }

        //checking if the package is already installed or not . if not installed then only install the package
        if("unInstalled".equalsIgnoreCase(dependents.getStatus())){
            if(dependents.getDependentPackageList() !=  null){

                //iterate dependent packages and iinstall
             for (DependentPackage dependentPackage: dependents.getDependentPackageList()) {
                    if("unInstalled".equalsIgnoreCase(dependentPackage.getStatus())){
                        System.out.println("Installing "+dependentPackage.getName());
                    }
                    dependentPackage.setStatus("Installed");
                }
            }
            dependents.setStatus("Installed");
            System.out.println("Installing "+packages.get(0));
        }

    }
}
