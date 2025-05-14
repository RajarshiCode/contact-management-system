package exceptions;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailHandler {
	public static void check(String email) throws MyExceptions{
		String regex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		
		Pattern p = Pattern.compile(regex);
		
		Matcher matcher = p.matcher(email);
		
		if(!matcher.matches()) {
			throw new MyExceptions("Invalid Email Syntax!!");
		}
	}
}