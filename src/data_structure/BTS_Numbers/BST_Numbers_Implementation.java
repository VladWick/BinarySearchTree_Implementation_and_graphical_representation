package data_structure.BTS_Numbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BST_Numbers_Implementation {
	
	public Node<Integer> root;
	public BST_Numbers_Implementation() {
		root = null;
	}
	
	public void insert(int i) {
		root = insert(root, i);
	}
	
	public Node<Integer> insert(Node<Integer> node, int value) {  
		if(node == null){  
			return new Node<Integer>(value);  
	    }   
	    if(value < node.data) {  
	    	node.left = insert(node.left, value);  
	    }  
	    else if(value > node.data) {  
	    	node.right = insert(node.right, value);  
	    }  
	    return node;  
	}  
	  
	public Node<Integer> find(int searchedValue) {  
		Node<Integer> current = root;  
		while(current.data != searchedValue) {  
			if(searchedValue < current.data) {
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
	  
	public void inOrder(Node<Integer> node) {  
		if(node != null) {  
			inOrder(node.left);  
			node.displayData();  
			inOrder(node.right);  
	    }  
	}
	
	public void preOrder(Node<Integer> node) {  
		if(node != null){  
			node.displayData();  
			preOrder(node.left);             
			preOrder(node.right);  
	    }  
	}  
	
	public void postOrder(Node<Integer> node) {  
		if(node != null) {  
			postOrder(node.left);  
			postOrder(node.right);  
			node.displayData();            
	    }  
	}
	
	/*--- Print Tree ---*/
	public static void printTree(Node<Integer> node) {
		BTreePrinter.printNode(node);
	}
}

@SuppressWarnings("hiding")
class Node<Integer>  {
	
    Node<Integer> left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }
    
    public void displayData() {  
    	System.out.print(data + " ");  
    }
}

class BTreePrinter {

    public static void printNode(Node<Integer> root) {
        int maxLevel = BTreePrinter.maxLevel(root);

        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    }

    private static void printNodeInternal(List<Node<Integer>> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return;

        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;

        BTreePrinter.printWhitespaces(firstSpaces);

        List<Node<Integer>> newNodes = new ArrayList<Node<Integer>>();
        for (Node<Integer> node : nodes) {
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

    private static int maxLevel(Node<Integer> node) {
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
