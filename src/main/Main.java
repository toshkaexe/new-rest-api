package main;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

	public static void main(String[] args) {
		System.out.println("tests");

		Customer customer = new Customer();
		String ress = customer.setId("sss").setFirstname("www").setSecondname("sobaka").build();
		System.out.println(ress);

		SaveToFile a = new SaveToFile("dddppp.txt", ress);
		try {
			a.writeToFile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// String to be scanned to find the pattern.
		String testline0 = "FNDEVee32ijqkwherweh\t0004989125001415\tTestkommentar";
		String testline1 = "\t0004989125001415\tTestkommentar";
		String testline2 = "\t\tTestkommentar";

		String pattern0 = "((\\w+)(\t)){2}(\\w+)";
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
			System.out.println("Case 1 Found value 3: " + m0.group());
		} else if (m1.find()) {
			System.out.println("Case 2 Found value 11: " + m1.group());

		} else if (m2.find()) {
			System.out.println("Case 2 Found value 11: " + m2.group());
		}

	}

}
