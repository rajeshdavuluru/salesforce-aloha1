package com.salesforce.tests.dependency.commands.impl;

import com.salesforce.tests.dependency.commands.pojo.DependentPackage;

import java.util.HashMap;
import java.util.Map;

/**
 * Dependencies is the Singleton class and it will have the map the to hold all dependencies
 *
 */
public class Dependencies {

    protected static Map<String, DependentPackage> dependencyMap = new HashMap<>();

    private static Dependencies dependencies = null;

    //Singleton instance creation
    public static Dependencies getInstance(){

        if(dependencies == null){
            dependencies = new Dependencies();
        }
        return dependencies;
    }

    public Map<String, DependentPackage> getAllDependencies(){
        return dependencyMap;
    }

    public DependentPackage getDependency(String key){
        return dependencyMap.get(key);
    }

    public void addDendency(String key, DependentPackage dependents){
        dependencyMap.put(key, dependents);
    }

    public void init(){
        dependencyMap = new HashMap<>();
    }
}
