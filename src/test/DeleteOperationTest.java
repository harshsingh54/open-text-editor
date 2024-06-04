package test;


import com.company.opentext.editor.commands.DeleteOperation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DeleteOperationTest {

    private final String lineConstant1= "Testing line 1";
    private final String lineConstant2= "Testing line 2";
    private final String lineConstant3= "Testing line 3";
    private final String lineConstant4= "Testing line 4";

    List<String> lines = new ArrayList<>(Arrays.asList(lineConstant1, lineConstant2, lineConstant3, lineConstant4));

    DeleteOperation deleteOperation;

    @BeforeEach
    public void initialize(){

        String input ="4" + System.lineSeparator();
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        deleteOperation= new DeleteOperation(lines,scanner);

    }

    @Test
    public void deleteOperationTest(){

        deleteOperation.operate();

        int expectedOutput = 3;

        assertEquals(expectedOutput, lines.size());
    }

}
