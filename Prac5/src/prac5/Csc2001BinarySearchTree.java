package prac5;

import java.io.*;
import java.util.*;

import javax.naming.directory.InvalidAttributeValueException;

class BinaryTreeNode<E> {
	BinaryTreeNode<E> left;
	E data;
	BinaryTreeNode<E> right;

	public BinaryTreeNode (E data) {
		this.data = data;
		right = left = null;
	}
	
	/*returns a string representation of the node
	 *@returns the data in the Node
	*/
	public String toString() { 	
		return data.toString();
	}
}


public class Csc2001BinarySearchTree<E extends Comparable<E>> {
	BinaryTreeNode<E> root;
	boolean addReturn;
	int height;
		
	/** Recursive add method.
	 * @post The data field addReturn is set true if the item is added to
	 *       the tree, false if the item is already in the tree.
	 * @param localRoot The local root of the subtree
	 * @param item The object to be inserted
	 * @return The new local root that now contains the
	 *         inserted item
	 */
	private BinaryTreeNode<E> add(BinaryTreeNode<E> localRoot, E item) {
    	if (localRoot == null) {
    		addReturn = true;
    		return new BinaryTreeNode<E>(item);
    	}
    	else if (item.compareTo(localRoot.data) == 0) {
    		// Item to add is equal to localRoot.
    		addReturn = false;
    		return localRoot;
    	}
    	else if (item.compareTo(localRoot.data) < 0) {
    		// Item to add is less than localRoot.
    		localRoot.left = add(localRoot.left, item);
    		return localRoot;
    	}
    	else {
    		// Item is greater than localRoot.
    		localRoot.right = add(localRoot.right, item);
    		return localRoot;
    	}
	}
	
	public boolean insertNode(E data) {
		root = add(root,data);
		return addReturn;
	}
	
	/**
	 * Return the contents of the BinarySearchTree as a List of items
	 * in ascending order.
	 */
	public List<E> toList() {
	    List<E> result = new ArrayList<E>();
	    toList(result, root);
	    return result;
	}
	
	private void toList(List<E> result, BinaryTreeNode<E> node) {
		// To get ascending list traverse inorder
		if (node == null) {
			return;
		}
		else {
			toList(result, node.left);
			result.add(node.data);
			toList(result, node.right);
		}
	}

	public List<E> toList(boolean preorder) {
	    List<E> result = new ArrayList<E>();
	    toList(result, root, preorder);
	    return result;
	}
	
	private void toList(List<E> result, BinaryTreeNode<E> node, boolean preorder) {
		if (node == null) {
			return;
		}
		else {
			if (preorder) {
				result.add(node.data);
			}
			toList(result, node.left, preorder);
			toList(result, node.right, preorder);
			if (!preorder) {
				result.add(node.data);
			}
		}
	}
	
	
	public E getMin() throws InvalidAttributeValueException {
		if (root == null) {
			throw new InvalidAttributeValueException("BST is empty.");
		}
		BinaryTreeNode<E> node = root;
		while (node.left != null) {
			node = node.left;
		}
		return node.data;
	}
	
	public E getMax() throws InvalidAttributeValueException {
		if (root == null) {
			throw new InvalidAttributeValueException("BST is empty.");
		}
		BinaryTreeNode<E> node = root;
		while (node.right != null) {
			node = node.right;
		}
		return node.data;
	}
	
	public String find(E item) {
		BinaryTreeNode<E> node = root;
		while (true) {
			if (node.data.compareTo(item) < 0) {
				node = node.right;
			}
			else if (node.data.compareTo(item) > 0) {
				node = node.left;
			}
			else {
				return "Found";
			}
			if (node == null) {
				return "Not Found";
			}
		}
	}
	
}

	