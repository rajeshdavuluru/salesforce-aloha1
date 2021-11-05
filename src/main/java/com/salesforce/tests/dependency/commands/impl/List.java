package com.salesforce.tests.dependency.commands.impl;

import com.salesforce.tests.dependency.commands.ICommand;
import com.salesforce.tests.dependency.commands.pojo.DependentPackage;

import java.util.Map;

public class List implements ICommand {
    @Override
    public void execute(java.util.List<String> packages) {

        Map<String, DependentPackage>  dependents =  Dependencies.getInstance().getAllDependencies();

        //Iterate all the dependent packages and print
        for (String key: dependents.keySet()) {
            System.out.println(key);
        }
    }
}
