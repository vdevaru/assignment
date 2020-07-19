package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;

public class DictionaryDemo {

	public static void main(String[] args) throws IOException {
//		String FilePath = "../assignment/Dictionary.txt"; -- for giving relative path
		String FilePath = args[0];
		if (doesFileExist(FilePath)) {
			Map<String, List<String>> dictionary = new HashMap<String, List<String>>();
			FileInputStream inputStream = null;
			Scanner sc = null;
			try {
				inputStream = new FileInputStream(FilePath);
				sc = new Scanner(inputStream);
				while (sc.hasNextLine()) {
					String line = sc.nextLine();
					if(!line.isEmpty()) {
					String key = line.substring(0, line.indexOf("-"));
					String value = line.substring(line.indexOf("-") + 2);
					List<String> meanings = new ArrayList<String>(Arrays. asList(value.split((", "))));
					dictionary.put(key, meanings);
					}
				}
				for (Entry<String, List<String>> entry : dictionary.entrySet()) {  
		            System.out.println(entry.getKey());
		            for(String meaning : entry.getValue()) {
		            	System.out.println(meaning);
		            }
				}
				if (sc.ioException() != null) {
					throw sc.ioException();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (inputStream != null) {
					inputStream.close();
				}
				if (sc != null) {
					sc.close();
				}
			}
		}
	}

	private static boolean doesFileExist(String filePath) throws FileNotFoundException {
		File f = new File(filePath);
		if (f.exists())
			return true;
		throw new FileNotFoundException("File Doesn't exist");
	}

}