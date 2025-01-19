package assig1;

public class Calendar {

    //this is the method to be used for Task1
    public static int calculateDaysInMonth(int month, int year) {
        /** Determines the number of days in a month
         * Adapted from JAVA PROGRAMMING: FROM THE BEGINNING, by K. N. King //
         * Copyright (c) 2000 W. W. Norton & Company, Inc.
         * MonthLength.java (Chapter 8, page 313)
         * @return number of days, or -1 if invalid input
         */

        // Terminate program if month is not between 1 and 12
        if (month < 1 || month > 12 || year < 0 ) {
            System.out.println("Month must be between 1 and 12, Year must be greater than 0 ");
            return -1;
        }

        // Determine the number of days in the month
        int numberOfDays;
        switch (month) {
            case 2:  // February
                numberOfDays = 28;
                if (year % 4 == 0) {
                    numberOfDays = 29;
                    if (year % 100 == 0 && year % 400 != 0)
                        numberOfDays = 28;
                }
                break;
            case 4:  // April
            case 6:  // June
            case 9:  // September
            case 11: // November
                numberOfDays = 30;
                break;

            default: numberOfDays = 31;
                break;
        }

        // Display the number of days in the month
        System.out.println("There are " + numberOfDays + " days in this month");

        return numberOfDays;
    }

}
