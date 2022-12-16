package com.martin.utils;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class ConsoleParser {
    private final Scanner scanner;
    private final PrintStream out;

    public ConsoleParser(InputStream in, PrintStream out) {
        scanner = new Scanner(in);
        this.out = out;

    }

    public int promptInt(String message, int defaultInt) {
        out.print(message);
        /* if (!scanner.hasNextInt() ) {
            return defaultInt;
        } */
        return scanner.nextInt();
    }

    public int getStringsChoiceIndex(String message, String [] entries) {
        out.println(message);
        for (int i = 0; i < entries.length; i++) {
            out.print(i + ". ");
            out.println(entries[i]);
        }
        int choice;
        do {
            choice = promptInt(" Votre choix : ", -1);
        } while (choice < 0 || choice > entries.length);
        out.println("\n Tu choisis : " + entries[choice]);
        return choice;
    }
}