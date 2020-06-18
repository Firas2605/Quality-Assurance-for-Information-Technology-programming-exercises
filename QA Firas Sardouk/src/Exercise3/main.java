package Exercise3;
import java.util.Scanner;

public class main {

    public static void main(String args[])  {
    	Scanner input = new Scanner(System.in);
    	System.out.println("Enter your password: ");
    	String password = input.nextLine();
        new passwordVerifier().Verify(password);
    }
}