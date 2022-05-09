package data_structure.BTS_Words;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BST_Words_Analyze {
	
	static BST_Words_Implementation bst = new BST_Words_Implementation();
	
	static File file = new File("C:\\1-must-have\\1-workspace\\2-java\\3-TPU\\lb8\\src\\data");

	public static void analyze() throws FileNotFoundException {
		//fillBSTFromFile(bst);
		simpleFillBST(bst);
		
		System.out.println("------------------------------");
		System.out.println("----| Binary Search Tree |----");
		System.out.println("------------------------------");
		System.out.println();
		
		System.out.println("'Inorder' traversal of binary tree");  
		bst.inOrder(bst.root);
		System.out.println("\n");
		
		System.out.println("'Preorder' traversal of binary tree");  
	    bst.preOrder(bst.root);  
	    System.out.println("\n");
	    
	    System.out.println("'Postorder' traversal of binary tree");  
	    bst.postOrder(bst.root);  
	    System.out.println("\n");

	}
	
	public static void findWord(String wordToFind) {
		System.out.println("Searching in the BST for the word: '" + wordToFind + "'");
		if (bst.find(wordToFind) != null){
			System.out.println("    Word was founded");
		} else {
			System.out.println("    There is no such word in this BST");
		}
	}
	
	public static void printBinarySearchTree() {
		System.out.println("\nGraphical representation");
		BST_Words_Implementation.printTree(bst.root);
	}
	
	public static void fillBSTFromFile(BST_Words_Implementation bst) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			bst.insert(scanner.next());
		}
		scanner.close();
	}
	
	public static void simpleFillBST(BST_Words_Implementation bst) {
		bst.insert("asd");
		bst.insert("1qwe");
		bst.insert("2asd");
		bst.insert("3qwe");
		bst.insert("4asd");
		bst.insert("qwe");
	}
}
