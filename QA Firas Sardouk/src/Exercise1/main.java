package Exercise1;
/*import java.util.Scanner;

public class main {

    public static void main(String args[])  {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter the numbers: ");
    	String numbers = input.nextLine();
        new StringCalculator();
        System.out.println(StringCalculator.add(numbers));
    }*/
    
   public class main {

        public static void main(String args[])  {
            new StringCalculator();
            System.out.println(StringCalculator.add(""));
            System.out.println(StringCalculator.add("0"));
            System.out.println(StringCalculator.add("1"));
            System.out.println(StringCalculator.add("1,2"));
            System.out.println(StringCalculator.add("1,2,3"));
            System.out.println(StringCalculator.add("1,2\n3"));
            System.out.println(StringCalculator.add("//[--]\n1--2"));
            System.out.println(StringCalculator.add("//[--]\n1--2--3--4"));
            System.out.println(StringCalculator.add("//[x][y][z]\n1x2z3y4y5x6"));
            System.out.println(StringCalculator.add("1000,1,2,7"));
            System.out.println(StringCalculator.add("1,2,1002"));
            System.out.println(StringCalculator.add("-1,2"));
        }
}
