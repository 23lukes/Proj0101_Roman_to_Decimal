/**
 * This class converts roman numerals to their decimal values
 * @version 10.13.2022
 * @author Ona
 */



public class RomanToDecimal {
    /**
     * Converts Roman numerals to all upper case so that has no effect on invalididity. It also sets certain roman numerals to their decimal values so that there are fewer mistakes
     * @param roman A string representing a Roman numeral
     * @return decimal value of a Roman number
     */
    public static int romanToDecimal(String roman)  {
        int sum = 0;
        // convert to all one case
        roman = roman.toUpperCase();
        // "XI".length() => 2
        // "MCMLXII".length() => 7
        // "HAHA" ==> -1
        // "xlive"
        // 0123456 => 7
        // len(roman)
        // string.length()
        // array.length
        // list.size()
        for(int i = 0; i < roman.length(); i++) {
            if(roman.charAt(i) == 'I')
                sum += 1;
            else if(roman.charAt(i) == 'V')
                sum += 5;
            else if(roman.charAt(i) == 'X')
                sum += 10;
            else if(roman.charAt(i) == 'L')
                sum += 50;
            else if(roman.charAt(i) == 'C')
                sum += 100;
            else if(roman.charAt(i) == 'D')
                sum += 500;
            else if(roman.charAt(i) == 'M')
                sum += 1000;
            else
                return -1;
        }
        // INVARIANTS
        if(roman.indexOf("IV") != -1)
            sum -= 2;
        if(roman.indexOf("IX") != -1)
            sum -= 2;
        if(roman.indexOf("XL") != -1)
            sum -= 20;
        if(roman.indexOf("XC") != -1)
            sum -= 20;
        if(roman.indexOf("CD") != -1)
            sum -= 200;
        if(roman.indexOf("CM") != -1)
            sum -= 200;

        String test = decimalToRoman(sum);
        // roman = "IXIXIX" == 31
        // test = "XXXI"
        if(!roman.equals(test))
            return -2;
        return sum;
    }

    /**
     * This removes the illogical errors from the class
     * Worked with Riley on this part
     * @param decimal a decimal value
     * @return a Roman numeral that is correctly formed
     */
    public static String decimalToRoman(int decimal) {
        //"Ona" != " Ona";
        String romanlogical = "";
        while (decimal >= 1000) {
            romanlogical += "M";
            decimal -= 1000;
        }
        while (decimal >= 900) {
            romanlogical += "CM";
            decimal -= 900;
        }
        while (decimal >= 500) {
            romanlogical += "D";
            decimal -= 500;
        }
        while (decimal >= 400) {
            romanlogical += "CD";
            decimal -= 400;
        }
        while (decimal >= 100) {
            romanlogical += "C";
            decimal -= 100;
        }
        while (decimal >= 90) {
            romanlogical += "XC";
            decimal -= 90;
        }
        while (decimal >= 50) {
            romanlogical += "L";
            decimal -= 50;
        }
        while (decimal >= 40) {
            romanlogical += "XL";
            decimal -= 40;
        }
        while (decimal >= 10) {
            romanlogical += "X";
            decimal -= 1000;
        }
        while (decimal >= 9) {
            romanlogical += "IX";
            decimal -= 9;
        }
        while (decimal >= 5) {
            romanlogical += "V";
            decimal -= 5;
        }
        while (decimal >= 4) {
            romanlogical += "IV";
            decimal -= 4;
        }
        while (decimal >= 1) {
            romanlogical += "I";
            decimal -= 1;}
        return romanlogical;
    }


    /**
     * This is the main method of this class and it calls the inputs and organizes them into invalid, logically incorrect, and logical
     * @param args command line arguments
     */
    public static void main(String[] args) {
        for (String roman : args) {   // for-each loop
            int decimal = romanToDecimal(roman);
            //String romanTest = decimalToRoman(decimal);
            if (decimal == -1)
                System.out.println("Input: " + roman + " => output: invalid");
            else if(decimal == -2)
                System.out.println("Input: " + roman + " => output: logically incorrect");
            else
                System.out.println("Input: " + roman + " => output: " + decimal);
        }
    }
}
