import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

/**
 * Created by brianblosser on 7/22/15.
 */
public class mainTest {

    @Test
    public void compareSampleInputAndOutput() throws FileNotFoundException {
        CoinCalculator coinCalculator = new CoinCalculator();

        File sampleOutputFile=new File("Sample_Output.txt");
        File sampleInputFile=new File("Sample_Input.txt");
        Scanner outputScanner = new Scanner(sampleOutputFile);
        Scanner inputScanner = new Scanner(sampleInputFile);
        String curInput, actualOutput, expectedOutput = null;
        int curOutputLine=1;

        while (inputScanner.hasNext()) {

            /*if (curOutputLine==1) {//Test that the first ouput line is always the welcome.
                actualOutput = coinCalculator.userInterface("welcome");
            }*/

            curInput = inputScanner.nextLine();
            expectedOutput = outputScanner.nextLine();
            actualOutput = coinCalculator.userInterface(curInput);
            assertEquals(expectedOutput, actualOutput);

        }
    }




}
