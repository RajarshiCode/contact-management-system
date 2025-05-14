package exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameHandler {
	public static void check(String name) throws MyExceptions {
		String regex = "^[A-Za-z]{1}[A-Za-z0-9]{1,}$";

		Pattern p = Pattern.compile(regex);

		Matcher matcher = p.matcher(name);

		if (!matcher.matches()) {
			throw new MyExceptions("Name should be alpha numeric!!");
		}
	}

}