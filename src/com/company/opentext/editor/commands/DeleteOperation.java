package com.company.opentext.editor.commands;


import java.util.List;
import java.util.Scanner;

public class DeleteOperation implements Operations {
    private List<String> lines;
    private Scanner scanner;

    public DeleteOperation(List<String> lines, Scanner scanner){
        this.lines = lines;
        this.scanner = scanner;
    }

    @Override
    public void operate() {

        System.out.print("Enter the line number to delete: ");
        int lineNumber = Integer.parseInt(scanner.nextLine()) - 1;
        if (lineNumber >= 0 && lineNumber < lines.size()) {
            lines.remove(lineNumber);
            System.out.println("Line deleted.");
        } else {
            System.out.println("Invalid line number.");
        }

    }
}
