package main;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SaveToFile {
	String fileName;
	String data;

	SaveToFile(String fileName, String dataString) {

		this.fileName = fileName;
		this.data = dataString;

	}

	public void writeToFile() {

		BufferedWriter writer;
		try {
			
		    writer = new BufferedWriter(new FileWriter(fileName, true));
		    writer.append(' ');
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
