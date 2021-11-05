package com.salesforce.tests.dependency;

import com.salesforce.tests.dependency.commands.ICommand;
import com.salesforce.tests.dependency.commands.impl.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.IntStream;

/**
 * The entry point for the Test program
 */
public class Main {


    private static Map<String, ICommand> commands = new HashMap<>();

    static{
        commands.put("DEPEND", new Depend());
        commands.put("INSTALL", new Install());
        commands.put("REMOVE", new Remove());
        commands.put("LIST", new List());
        commands.put("END", null);
    }


    public static void main(String[] args) {


        //read input from stdin
        Scanner scan = new Scanner(System.in);

        while (true) {
            String line = scan.nextLine();

            //no action for empty input
            if (line == null || line.length() == 0) {
                continue;
            }

            //the END command to stop the program
            if ("END".equals(line)) {

                System.out.println("END");
                break;
            }

            //Please provide your implementation here

            Dependencies.getInstance().init();
            String[] commandlineArr = line.split("\\s+");

            ICommand command = commands.get(commandlineArr[0]);

            if(command == null){
                throw new RuntimeException("Invalid Command");
            }

            String[] packages = IntStream.range(1, commandlineArr.length).mapToObj(i -> commandlineArr[i]).toArray(String[]::new);
            System.out.println(line);
            command.execute(Arrays.asList(packages));
        }

    }
}