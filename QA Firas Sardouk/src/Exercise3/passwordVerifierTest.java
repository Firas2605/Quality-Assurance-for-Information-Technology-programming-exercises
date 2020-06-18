package Exercise3;
import static org.junit.Assert.assertEquals;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import java.util.List;



public class passwordVerifierTest {
	
	public static passwordVerifier passwordVerifier;
	   
	@BeforeClass
	public static void beforeClass() {
	passwordVerifier = new passwordVerifier();
	}
	
	// Testing the private function verifyPasswordLength
	@Test
    public void privateVerifyPasswordLength() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
        String input = "Firas";
 
        Method method = passwordVerifier.class.getDeclaredMethod("verifyPasswordLength", String.class);
        method.setAccessible(true);
        List<String> output = (List<String>) method.invoke(passwordVerifier, input);
 
        assertEquals("Password length must have at least 8 characters", output.get(1));
	}
	
	// Testing the private function verifyAtleastSingleUpperCase
	@Test
    public void privateVerifyAtleastSingleUpperCase() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
        String input = "firas";
 
        Method method = passwordVerifier.class.getDeclaredMethod("verifyAtleastSingleUpperCase", String.class);
        method.setAccessible(true);
        List<String> output = (List<String>) method.invoke(passwordVerifier, input);
 
        assertEquals("Password must have at least one uppercase character", output.get(2));
	}
	
	// Testing the private function verifyAtleastSingleLowerCase
	@Test
    public void privateVerifyAtleastSingleLowerCase() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
        String input = "FIRAS";
 
        Method method = passwordVerifier.class.getDeclaredMethod("verifyAtleastSingleLowerCase", String.class);
        method.setAccessible(true);
        List<String> output = (List<String>) method.invoke(passwordVerifier, input);
 
        assertEquals("Password must have at least one lowercase character", output.get(3));
	}
	
	// Testing the private function verifyAtleastSingleNumber
	@Test
    public void privateVerifyAtleastSingleNumber() throws NoSuchMethodException,
            InvocationTargetException, IllegalAccessException {
 
        String input = "Firas";
 
        Method method = passwordVerifier.class.getDeclaredMethod("verifyAtleastSingleNumber", String.class);
        method.setAccessible(true);
        List<String> output = (List<String>) method.invoke(passwordVerifier, input);
 
        assertEquals("Password must have at least one number", output.get(1));
	}

    
	// Testing all the conditions and possibilities
	
	@SuppressWarnings("deprecation")
	@Rule
	public ExpectedException expectedEx = ExpectedException.none();

	@Test
	public void shouldThrowExceptionWhenPasswordIsLessThan8Characters() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password length must have at least 8 characters");

		passwordVerifier.Verify("firas");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordIsNull() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password should not be null");

		passwordVerifier.Verify("");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordHasNotAtleastOneUpperCaseCharacter() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password must have at least one uppercase character");

		passwordVerifier.Verify("firas");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordHasNotAtleastOneLowerCaseCharacter() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password must have at least one lowercase character");

		passwordVerifier.Verify("FIRAS");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordHasNotAtleastOneNumber() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password must have at least one number");

		passwordVerifier.Verify("firasSARDOUK");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotFulfillAtleast3Conditions1() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is ok");

		passwordVerifier.Verify("FirasSardouk");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotFulfillAtleast3Conditions2() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is ok");

		passwordVerifier.Verify("firas1sardouk");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotFulfillAtleast3Conditions3() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is ok");

		passwordVerifier.Verify("Firas1");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotFulfillAtleast3Conditions4() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is never ok!!");

		passwordVerifier.Verify("FIRASSARDOUK1");
	}


	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotHaveAtleastOneLowercase1() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is never ok!!");

		passwordVerifier.Verify("FIRAS26051994");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotHaveAtleastOneLowercase2() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is never ok!!");

		passwordVerifier.Verify("FIRAS1");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotHaveAtleastOneLowercase3() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is never ok!!");

		passwordVerifier.Verify("111111111111111");
	}

		@Test
	public void shouldThrowExceptionWhenPasswordDoesNotHaveAtleastOneLowercase4() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is never ok!!");

		passwordVerifier.Verify("111");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotHaveAtleastOneLowercase5() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is never ok!!");

		passwordVerifier.Verify("FIRAS");
	}

	@Test
	public void shouldThrowExceptionWhenPasswordDoesNotHaveAtleastOneLowercase6() {

		expectedEx.expect(RuntimeException.class);
		expectedEx.expectMessage("Password is never ok!!");

		passwordVerifier.Verify("FIRASSARDOUK");
	}
}