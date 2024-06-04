package test;


import com.company.opentext.editor.LineEditor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LineEditorTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    LineEditor lineEditor;

    @BeforeEach
    public void initialize(){
        System.setOut(new PrintStream(outputStreamCaptor));

        String input ="list" + System.lineSeparator()
                + "quit";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
        lineEditor= new LineEditor();
    }

    @Test
    public void lineEditorOpenListAndQuitTest() throws NoSuchMethodException {

        Method method = lineEditor.getClass().getDeclaredMethod("openFile", String.class);
        method.setAccessible(true);

        try {
            String fileName = "src//files//sample_test_file.txt";
            method.invoke(lineEditor, fileName);
        } catch (IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        lineEditor.run();

        String expectedOutput = "File opened."+ System.lineSeparator() +
                ">>: 1: Hello"+ System.lineSeparator() +
                "2: World"+ System.lineSeparator() +
                "3: and ..."+ System.lineSeparator() +
                "4: everyone" +System.lineSeparator()+
                ">>: Quitting application.."+System.lineSeparator();

        assertEquals(expectedOutput, outputStreamCaptor.toString());
    }

    @AfterEach
    public void clean(){
        System.setOut(standardOut);
    }

}
