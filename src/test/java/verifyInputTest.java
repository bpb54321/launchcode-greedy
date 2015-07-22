import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by brianblosser on 7/21/15.
 */
public class verifyInputTest {

    @Test
    public void twoDigitStringReturnsFalse() {
        CoinCalculator coinCalculator = new CoinCalculator();
        assertEquals(false,coinCalculator.verifyInput("00"));
    }
    @Test
    public void oneDigitStringReturnsFalse() {
        CoinCalculator coinCalculator = new CoinCalculator();
        assertEquals(false,coinCalculator.verifyInput("0"));
    }
    @Test
    public void lettersReturnFalse() {
        CoinCalculator coinCalculator = new CoinCalculator();
        assertEquals(false,coinCalculator.verifyInput("abcdefg"));
    }
    @Test
    public void standardMoneyFormatReturnsTrue() {
        CoinCalculator coinCalculator = new CoinCalculator();
        assertEquals(true,coinCalculator.verifyInput("$53.76"));
    }

}
