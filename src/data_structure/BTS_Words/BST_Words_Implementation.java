package data_structure.BTS_Words;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BST_Words_Implementation {
	
	public Node<String> root;
	public BST_Words_Implementation() {
		root = null;
	}
	
	public void insert(String i) {
		root = insert(root, i);
	}
	
	public Node<String> insert(Node<String> node, String value) {  
		if(node == null){  
			return new Node<String>(value);  
	    }   
		
		// Lexicographic comparison of words
		String conditional = "bigger";
		if(value.compareTo(node.data) < 0) {
			conditional = "smaller";
		} else if(value.compareTo(node.data) == 0) {
			conditional = "equals";
		}

	    if(conditional.equals("smaller")) {  
	    	node.left = insert(node.left, value);  
	    }  
	    else if(conditional.equals("bigger")) {  
	    	node.right = insert(node.right, value);  
	    }  
	    return node;  
	}  
	  
	public Node<String> find(String searchedValue) {  
		Node<String> current = root;  
		while(!current.data.equals(searchedValue)) {
			
			String conditional = "bigger";
			if(searchedValue.compareTo(current.data) < 0) {
				conditional = "smaller";
			} else if(searchedValue.compareTo(current.data) == 0) {
				conditional = "equals";
			}
			// !!!!
			if(conditional.equals("smaller")) {
				current = current.left;  
			}
			else {
				current = current.right;  
			}
			if(current == null) {  
				return null;  
			}  
		}  
		return current;  
	}  
	  
	public void inOrder(Node<String> node) {  
		if(node != null) {  
			inOrder(node.left);  
			node.displayData();  
			inOrder(node.right);  
	    }  
	}
	
	public void preOrder(Node<String> node) {  
		if(node != null){  
			node.displayData();  
			preOrder(node.left);             
			preOrder(node.right);  
	    }  
	}  
	
	public void postOrder(Node<String> node) {  
		if(node != null) {  
			postOrder(node.left);  
			postOrder(node.right);  
			node.displayData();            
	    }  
	}
	
	/*--- Print Tree ---*/
	public static void printTree(Node<String> node) {
		BTreePrinter.printNode(node);
	}
}

@SuppressWarnings("hiding")
class Node<String>  {
	
    Node<String> left, right;
    String data;

    public Node(String data) {
        this.data = data;
    }
    
    public void displayData() {  
    	System.out.print(data + " ");  
    }
}

class BTreePrinter {

    public static void printNode(Node<String> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Node<String>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<String>> newNodes = new ArrayList<Node<String>>();
        for (Node<String> node : nodes) {
            if (node != null) {
                System.out.print(node.data);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else {
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            }

            BTreePrinter.printWhitespaces(betweenSpaces);
        }
        System.out.println("");

        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue;
                }

                if (nodes.get(j).left != null)
                    System.out.print("/");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(i + i - 1);

                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else
                    BTreePrinter.printWhitespaces(1);

                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            }

            System.out.println("");
        }

        printNodeInternal(newNodes, level + 1, maxLevel);
    }

    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    }

    private static int maxLevel(Node<String> node) {
        if (node == null)
            return 0;

        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    }

    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false;
        }

        return true;
    }

}
