import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * User: mpmenne
 * Date: 6/18/14
 * Time: 3:28 AM
 */
public class CoinCalculatorTest {

    @Test
    public void testOfNinetyNineCents() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.99");

        assertEquals("3 quarters, 2 dimes, 4 pennies", coinMessage);
    }

    @Test
    public void test95Cents() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.95");

        assertEquals("3 quarters, 2 dimes", coinMessage);
    }

    @Test
    public void test91Cents() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.91");

        assertEquals("3 quarters, 1 dime, 1 nickel, 1 penny", coinMessage);
    }

    @Test
    public void test90Cents() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.90");

        assertEquals("3 quarters, 1 dime, 1 nickel", coinMessage);
    }

    @Test
    public void test81Cents() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.81");

        assertEquals("3 quarters, 1 nickel, 1 penny", coinMessage);
    }

    @Test
    public void test80Cents() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.80");

        assertEquals("3 quarters, 1 nickel", coinMessage);
    }


    @Test
    public void test50CentsShouldGiveTwoQuarters() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.50");

        assertEquals("2 quarters", coinMessage);
    }

    @Test
    public void tenCentsShouldGiveYouOneDime() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.10");

        assertEquals("1 dime", coinMessage);
    }

    @Test
    public void oneCentShouldGiveYouOnePenny() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$0.01");

        assertEquals("1 penny", coinMessage);
    }

    @Test
    public void zeroChangeMeansYouGetZeroCoins() {
        CoinCalculator coinCalculator = new CoinCalculator();

        String coinMessage = coinCalculator.calculateChange("$3.00");

        assertEquals("No coins returned", coinMessage);
    }









}
