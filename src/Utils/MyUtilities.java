package Utils;

//Some help from source: https://stackoverflow.com/questions/12558206/how-can-i-check-if-a-value-is-of-type-integer
//.compareTo source: https://www.geeksforgeeks.org/localdate-compareto-method-in-java/

import java.time.LocalDate;

public class MyUtilities {

    //detects whether string can be converted to integer or not
    public static boolean StringIsInt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //returns true if start date takes place before end date
    //compareTo returns a number indicating how much further before
    //or after the dates are from each-other
    public static boolean DateCompare(LocalDate lesserDate, LocalDate greaterDate) {
        return lesserDate.compareTo(greaterDate) <= 0;
    }

    //returns true if date in question is between lesser and greater dates.
    public static boolean DateBetween(LocalDate dateInQuestion, LocalDate lesserDate, LocalDate greaterDate) {
        return dateInQuestion.compareTo(lesserDate) >= 0 && dateInQuestion.compareTo(greaterDate) <= 0;
    }

    //detects whether string can be converted to double or not
    public static boolean StringIsDouble(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
