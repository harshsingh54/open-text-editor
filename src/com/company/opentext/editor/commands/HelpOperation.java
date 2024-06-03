package com.company.opentext.editor.commands;


public class HelpOperation implements Operations {
    @Override
    public void operate() {
        System.out.println("Commands:");
        System.out.println("h - help");
        System.out.println("quit - quits application");
        System.out.println("list - list lines");
        System.out.println("del - delete line");
        System.out.println("ins - modify line");
        System.out.println("save - save to file");
    }
}
