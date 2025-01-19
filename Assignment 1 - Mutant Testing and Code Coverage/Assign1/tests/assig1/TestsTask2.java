package assig1;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TestsTask2 {

    //Test path [1,2,3,4,8,9,10,11,12,14,15,9,16,17,19]
    //no income
    @Test
    public void EC1() {
        double[] incomeList = {};
        int[] childAgeList = {1, 2, 3, 4};
        assertEquals(0, TaxCalculator.computeTax(incomeList, childAgeList));
    }


    //Test path [1,2,3,4,5,7,4,8,9,10,11,12,13,15,9,16,17,18]
    //less than 3 minor children
    @Test
    public void EC2() {
        double[] incomeList = {10000, 5000, 4800, 560};
        int[] childAgeList = {1};
        assertEquals(72, TaxCalculator.computeTax(incomeList, childAgeList));
    }

    //Test path [1,2,3,4,5,6]
    // //negative input in income list
    @Test
    public void EC3() {
        double[] incomeList = {-5000};
        int[] childAgeList = {1};
        assertEquals(-1, TaxCalculator.computeTax(incomeList, childAgeList));
    }

    //Test path [1,2,3,4,8,9,10,15,9,16,17,19]
    //no income, but has kids over 18
    @Test
    public void EC4() {
        double[] incomeList = {};
        int[] childAgeList = {19};
        assertEquals(0, TaxCalculator.computeTax(incomeList, childAgeList));
    }


    //Test path [1,2,3,4,5,7,4,8,9,10,11,12,14,15,9,10,11,12,13,15,9,10,15,9,16,17,18]
    //first four children under 18, then one over 18
    @Test
    public void EPC1() {
        double[] incomeList = {100000};
        int[] childAgeList = {1, 2, 3, 4, 19};
        assertEquals(5000, TaxCalculator.computeTax(incomeList, childAgeList));
    }

    //Test path [1,2,3,4,5,7,4,5,7,4,5,6]
    //first positive income, then negative
    @Test
    public void EPC2() {
        double[] incomeList = {500, -1500};
        int[] childAgeList = {1, 2, 3};
        assertEquals(-1, TaxCalculator.computeTax(incomeList, childAgeList));
    }


    //Test path [1,2,3,4,8,9,16,17,18]
    //no income, no kids, result > 0
    @Test
    public void AllDefTaxAmount() {
        double[] incomeList = {};
        int[] childAgeList = {};
        assertEquals(0, TaxCalculator.computeTax(incomeList, childAgeList));
    }

    //Test path [1,2,3,4,5,7,4,8,9,16,17,18]
    //income exists, no kids
    @Test
    public void AllUsesIncomeAmount1() {
        double[] incomeList = {100000};
        int[] childAgeList = {};
        assertEquals(20000, TaxCalculator.computeTax(incomeList, childAgeList));
    }

//Added extra tests for conditional boundaries

    //test for checking < vs =< for income in first loop
    @Test
    public void IncomeZero() {
        double[] incomeList = {0};
        int[] childAgeList = {};
        assertNotEquals(-1, TaxCalculator.computeTax(incomeList, childAgeList));
        assertEquals(0, TaxCalculator.computeTax(incomeList, childAgeList));
    }

    //Test for checking kids age < vs =<
    @Test
    public void NotChild18() {
        double[] incomeList = {50000};
        int[] childAgeList = {18};
        assertNotEquals(6000, TaxCalculator.computeTax(incomeList, childAgeList));
    }

}