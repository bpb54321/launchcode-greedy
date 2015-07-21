import java.util.Scanner;

/**
 * User: Brian Blosser
 * Date: 7/19/15
 * Time: 8:31 pm
 */
public class CoinCalculator {
    public String WELCOME_MESSAGE="Welcome to the Greedy program. This program specifies how to provide coin change using the " +
            "fewest number of coins possible. Type 'q' and Enter to exit the program at any time.";


    public String calculateChange(String amountOfChange) {
        int change = Integer.parseInt(amountOfChange.substring(amountOfChange.length() - 2));
        int numOfCoins;
        String coinMessage="";
        int[] denoms={25,10,5,1};
        String[] denomStringsSingular={"quarter", "dime", "nickel", "penny"};
        String[] denomStringsPlural={"quarters", "dimes", "nickels", "pennies"};//Dealing with plural spelling.

        if (change>0) {
            for (int i = 0; i < denoms.length; i++) {

                numOfCoins = change / denoms[i];

                if (numOfCoins > 1) {
                    coinMessage += numOfCoins + " " + denomStringsPlural[i] + ", ";
                } else if (numOfCoins==1) {
                    coinMessage += numOfCoins + " " + denomStringsSingular[i] + ", ";
                } else {
                    //Do not add anything to coinMessage.
                }
                change = change % denoms[i];
                if (change==0) { //coins go in evenly
                    break;
                }
            }
            coinMessage=coinMessage.substring(0,coinMessage.length()-2); //Trim extra comma and space at end.

        } else {
            coinMessage = "No coins returned";
        }

        return coinMessage;
    }

    public String userInterface(String currentInputString) {
        System.out.println(this.WELCOME_MESSAGE);

        String currentOutputString;

        programLoop:
        while (true) {
            System.out.println("Please enter the amount of change you wish to provide, using a dollar sign and " +
                    "decimal point, for example $3.33.");

            if (currentInputString.equals("q")) {
                return "You have quit the program, goodbye!";
            } else {
                //Do coin calculation.
                currentOutputString=this.calculateChange(currentInputString);
                currentOutputString="Please provide the customer the following change: " + currentOutputString;
                return currentOutputString;
            }


        }


    }
}
