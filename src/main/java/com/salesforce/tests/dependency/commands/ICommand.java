package com.salesforce.tests.dependency.commands;


import java.util.List;

/**
 * ICommand is an interface
 */
public interface ICommand {
    void execute(List<String> packages);
}
