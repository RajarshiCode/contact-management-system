package exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ChoiceHandler {
	public static void check(String ch) throws MyExceptions {
		String regex = "\\d{1}";

		Pattern p = Pattern.compile(regex);

		Matcher matcher = p.matcher(ch);

		if (!matcher.matches()) {
			throw new MyExceptions("Choice must be digit!!");
		}
	}
}
