package data_structure.BTS_Numbers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class BST_Numbers_Analyze {
	
	static BST_Numbers_Implementation bst = new BST_Numbers_Implementation();
	static File file = new File("C:\\1-must-have\\1-workspace\\2-java\\lb8\\src\\dataNumbersSmall");
	
	public static void analyze() throws FileNotFoundException {
		fillBSTFromFile(bst);
		//simpleFillBST(bst);
		
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
	
	public static void findNumber(int numberToFind) {
		System.out.println("Searching in the BST for the number: " + numberToFind);
		if (bst.find(numberToFind) != null){
			System.out.println("    Number was founded");
		} else {
			System.out.println("    There is no such number in this BST");
		}
	}
	
	public static void printBinarySearchTree() {
		System.out.println("\nGraphical representation");
		BST_Numbers_Implementation.printTree(bst.root);
	}
	
	public static void fillBSTFromFile(BST_Numbers_Implementation bst) throws FileNotFoundException {
		Scanner scanner = new Scanner(file);
		while(scanner.hasNext()) {
			Integer currentNumber = Integer.parseInt(scanner.next());
			bst.insert(currentNumber);
		}
		scanner.close();
	}
	
	public static void simpleFillBST(BST_Numbers_Implementation bst) {
		bst.insert(1);
		bst.insert(3);
		bst.insert(2);
		bst.insert(5);
		bst.insert(9);
		bst.insert(10);
	}
}
