package com.suman.java.BST;

import java.util.Scanner;

public class BSTexecutor {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		BinarySearchTreeInterface bst = new BinarySearchTreeImpl();
		bst.addData(20);
		bst.addData(10);
		bst.addData(5);
		bst.addData(27);
		bst.addData(3);
		bst.addData(40);
		bst.addData(7);
		bst.addData(8);
		bst.addData(6);
		
		/*System.out.println("Enter how many records you want to insert ?");
		int n = scn.nextInt();
		for(int i = 0; i<n ; i++){
			System.out.println("Enter value");
			int val = scn.nextInt();
			bst.addData(val);
		}*/
		bst.sortData();
		bst.deleteData(5);
		System.out.println("After Deletion");
		System.out.println("============================================");
		bst.sortData();
	}
}
