package assig1;

public class TaxCalculator {

    //this is the method to be used for Task1
    public static double computeTax(double[] incomeList, int[] childAgeList){
        /**
         * calculate the tax amount based on several income sources
         * and on the tax exemption based on the number of children
         */
        System.out.println("Computing tax....");
        // we use a flat tax rate
        final double FLAT_TAX_RATE = 0.2;
        double incomeAmount= 0.0;
        double taxExemption = 0.0;
        int noMinorChildren = 0;
        double taxAmount;

        // calculate net income
        for(double income: incomeList){
            if (income < 0)
                // income cannot be negative
                return -1;
            incomeAmount += income;
        }

        // calculate tax exemption for having children
        for(int i= 0; i< childAgeList.length; i++){
            //Note: sometimes we need to write tests for older-style code

            // tax exemption is given only for minor children
            // for 1-3 children, tax exemption is 4000 per child
            // starting with the 4th child the tax exemption is 3000 per child
            if (childAgeList[i] < 18){
                noMinorChildren = noMinorChildren + 1;
                if (noMinorChildren <= 3)
                    taxExemption = taxExemption + 4000;
                else
                    taxExemption = taxExemption + 3000;
            }
        }
        // calculate taxAmount based on income amount, flat tax rate and tax exemption
        taxAmount = incomeAmount * FLAT_TAX_RATE - taxExemption;

        if (taxAmount > 0)
            return taxAmount;
        else return 0;
    }
}
