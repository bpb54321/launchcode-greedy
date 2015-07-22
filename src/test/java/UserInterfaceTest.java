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
    public void testWelcomeCase() {
        CoinCalculator coinCalculator = new CoinCalculator();
        assertEquals(coinCalculator.WELCOME_MESSAGE,coinCalculator.userInterface("welcome"));
    }

    @Test
    public void testPromptCase() {
        CoinCalculator coinCalculator = new CoinCalculator();
        assertEquals(coinCalculator.PROMPT_MESSAGE,coinCalculator.userInterface("prompt"));
    }

    @Test
    public void testQuitCase() {
        CoinCalculator coinCalculator = new CoinCalculator();
        assertEquals(coinCalculator.QUIT_MESSAGE,coinCalculator.userInterface("q"));
    }

    @Test
    public void testChangeCalculateCase1() {
        CoinCalculator coinCalculator = new CoinCalculator();
        assertEquals(coinCalculator.CHANGE_MESSAGE + "1 quarter, 1 nickel, 3 pennies",coinCalculator.userInterface(".33"));
    }

    @Test
    public void testChangeCalculateCase2() {
        CoinCalculator coinCalculator = new CoinCalculator();
        assertEquals(coinCalculator.CHANGE_MESSAGE + "3 quarters, 1 nickel, 2 pennies",coinCalculator.userInterface(".82"));
    }

    /*@Test
    public void testDefaultCase() {
        CoinCalculator coinCalculator = new CoinCalculator();
        assertEquals("This is the default case.",coinCalculator.userInterface("This string could be anything."));
    }*/


    /*@Test
    public void compareSampleInputAndOutput() throws FileNotFoundException {
        CoinCalculator coinCalculator = new CoinCalculator();

        File sampleOutputFile=new File("Sample_Output.txt");
        File sampleInputFile=new File("Sample_Input.txt");
        Scanner outputScanner = new Scanner(sampleOutputFile);
        Scanner inputScanner = new Scanner(sampleInputFile);
        String curInput, actualOutput, expectedOutput = null;

        while (inputScanner.hasNext()) {
            curInput = inputScanner.nextLine();
            expectedOutput = outputScanner.nextLine();
            if (!curInput.contentEquals("Reading display.")) {
                actualOutput = coinCalculator.userInterface(curInput);
                assertEquals(expectedOutput, actualOutput);
            }
        }
    }*/



    /*@Test
    public void checkFirstLineOfExpectedOutput() throws FileNotFoundException {
        CoinCalculator coinCalculator = new CoinCalculator();
        File sampleOutputFile=new File("Sample_Output.txt");
        try (Scanner theScanner = new Scanner(sampleOutputFile)) {
            String firstLine = theScanner.nextLine();

            assertEquals(coinCalculator.WELCOME_MESSAGE,firstLine);
        }

    }*/
    /*
    @Test
    public void checkFirstLine() throws FileNotFoundException {
        File sampleInputFile=new File("Sample_Input.txt");
        try (Scanner theScanner= new Scanner(sampleInputFile)) {
            String firstLine=theScanner.nextLine();

            assertEquals("$3.33",firstLine);

        }

    }*/

    /*@Test
    public void checkSecondLine() throws FileNotFoundException {
        File sampleInputFile=new File("Sample_Input.txt");
        try (Scanner theScanner= new Scanner(sampleInputFile)) {
            String firstLine=theScanner.nextLine();
            String secondLine=theScanner.nextLine();

            assertEquals("$0.98",secondLine);

        }

    }*/
}
