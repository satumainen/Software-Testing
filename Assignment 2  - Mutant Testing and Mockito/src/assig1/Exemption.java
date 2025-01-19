package assig2;

public class Exemption {
    public double getExemptionValue(int children) {
       /*
       decides value to use according to no children
       @Param children number of children for which to calculate
        */
        if (children <= 3)
            return 4000; //TODO
        else
            return 3000; //TODO
    }
}