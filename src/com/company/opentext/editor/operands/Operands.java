package com.company.opentext.editor.operands;

import java.util.ArrayList;
import java.util.List;

public class Operands {

    private String inputString;
    private final List<String> lines;
    private int lineNumber;
    private final String filePath;

    public Operands(String filePath, List<String> lines){
        this.filePath = filePath;
        this.lines=lines;
    }

    public String getInputString() {
        return inputString;
    }

    public void setInputString(String inputString) {
        this.inputString = inputString;
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    public String getFilePath() {
        return filePath;
    }

    public List<String> getLines() {
        return lines;
    }
}
