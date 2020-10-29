package main;


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
	}

}
