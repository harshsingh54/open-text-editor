package com.company.opentext.editor;

import com.company.opentext.editor.commands.*;
import com.company.opentext.editor.operands.Operands;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LineEditor {
    private List<String> lines;
    private Scanner scanner;
    private String filePath;

    public LineEditor() {
        lines = new ArrayList<>();
        scanner = new Scanner(System.in);
        filePath = new String();
    }

    public static void main(String[] args) {

        if (args.length != 1) {
            System.out.println("Incorrect input for fileName");
            return;
        }

        LineEditor editor = new LineEditor();
        editor.openFile(args[0]);
        editor.run();
    }

    public void run() {
        boolean running = true;

        while (running) {
            System.out.print(">>: ");
            String command = scanner.nextLine().trim();
            switch (command) {
                case "h":
                    printHelp();
                    break;
                case "quit":
                    running = false;
                    break;
                case "list":
                    listLines();
                    break;
                case "del":
                    deleteLine();
                    break;
                case "ins":
                    modifyLine();
                    break;
                case "save":
                    saveToFile();
                    break;
                default:
                    System.out.println("Unknown command. Type 'h' for help.");
            }
        }
    }

    private void printHelp() {
        System.out.println("Commands:");
        System.out.println("h - help");
        System.out.println("quit - quits application");
        System.out.println("list - list lines");
        System.out.println("del - delete line");
        System.out.println("ins - modify line");
        System.out.println("save - save to file");
    }

    private void listLines() {
        String filePath =this.filePath;
        Operands operands= new Operands(filePath, lines);
        ListOperation operation = new ListOperation();
        operation.operate(operands);
    }

    private void deleteLine() {
        System.out.print("Enter the line number to delete: ");
        int lineNumber = Integer.parseInt(scanner.nextLine()) - 1;
        if (lineNumber >= 0 && lineNumber < lines.size()) {
            Operands operands = new Operands(filePath, lines);
            operands.setLineNumber(lineNumber);

            DeleteOperation deleteOperation = new DeleteOperation();
            deleteOperation.operate(operands);

        } else {
            System.out.println("Invalid line number.");
        }
    }

    private void modifyLine() {
        System.out.print("Enter the line number to modify: ");
        int lineNumber = Integer.parseInt(scanner.nextLine()) - 1;
        if (lineNumber >= 0 && lineNumber <= lines.size()) {
            System.out.print("Enter the new line: ");
            String newLine = scanner.nextLine();

            Operands operands = new Operands(filePath, lines);
            operands.setInputString(newLine);
            operands.setLineNumber(lineNumber);

            InsertOperation insertOperation = new InsertOperation();
            insertOperation.operate(operands);
        } else {
            System.out.println("Invalid line number.");
        }
    }

    private void saveToFile() {
        Operands operands = new Operands(filePath, lines);

        SaveOperation saveOperation = new SaveOperation();
        saveOperation.operate(operands);
    }

    private void openFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            lines.clear();
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
            System.out.println("File opened.");
            this.filePath=filename;
        } catch(FileNotFoundException e){
            System.out.println("File not found:"+filename);
            System.out.println("Error: "+ e.getMessage());
        } catch(IOException e) {
            System.out.println("An error occurred while opening the file.");
            e.printStackTrace();
        }
    }
}
