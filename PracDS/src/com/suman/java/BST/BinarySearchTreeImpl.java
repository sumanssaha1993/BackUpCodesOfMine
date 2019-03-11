package com.suman.java.BST;

public class BinarySearchTreeImpl implements BinarySearchTreeInterface{


	private Node root;
	
	BinarySearchTreeImpl(){
		root = null;
	}
	
	class Node{
		int key;
		Node left,right;
		Node(int key){
			this.key = key;
			left=right=null;
		}
		@Override
		public String toString() {
			return "Node [key=" + key + ", left=" + left + ", right=" + right + "]";
		}
		
	}
	
	
	@Override
	public String toString() {
		return "BinarySearchTreeImpl [root=" + root + "]";
	}

	@Override
	public void addData(int key) {
		root = addDataElement(root, key);

	}

	private Node addDataElement(Node node, int key) {
		if(node == null){
			node = new Node(key);
			return node;
		}
		if(key < node.key){
			node.left = addDataElement(node.left, key);
		}
		else if(key > node.key){
			node.right = addDataElement(node.right, key);
		}
		return node;
	}

	@Override
	public void sortData() {
		order(root);

	}

	private void order(Node root) {
		if(root != null){
			order(root.left);
			System.out.println(root.key);
			order(root.right);
		}
		
	}

	@Override
	public void deleteData(int element) {
		root = delete(root, element);
		
	}

	private Node delete(Node root, int key) {
		if(root == null){
			return root;
		}
		if(key < root.key){
			root.left = delete(root.left, key);
		}
		else if(key > root.key){
			root.right = delete(root.right, key);
		}
		else{
			if(root.left == null){
				return root.right;
			}
			else if(root.right == null){
				return root.left;
			}
			else{
				root.key = getMinRight(root.right);
				root.right = delete(root.right, root.key);
			}
		}
		return root;
	}

	private int getMinRight(Node root) {
		int minVal = root.key;
		while(root.left != null){
			minVal = root.left.key;
			root = root.left;
		}
		return minVal;
	}


}
