package exceptions;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class IdHandler {
	public static void check(String id) throws MyExceptions{
		String regex = "\\d{1,}";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher matcher = p.matcher(id);
		
		if(!matcher.matches()) {
			throw new MyExceptions("ID must be digits!!");
		}
	}

}