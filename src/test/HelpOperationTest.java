package test;

import com.company.opentext.editor.commands.HelpOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HelpOperationTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    HelpOperation helpOperation;

    @BeforeEach
    public void initialize(){
        System.setOut(new PrintStream(outputStreamCaptor));
        helpOperation= new HelpOperation();

    }

    @Test
    public void helpOperationTest(){

        System.setOut(new PrintStream(outputStreamCaptor));

        helpOperation.operate();

        String expectedOutput = "Commands:" + System.lineSeparator() +
                "h - help" + System.lineSeparator() +
                "quit - quits application" + System.lineSeparator()+
                "list - list lines" + System.lineSeparator()+
                "del - delete line" + System.lineSeparator()+
                "ins - modify line" + System.lineSeparator()+
                "save - save to file" + System.lineSeparator();

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }


    @AfterEach
    public void clean(){
        System.setOut(standardOut);
    }

}
