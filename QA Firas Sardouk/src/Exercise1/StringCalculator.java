package Exercise1;

import org.apache.commons.lang3.StringUtils;
import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public static int add(String input) {

        String delimiter = "[,\n]";
        String numbersWithDelimiters;
        List<String> negativeTokens = new ArrayList<String>();

            if (isEmpty(input)) {
                return 0;
            }

            if (hasCustomDelimiter(input)) {

                delimiter = "";

                int startIndexDelimiter = 0;

                while (true) {

                    startIndexDelimiter = input.indexOf("[", startIndexDelimiter) + 1;

                    if (startIndexDelimiter == 0) {

                        break;
                    }

                    int endIndexDelimiter = input.indexOf("]", startIndexDelimiter);

                    delimiter += input.substring(startIndexDelimiter, endIndexDelimiter) + "|";
                }
                delimiter = StringUtils.chop(delimiter);

                int firstNewLine = input.indexOf("\n");

                numbersWithDelimiters = input.substring(firstNewLine + 1);
            }
           
            else {
                numbersWithDelimiters = input;
            }

            String[] inputSplittedByDelimiter = numbersWithDelimiters.split(delimiter);

            return calculateSum(inputSplittedByDelimiter, negativeTokens);
        }
    
    
    private static int calculateSum(String[] inputSplittedByDelimiter, List<String> negativeTokens) {
        int result = 0;
        for (String token : inputSplittedByDelimiter) {
            result += addSingleToken(token, negativeTokens);
        }
        if (hasNegativeTokens(negativeTokens)) {
            throw new IllegalArgumentException(String.format("negatives not allowed (%s)", StringUtils.join(negativeTokens, ",")));
        };
        return result;
    }
  
    private static int addSingleToken(String token, List<String> negativeTokens) {
        Integer valueAsInteger = Integer.parseInt(token);
        if (isNegative(valueAsInteger)) {
            negativeTokens.add(token);
        } else if (isInValidRange(valueAsInteger)) {
            return valueAsInteger;
        }
        return 0;
    }
    
    private static boolean hasNegativeTokens(List<String> negativeTokens) {
        return negativeTokens.size() > 0;
    }
    
	private static boolean isInValidRange(Integer valueAsInteger) {
		return valueAsInteger < 1000;
	}

	private static boolean isNegative(Integer valueAsInteger) {
		return valueAsInteger < 0;
	}

	private static boolean hasCustomDelimiter(String input) {
		return input.startsWith("//");
	}

	private static boolean isEmpty(String input) {
    	return input.isEmpty();
    }
	    
}