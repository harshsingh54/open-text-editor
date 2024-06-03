package com.company.opentext.editor.commands;

import java.util.List;
import java.util.Scanner;

public class InsertOperation implements Operations {

    private List<String> lines;
    private Scanner scanner;

    public InsertOperation(List<String> lines, Scanner scanner){
        this.lines = lines;
        this.scanner = scanner;
    }

    @Override
    public void operate() {

        System.out.print("Enter the line number to modify: ");
        int lineNumber = Integer.parseInt(scanner.nextLine()) - 1;
        if (lineNumber >= 0 && lineNumber <= lines.size()) {
            System.out.print("Enter the new line: ");
            String newLine = scanner.nextLine();

            lines.add(lineNumber, newLine);
            System.out.println("Line inserted");

        } else {
            System.out.println("Invalid line number.");
        }

    }
}
