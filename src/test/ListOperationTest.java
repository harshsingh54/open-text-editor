package test;

import com.company.opentext.editor.commands.ListOperation;
import org.junit.jupiter.api.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ListOperationTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    private final String lineConstant1= "Testing line 1";
    private final String lineConstant2= "Testing line 2";
    private final String lineConstant3= "Testing line 3";
    private final String lineConstant4= "Testing line 4";

    ListOperation listOperation;

    @BeforeEach
    public void initialize(){
        System.setOut(new PrintStream(outputStreamCaptor));

        List<String> lines = Arrays.asList(lineConstant1, lineConstant2, lineConstant3, lineConstant4);
        listOperation= new ListOperation(lines);

    }

    @Test
    public void listOperationTest(){

        System.setOut(new PrintStream(outputStreamCaptor));

        listOperation.operate();

        String expectedOutput = "1: "+ lineConstant1 + System.lineSeparator() +
                "2: "+ lineConstant2 + System.lineSeparator() +
                "3: "+ lineConstant3 + System.lineSeparator()+
                "4: "+ lineConstant4 + System.lineSeparator();

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }


    @AfterEach
    public void clean(){
        System.setOut(standardOut);
    }

}
