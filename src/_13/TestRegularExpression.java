package _13;
import java.util.regex.*;
public class TestRegularExpression {
	public static void main(String[] args) {
		if (args.length < 2) {
			System.out.println("Usage: \njava TestRegularExpression" + "characterSequence regularExpression+ ");
			System.exit(0);
		}
		System.out.println("Input: \"" + args[0] + "\"");
		for (String string : args) {
			System.out.println("Regular expression: \"" + string + "\"");
			Pattern pattern = Pattern.compile(string);
			Matcher matcher = pattern.matcher(args[0]);
			while (matcher.find()) {
				System.out.println("Match \"" + matcher.group() + "\" at positions" + matcher.start() + "-" + (matcher.end() - 1));
			}
		}
	}
}
