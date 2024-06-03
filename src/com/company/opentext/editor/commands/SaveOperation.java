package com.company.opentext.editor.commands;

import com.company.opentext.editor.operands.Operands;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class SaveOperation implements Operations {
    @Override
    public void operate(Operands operands) {
        List<String> lines = operands.getLines();
        String filename = operands.getFilePath();
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
