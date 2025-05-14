package exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberHandler {

	public static void check(String number) throws MyExceptions {
		String regex = "^\\d{10}$";

		Pattern p = Pattern.compile(regex);

		Matcher matcher = p.matcher(number);

		if (!matcher.matches()) {
			throw new MyExceptions("Length should be 10 and all should be digits!");
		}
	}
}