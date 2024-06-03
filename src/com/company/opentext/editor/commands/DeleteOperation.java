package com.company.opentext.editor.commands;


import com.company.opentext.editor.operands.Operands;

import java.util.List;

public class DeleteOperation implements Operations {
    @Override
    public void operate(Operands operands) {
        List<String> lines = operands.getLines();
        int lineNum = operands.getLineNumber();
            lines.remove(lineNum);
            System.out.println("Line deleted.");
    }
}
