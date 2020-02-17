package vn.cwa.application.app;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainTest {

	public static void main(String[] args) {
		try {
			File file = new File("C:\\customer.txt"); // creates a new file instance
			FileReader fr = new FileReader(file); // reads the file
			BufferedReader br = new BufferedReader(fr); // creates a buffering character input stream
//			StringBuilder sb = new StringBuilder(); // constructs a string buffer with no characters
			String line;
			List<String> lstStr = new ArrayList<String>();
			while ((line = br.readLine()) != null) {
//				sb.append(line); // appends line to string buffer
//				sb.append("\n"); // line feed
				lstStr.add(line);
			}
			fr.close(); // closes the stream and release the resources
//			System.out.println("Contents of File: ");
			String[] xxx = null;
			List<String> columns = new ArrayList<String>();
			List<String> properties = new ArrayList<String>();
			for (String item : lstStr) {
				xxx = item.split("\"");
				columns.add(xxx[1]);
				properties.add(xxx[3]);
			}

			StringBuilder sql = new StringBuilder();
			for (String item : properties) {
				sql.append(item).append("\n");
			}
//			System.out.println(sql);
			String temp = null;
			for (int i = 0; i < properties.size() - 1; i++) {
				temp = properties.get(i);
				for (int j = i + 1; j < properties.size(); j++) {
					if (temp.equals(properties.get(j))) {
						System.out.println(properties.get(j));
					}
				}
			}

//			StringBuilder sql = new StringBuilder();
//			sql.append("INSERT INTO cst_dc_chancecard_history ( ").append("\n");
//			for (String item : columns) {
//				sql.append(item).append(",").append("\n");
//			}
//			sql.append(") VALUES ( ");
//			for (String item : properties) {
//				sql.append(item).append(",").append("\n");
//			}
//			sql.append(")");
//			System.out.println(sql.toString());

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
