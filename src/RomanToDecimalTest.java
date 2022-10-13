import static org.junit.Assert.*;
/**
 * This class runs tests on RomanToDecimal
 * @version 10.13.2022
 * @author Ona
 */
public class RomanToDecimalTest {

    /**
     * Sample test method
     */
    @org.junit.Test
    public void romanToDecimal() {
        // Logical
        assertEquals(RomanToDecimal.romanToDecimal("MXCIV"), 1094);
        assertEquals(RomanToDecimal.romanToDecimal("CM"), 900);
        assertEquals(RomanToDecimal.romanToDecimal("CD"), 400);
        assertEquals(RomanToDecimal.romanToDecimal("XC"), 90);
        assertEquals(RomanToDecimal.romanToDecimal("XL"), 40);
        assertEquals(RomanToDecimal.romanToDecimal("IX"), 9);
        assertEquals(RomanToDecimal.romanToDecimal("IV"), 4);
        assertEquals(RomanToDecimal.romanToDecimal("MMCMXCIX"), 2999);
        assertEquals(RomanToDecimal.romanToDecimal("CMXCIV"), 994);
        assertEquals(RomanToDecimal.romanToDecimal("MMCDIX"), 2409);

        // Logically invalid
        assertEquals(RomanToDecimal.romanToDecimal("CIXIX"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("IVIVIVIXIXIX"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("IVIXCI"), -2);
        assertEquals(RomanToDecimal.romanToDecimal("IVIVIV"), -2);

        // Invalid
        assertEquals(RomanToDecimal.romanToDecimal("XCISDABEST"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("ISIS"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("HAHA"), -1);
        assertEquals(RomanToDecimal.romanToDecimal("JCOCHRAN"), -1);

        assertNotEquals(RomanToDecimal.romanToDecimal("your mom"), 100);
    }
}