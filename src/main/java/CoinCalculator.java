import java.util.Scanner;

/**
 * User: Brian Blosser
 * Date: 7/19/15
 * Time: 8:31 pm
 */
public class CoinCalculator {
    public String CHANGE_MESSAGE = "Please provide the customer the following change: ";
    public String QUIT_MESSAGE = "You have quit the program, goodbye!";
    public String WELCOME_MESSAGE = "Welcome to the Greedy program. This program specifies how to provide coin change using the " +
            "fewest number of coins possible. Type 'q' and Enter to exit the program at any time.";
    public String PROMPT_MESSAGE = "Please enter the amount of change you wish to provide, using a " +
            "decimal point, for example $3.33.";
    public String INVALID_INPUT_MESSAGE = "Invalid input!";

    public static void main(String[] args) {

        CoinCalculator coinCalculator = new CoinCalculator();
        String inputString,outputString;

        try(Scanner inputScanner = new Scanner(System.in)) {

            System.out.println(coinCalculator.userInterface("welcome"));

            programLoop:
            while (true) {
                outputString = coinCalculator.userInterface("prompt");
                System.out.println(outputString);

                inputString = inputScanner.nextLine();
                outputString = coinCalculator.userInterface(inputString);
                System.out.println(outputString);

                if (inputString.equals("q")) {
                    break programLoop;
                }
            }
        }


    }


    public String calculateChange(String amountOfChange) {
        int change = Integer.parseInt(amountOfChange.substring(amountOfChange.length() - 2));
        int numOfCoins;
        String coinMessage = "";
        int[] denoms = {25, 10, 5, 1};
        String[] denomStringsSingular = {"quarter", "dime", "nickel", "penny"};
        String[] denomStringsPlural = {"quarters", "dimes", "nickels", "pennies"};//Dealing with plural spelling.

        if (change > 0) {
            for (int i = 0; i < denoms.length; i++) {

                numOfCoins = change / denoms[i];

                if (numOfCoins > 1) {
                    coinMessage += numOfCoins + " " + denomStringsPlural[i] + ", ";
                } else if (numOfCoins == 1) {
                    coinMessage += numOfCoins + " " + denomStringsSingular[i] + ", ";
                } else {
                    //Do not add anything to coinMessage.
                }
                change = change % denoms[i];
                if (change == 0) { //coins go in evenly
                    break;
                }
            }
            coinMessage = coinMessage.substring(0, coinMessage.length() - 2); //Trim extra comma and space at end.

        } else {
            coinMessage = "No coins returned";
        }

        return coinMessage;
    }

    public String userInterface(String currentInputString) {

        String currentOutputString;

        switch (currentInputString) {
            case "welcome":
                currentOutputString = this.WELCOME_MESSAGE;
                return currentOutputString;
            case "prompt":
                currentOutputString = this.PROMPT_MESSAGE;
                return currentOutputString;
            case "q":
                currentOutputString = this.QUIT_MESSAGE;
                return currentOutputString;
            default:
                if (!verifyInput(currentInputString)) {
                    currentOutputString = this.INVALID_INPUT_MESSAGE;
                } else {
                    currentOutputString = this.calculateChange(currentInputString);
                    currentOutputString = this.CHANGE_MESSAGE + currentOutputString;
                }
                return currentOutputString;
        }
    }

    public boolean verifyInput(String input) {

        int minStringLength = 3;

        if (input.length() < minStringLength) {
            return false;
        } else {
            String shouldBeDecimalPoint = input.substring(input.length() - minStringLength, (input.length() - minStringLength) + 1 );
            if (!".".equalsIgnoreCase(shouldBeDecimalPoint)) {//If 3rd char from end is not a decimal point
                return false;
            } else {
                try {
                    Integer.parseInt(input.substring(input.length() - 2));

                } catch (NumberFormatException n) {
                    return false;
                }
                return true;
            }
        }
    }

}
