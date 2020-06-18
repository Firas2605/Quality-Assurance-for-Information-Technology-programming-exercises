package Exercise3;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class passwordVerifier {

	List<String> errorList = null;

	public void Verify(String password) {

		errorList = new ArrayList<>();

		if (password != "") {
			errorList = verifyAtleastSingleLowerCase(password);
			errorList = verifyPasswordLength(password);
			errorList = verifyAtleastSingleUpperCase(password);
			errorList = verifyAtleastSingleNumber(password);

		}
		else {
			throw new RuntimeException("Password should not be null");
		}
		if (errorList.size() == 0) {
			throw new RuntimeException("Password is perfect, all conditions are respected");

		}
		else {
			if (errorList.contains("Password must have at least one lowercase character")) {
				throw new RuntimeException("Password is never ok!! " + errorList);
			}
			else if ((errorList.size() > 1)) throw new RuntimeException("Password is never ok!! " + errorList);
			else throw new RuntimeException("Password is ok " + errorList);
		}
	}

	private List<String> verifyPasswordLength(String password) {

		if (!(password.length() >= 8)) {
			errorList.add("Password length must have at least 8 characters");
		}

		return errorList;
	}

	private List<String> verifyAtleastSingleLowerCase(String password) {

		Pattern lowerCasePattern = Pattern.compile("[a-z]");

		if (!lowerCasePattern.matcher(password).find()) {
			errorList.add("Password must have at least one lowercase character");
		}

		return errorList;
	}

	private List<String> verifyAtleastSingleUpperCase(String password) {

		Pattern upperCasePattern = Pattern.compile("[A-Z]");

		if (!upperCasePattern.matcher(password).find()) {
			errorList.add("Password must have at least one uppercase character");
		}

		return errorList;
	}

	private List<String> verifyAtleastSingleNumber(String password) {

		Pattern numberPattern = Pattern.compile("[0-9]");

		if (!numberPattern.matcher(password).find()) {
			errorList.add("Password must have at least one number");
		}

		return errorList;
	}
	
}