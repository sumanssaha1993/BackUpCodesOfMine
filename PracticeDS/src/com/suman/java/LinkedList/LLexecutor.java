package com.suman.java.LinkedList;


public class LLexecutor {
	public static void main(String[] args) {
		TestLinkedList ll = new TestLinkedList();
		ll.add(100);
		ll.add(200);
		ll.add(300);
		ll.add(400);
		ll.add(500);
		System.out.println("Before Intertion.....");
		for(int i=0; i<ll.size(); i++){
			System.out.println(ll.get(i));
		}
		
		ll.add(2, 700);
		System.out.println("After Intertion.....");
		for(int i=0; i<ll.size(); i++){
			System.out.println(ll.get(i));
		}
		
		ll.remove(2);
		System.out.println("After Remove.....");
		for(int i=0; i<ll.size(); i++){
			System.out.println(ll.get(i));
		}
	}
	
	
}
