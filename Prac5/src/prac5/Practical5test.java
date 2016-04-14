package prac5;

import javax.naming.directory.InvalidAttributeValueException;

public class Practical5test {

	private static void insertMultiple(Csc2001BinarySearchTree<Integer> tree, Integer... integers) {
		for (Integer x : integers) {
			tree.insertNode(x);
		}
	}
	
	public static void main(String[] args) throws InvalidAttributeValueException {
		Csc2001BinarySearchTree<Integer> tree = new Csc2001BinarySearchTree<Integer>();
		insertMultiple(tree, 50, 13, 15, 17, 77, 57, 67, 85, 87, 38, 28, 79, 29, 43, 6, 103);
		
		for (Integer i : tree.toList()) {
			System.out.println("" + i);
		}
		
		
		// Q3. What is your prediction for the order in which nodes are visited during a postorder traversal 
		// of the above tree?
		//
		// A: Postorder is: traverse left, traverse right, visit node. So, the result will be the same?
		
		// Q4. What is your prediction for the order in which nodes are visited during a pre
		// order traversal of the above tree?
		//
		// A: Preorder is: visit node, traverse left, traverse right. So, root will be printed first.
		
		// Postorder
		System.out.println("Postorder:");
		for (Integer i : tree.toList(false)) {
			System.out.println("" + i);
		}
		
		// Preorder
		System.out.println("Preorder:");
		for (Integer i : tree.toList(true)) {
			System.out.println("" + i);
		}
		
		// It's not in any order really.
		
		// Part 2
		// i.
		System.out.println("Min: " + tree.getMin());
		// ii.
		System.out.println("Max: " + tree.getMax());
		// iii.
		System.out.println("Find(6): " + tree.find(6));
		System.out.println("Find(42): " + tree.find(42));
		
		
	}

}
