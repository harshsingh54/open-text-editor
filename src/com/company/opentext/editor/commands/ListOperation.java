package com.company.opentext.editor.commands;

import com.company.opentext.editor.operands.Operands;

import java.util.List;

public class ListOperation implements Operations {
    @Override
    public void operate(Operands operands) {
        List<String> lines = operands.getLines();
        if (lines.isEmpty()) {
            System.out.println("No lines to display.");
        } else {
            for (int i = 0; i < lines.size(); i++) {
                System.out.printf("%d: %s%n", i + 1, lines.get(i));
            }
        }

    }
}
