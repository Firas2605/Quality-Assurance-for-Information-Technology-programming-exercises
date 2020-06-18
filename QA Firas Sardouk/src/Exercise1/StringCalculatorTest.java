package Exercise1;


import org.junit.Test;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

import org.junit.BeforeClass;

public class StringCalculatorTest {
	
	public static StringCalculator stringCalculator;
	   
	@BeforeClass
	public static void beforeClass() {
		stringCalculator = new StringCalculator();
	}
	
	// Testing the private function hasCustomDelimiter
	@Test
    public void privateHasCustomDelimiter() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
        String input = "//[x][y]\\n1x2y3";
 
        Method method = StringCalculator.class.getDeclaredMethod("hasCustomDelimiter", String.class);
        method.setAccessible(true);
        boolean output = (boolean) method.invoke(stringCalculator, input);
 
        assertTrue(output);
	}
	
	// Testing the private function isEmpty
	@Test
    public void privateIsEmpty() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
        String input = "";
 
        Method method = StringCalculator.class.getDeclaredMethod("isEmpty", String.class);
        method.setAccessible(true);
        boolean output = (boolean) method.invoke(stringCalculator, input);
 
        assertTrue(output);
	}
	
	// Testing the private function isNegative ( < 0 )
	@Test
    public void privateIsNegative() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
        Integer input = -5;
 
        Method method = StringCalculator.class.getDeclaredMethod("isNegative", Integer.class);
        method.setAccessible(true);
        boolean output = (boolean) method.invoke(stringCalculator, input);
 
        assertTrue(output);
	}
	
	// Testing the private function isInValidRange ( < 1000 )
	@Test
    public void privateIsInValidRange() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
        Integer input = 998;
 
        Method method = StringCalculator.class.getDeclaredMethod("isInValidRange", Integer.class);
        method.setAccessible(true);
        boolean output = (boolean) method.invoke(stringCalculator, input);
 
        assertTrue(output);
	}
	
	// Testing the private function hasNegativeTokens
	@Test
    public void privateHasNegativeTokens() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
		List<String> input = Arrays.asList("1");
 
        Method method = StringCalculator.class.getDeclaredMethod("hasNegativeTokens", List.class);
        method.setAccessible(true);
        boolean output = (boolean) method.invoke(stringCalculator, input);
 
        assertTrue(output);
	}
	
	// Testing the private function addSingleToken
	@Test
    public void privateAddSingleToken() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
		String input1 = "1";
		List<String> input2 = Arrays.asList("");
        Method method = StringCalculator.class.getDeclaredMethod("addSingleToken", String.class, List.class);
        method.setAccessible(true);
        int output = (int) method.invoke(stringCalculator, input1, input2);
 
        assertEquals(output, 1);
	}
	
	// Testing the private function calculateSum
	/*@Test
    public void privateCalculateSum() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
		String[] input1 = {"1","2","3"};
		List<String> input2 = Arrays.asList("");
		
        Method method = StringCalculator.class.getDeclaredMethod("calculateSum", String[].class, List.class);
        method.setAccessible(true);
		int output = (int) method.invoke(stringCalculator, input1, input2);
		 
		assertEquals(output, 6);
	}*/
	
	// Testing all conditions and possibilities
	
    @Test
    public void shouldReturnsZeroWhenEmptyString() {
        assertEquals(0, StringCalculator.add(""));
    }

    @Test
    public void shouldReplyTheValueWhenSingleNumber1() {
        assertEquals(1, StringCalculator.add("1"));
    }

    @Test
    public void shouldReplyTheValueWhenSingleNumber2() {
        assertEquals(2, StringCalculator.add("2"));
    }

    @Test
    public void shouldReturnSumWhenTwoNumbersCommaDelimited() {
        assertEquals(3, StringCalculator.add("1,2"));
    }
    
    @Test
    public void shouldReturnSumWhenThreeNumbersCommaDelimited() {
        assertEquals(6, StringCalculator.add("1,2,3"));
    }

    @Test
    public void shouldReturnSumWhenTwoNumbersNewLineDelimited() {
        assertEquals(3, StringCalculator.add("1\n2"));
    }
    
    @Test
    public void shouldReturnSumWhenThreeNumbersNewLineDelimited() {
        assertEquals(6, StringCalculator.add("1\n2\n3"));
    }
    
    @Test
    public void shouldReturnSumWhenThreeNumbersCommaAndNewLineDelimited() {
        assertEquals(6, StringCalculator.add("1,2\n3"));
    }

    @Test
    public void shouldReturnSumWhenTwoNumbersCustom1Delimited() {
        assertEquals(3, StringCalculator.add("//[x]\n2x1"));
    }

    @Test
    public void shouldReturnSumWhenTwoNumbersCustom2Delimited() {
        assertEquals(3, StringCalculator.add("//[xx]\n2xx1"));
    }

    @Test
    public void shouldReturnSumWhenThreeNumbersWithTwoDifferentCustomDelimiters() {
        assertEquals(6, StringCalculator.add("//[x][y]\n1x2y3"));
    }

    @Test
    public void shouldReturnExceptionWhenSingleNegativeValue() {
        try {
            StringCalculator.add("-1");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed (-1)", e.getMessage());
        }
    }

    @Test
    public void shouldReturnExceptionWhenTwoNegativeValues() {
        try {
            StringCalculator.add("-1,-2");
            fail();
        } catch (IllegalArgumentException e) {
            assertEquals("negatives not allowed (-1,-2)", e.getMessage());
        }
    }

    @Test
    public void shouldRturnSumAndIgnoreNumbersGreaterThan1000() {
        assertEquals(3, StringCalculator.add("1,2,1002"));
    }
}
