import java.io.FileNotFoundException;

import data_structure.Array;
import data_structure.BTS_Numbers.BST_Numbers_Analyze;
import data_structure.BTS_Words.BST_Words_Analyze;

public class Main {
	
	static String wordToFind = "good";
	static Integer numberToFind = 9;

	public static void main(String[] args) throws FileNotFoundException {

		/* ----- Array -----*/
		
		Array.analyze();
		Array.findWord(wordToFind);
		Array.printArray();
		
		/* ----- Binary Search Tree -----*/
		/*
		BST_Words_Analyze.analyze();
		BST_Words_Analyze.findWord(wordToFind);
		BST_Words_Analyze.printBinarySearchTree();
		*/
		/*
		BST_Numbers_Analyze.analyze();
		BST_Numbers_Analyze.findNumber(numberToFind);
		BST_Numbers_Analyze.printBinarySearchTree();
		*/
		/* ----- Comparison between them ----- */
		
	}
}
