package test;



import com.company.opentext.editor.commands.SaveOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SaveOperationTest {

    private final String lineConstant1= "Testing line 1";
    private final String lineConstant2= "Testing line 2";
    private final String lineConstant3= "Testing line 3";
    private final String lineConstant4= "Testing line 4";

    List<String> lines = Arrays.asList(lineConstant1, lineConstant2, lineConstant3, lineConstant4);

    private final String fileName = "output.txt";

    SaveOperation saveOperation;

    @BeforeEach
    public void initialize(){
        saveOperation= new SaveOperation(fileName, lines);
    }

    @Test
    public void saveOperationTest(){

        saveOperation.operate();

        List<String> actualLines = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                actualLines.add(line);
            }

        } catch(IOException e) {
            System.out.println("An error occurred while opening the file for unit test.");
            e.printStackTrace();
        }

        List<String> expectedOutput = lines;

        assertEquals(expectedOutput, actualLines);
    }

    @AfterEach
    public void clean(){
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
