package assig2;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GraphTests {

    TaxCalculator2 TC = new TaxCalculator2();

    @Test
    public void TestPath1() {
        double[] incomeList = {0};
        int[] childAgeList = {18};
        assertEquals(0, TC.computeTax(incomeList, childAgeList));
    }

    @Test
    public void TestPath2() {
        double[] incomeList = {40000};
        int[] childAgeList = {0,18};
        assertEquals(4000, TC.computeTax(incomeList, childAgeList));
    }

}
