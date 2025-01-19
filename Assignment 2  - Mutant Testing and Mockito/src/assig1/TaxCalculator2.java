package assig2;

public class TaxCalculator2 {

    private Exemption ex;

    TaxCalculator2(){
        System.out.println("Calculator2 initialized");
        ex = new Exemption();
    }

    public double computeTax(double[] incomeList, int[] childAgeList){

        System.out.println("Computing tax....");
        double taxAmount;
        double incomeAmount = 0.0;
        double taxExemption = 0.0;

        // calculate net income
        for(double income: incomeList){
            if (income < 0)
                // income cannot be negative
                return -1;
            incomeAmount += income;
        }
        System.out.println("Income: " +incomeAmount);

        taxAmount = incomeAmount * 0.2;

        System.out.println("Tax: " + taxAmount);

        taxExemption = this.getTaxExemption(childAgeList);
        System.out.println("Exemption: " + taxExemption);

        taxAmount = taxAmount - taxExemption;
        System.out.println("To pay: " + taxAmount);

        // tax amount cannot be negative
        if (taxAmount > 0)
            return taxAmount;
        else return 0;
    }

    private double getTaxExemption(int[] childAgeList) {
        // calculate tax exemption for having children
        double taxExemption = 0.0;
        int noMinorChildren = 0;

        for (int childAge: childAgeList) {
            // tax exemption is given only for minor children
            // for 1-3 children, tax exemption is 4000 per child
            // starting with the 4th child the tax exemption is 3000 per child
            if (childAge < 18) {
                noMinorChildren = noMinorChildren + 1;
                taxExemption =  taxExemption + this.ex.getExemptionValue(noMinorChildren);  //TODO
            }
        }
        return taxExemption;
    }

}
