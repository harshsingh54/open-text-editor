package com.company.opentext.editor;

import com.company.opentext.editor.commands.*;

import java.io.*;
import java.util.*;

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
        Map<String, Operations> operationsMap = new HashMap<>();

        ListOperation listOperation = new ListOperation(lines);
        operationsMap.put("list", listOperation);

        InsertOperation insertOperation = new InsertOperation(lines, scanner);
        operationsMap.put("ins", insertOperation);

        DeleteOperation deleteOperation = new DeleteOperation(lines, scanner);
        operationsMap.put("del", deleteOperation);

        SaveOperation saveOperation = new SaveOperation(filePath, lines);
        operationsMap.put("save", saveOperation);

        HelpOperation helpOperation = new HelpOperation();
        operationsMap.put("h", helpOperation);

        while (running) {
            System.out.print(">>: ");
            String command = scanner.nextLine().trim();

            if("quit".equals(command)){
                System.out.println("Quitting application..");
                running = false;
            }else if(operationsMap.containsKey(command)){
                operationsMap.get(command).operate();
            }else{
                System.out.println("Unknown command. Type 'h' for help.");
            }
        }
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
