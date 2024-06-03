package com.company.opentext.editor.commands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveOperation implements Operations {

    private List<String> lines;
    private String fileName;

    public SaveOperation(String fileName, List<String> lines){
        this.lines = lines;
        this.fileName=fileName;
    }

    @Override
    public void operate() {
        List<String> lines = this.lines;
        String filename = this.fileName;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (String line : lines) {
                writer.write(line);
                writer.newLine();
            }
            System.out.println("File saved.");
        } catch (IOException e) {
            System.out.println("An error occurred while saving the file.");
            e.printStackTrace();
        }
    }
}
