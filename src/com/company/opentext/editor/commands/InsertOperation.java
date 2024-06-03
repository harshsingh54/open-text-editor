package com.company.opentext.editor.commands;

import com.company.opentext.editor.operands.Operands;

import java.util.List;

public class InsertOperation implements Operations {
    @Override
    public void operate(Operands operands) {
        List<String> lines = operands.getLines();
        String input = operands.getInputString();
        int lineNum = operands.getLineNumber();

        if(lineNum>=0 && lineNum<=lines.size()){
            lines.add(lineNum, input);
            System.out.println("Line inserted at line number :"+ lineNum);
        }else{
            System.out.println("Incorrect line number : "+ lineNum);
        }

    }
}
