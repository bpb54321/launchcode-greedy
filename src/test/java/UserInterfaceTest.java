import org.junit.Test;

import java.io.*;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by brianblosser on 7/20/15.
 * This is an attempt to automate a user's interaction with the program.
 */
public class UserInterfaceTest {

    @Test
    public void testPrinting() throws IOException {
        CoinCalculator coinCalculator = new CoinCalculator();



        try (FileInputStream inputStream = new FileInputStream("Sample_Input.txt");) {

            System.setIn(inputStream);
            coinCalculator.userInterface();
        }
    }
    @Test
    public void checkFirstLine() throws FileNotFoundException {
        File sampleInputFile=new File("Sample_Input.txt");
        try (Scanner theScanner= new Scanner(sampleInputFile)) {
            String firstLine=theScanner.nextLine();

            assertEquals("$3.33",firstLine);

        }

    }

    @Test
    public void checkSecondLine() throws FileNotFoundException {
        File sampleInputFile=new File("Sample_Input.txt");
        try (Scanner theScanner= new Scanner(sampleInputFile)) {
            String firstLine=theScanner.nextLine();
            String secondLine=theScanner.nextLine();

            assertEquals("$0.98",secondLine);

        }

    }
}
