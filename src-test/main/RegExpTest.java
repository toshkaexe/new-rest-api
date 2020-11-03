package main;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegExpTest {
	public String getCommentFromString(String value) {

		String pattern0 = "(\\t)(\\w+)(\\t)(\\w+)";
		String pattern1 = "((\t)(\\w+)){2}";
		String pattern2 = "((\t)){2}(\\w+)";

		// Create a Pattern objectÏÏÏ
		Pattern r0 = Pattern.compile(pattern0);
		Pattern r1 = Pattern.compile(pattern1);
		Pattern r2 = Pattern.compile(pattern2);
		// Now create matcher object.
		Matcher m0 = r0.matcher(value);
		Matcher m1 = r1.matcher(value);
		Matcher m2 = r2.matcher(value);

		if (m0.find()) {

			return m0.group(4).replaceFirst("^\\s*", "");

		}
		if (m1.find()) {

			return m1.group(1).replaceFirst("^\\s*", "");
		}
		if (m2.find()) {
			return m2.group(0).replaceFirst("^\\s*", "");

		}
		return "nofound";

	}

	public String getCommentFromRegex(String value) {

		String pattern = "[a-zA-Z0-9_ ]*$";
		Pattern r = Pattern.compile(pattern);
		Matcher m = r.matcher(value);

		if (m.find())
			return m.group(0);

		else
			return "not found";

	}

	@Test
	public void test_getCommentFromRegex() {

		String testline0 = "FNDEVee32ijqkwherweh\t0004989125001415\tTestkommentar";
		String testline1 = "\t0004989125001415\tTestkommentar";
		String testline2 = "\t\tTestkommentar";

		String testline3 = "FNDEVee32ijqkwherweh\t0004989125001415\tTest kommentar";
		String testline4 = "\t0004989125001415\tTest kommentar";
		String testline5 = "\t\tTest kommentar";
		try {
			assertEquals("Testkommentar", getCommentFromRegex(testline0));
			assertEquals("Testkommentar", getCommentFromRegex(testline1));
			assertEquals("Testkommentar", getCommentFromRegex(testline2));

			assertEquals("Test kommentar", getCommentFromRegex(testline3));
			assertEquals("Test kommentar", getCommentFromRegex(testline4));
			assertEquals("Test kommentar", getCommentFromRegex(testline5));
			System.out.print("Test cases with result equals passed!");
		} catch (Exception e) {
			System.out.println(String.format("Test cases with result equals failed!, %s", e));
			fail();
		}

	}

	@Test
	public void test_getCommentFromStringFunction() throws Exception {

		String testline0 = "FNDEVee32ijqkwherweh\t0004989125001415\tTestkommentar";
		String testline1 = "\t0004989125001415\tTestkommentar";
		String testline2 = "\t\tTestkommentar";

		try {
			assertEquals("Testkommentar", getCommentFromString(testline0));
			assertEquals("Testkommentar", getCommentFromString(testline1));
			assertEquals("Testkommentar", getCommentFromString(testline2));
			System.out.print("Test cases with result equals passed!");
		} catch (Exception e) {
			System.out.println(String.format("Test cases with result equals failed!, %s", e));
			fail();
		}
	}

	@Test
	public void test_getCommentFromString() throws Exception {
		String testline0 = "FNDEVee32ijqkwherweh\t0004989125001415\tTestkommentar";
		String testline1 = "\t0004989125001415\tTestkommentar";
		String testline2 = "\t\tTestkommentar";

		String pattern0 = "(\\t)(\\w+)(\\t)(\\w+)";
		String pattern1 = "((\t)(\\w+)){2}";
		String pattern2 = "((\t)){2}(\\w+)";
		// Create a Pattern object
		Pattern r0 = Pattern.compile(pattern0);
		Pattern r1 = Pattern.compile(pattern1);
		Pattern r2 = Pattern.compile(pattern2);
		// Now create matcher object.
		Matcher m0 = r0.matcher(testline0);
		Matcher m1 = r1.matcher(testline1);
		Matcher m2 = r2.matcher(testline2);
		if (m0.find()) {

			System.out.println(m0.group(4));

		}
		if (m1.find()) {

			System.out.println(m1.group(1));
		}
		if (m2.find()) {
			System.out.println(m2.group(0));

		}

	}

}
