package com.company.opentext.editor.commands;

import java.util.List;

public class ListOperation implements Operations {

    private List<String> lines;

    public ListOperation(List<String> lines){
        this.lines = lines;
    }

    @Override
    public void operate() {
        List<String> lines = this.lines;
        if (lines.isEmpty()) {
            System.out.println("No lines to display.");
        } else {
            for (int i = 0; i < lines.size(); i++) {
                System.out.printf("%d: %s%n", i + 1, lines.get(i));
            }
        }
    }
}
