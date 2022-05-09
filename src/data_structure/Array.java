package data_structure;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Array {
	
	public static File file = new File("C:\\1-must-have\\1-workspace\\2-java\\lb8\\src\\dataBIG");
	static List<String> dataFromArray = new ArrayList<>();
	
	public static void analyze() throws FileNotFoundException {
		fillArray();
		System.out.println("------------------------------");
		System.out.println("----------| Array |-----------");
		System.out.println("------------------------------");

	}
	
	public static void fillArray() throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			String str = fixString(scanner.next());
			dataFromArray.add(str);
		}
		scanner.close();
	}
	
	public static String fixString(String str) {
		String newString = str;
		if(str.contains(",")) {
			int index = str.indexOf(",");
			newString = str.substring(0, index) + str.substring(index+1, str.length());
		}
		if(str.contains(":")) {
			int index = str.indexOf(":");
			newString = str.substring(0, index) + str.substring(index+1, str.length());
		}
		if(str.contains(".")) {
			int index = str.indexOf(".");
			newString = str.substring(0, index) + str.substring(index+1, str.length());
		}
		return newString;
	}
	
	public static void findWord(String word) {
		System.out.println("    Finding '" + word + "'...");
		
		int amountOfWords = 0;
		for(int i = 0; i < dataFromArray.size(); ++i) {
			if(dataFromArray.get(i).equals(word)) {
				System.out.println(word + " was founded at the " + i + " place.");
				amountOfWords++;
			}
		}
		if(amountOfWords == 0) {
			System.out.println("There is no such a word");
		}
	}
	
	public static void printArray() {
		System.out.println("\n    Here is the array:");
		for(int i = 0 ; i < dataFromArray.size(); ++i) {
			System.out.println(dataFromArray.get(i));
		}
	}
}
