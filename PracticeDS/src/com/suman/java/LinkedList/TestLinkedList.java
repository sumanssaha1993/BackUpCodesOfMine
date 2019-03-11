package com.suman.java.LinkedList;

public class TestLinkedList {
	Node start = null;
	Node current = null;
	int count = 0;
	private class Node{
		private int ele;
		private Node next;
		private Node prev;
		
		public Node(int ele){
			this.ele = ele;
			next = prev = null;
		}
		
	}
	
	public void add(int ele){
		
		if(start == null){
			start = new Node(ele);
			current = start;
			count++;
			return;
		}
		current.next = new Node(ele);
		Node temp = current;
		current = current.next;
		current.prev = temp;
		count++;
	}
	
	public void add(int index, int ele){
		if(index <= count){
			if(start == null && index == 0){
				start = new Node(ele);
				current = start;
				count++;
				return;
			}
			Node temp = start;
			for(int i=0; i<index-1; i++){
				temp = temp.next;
			}
			Node now = temp.next;
			temp.next = new Node(ele);
			temp.next.next = now;
			temp.next.next.prev = temp.next.next;
			temp.next.prev = temp;
			count++;
		}else{
			throw new RuntimeException("Array Index Out Of Bound");
		}
		
	}
	
	public void remove(int index){
		if(index <= count){
			Node temp = start;
			for(int i=0; i<index-1; i++){
				temp = temp.next;
			}
			Node now = temp.next;
			temp.next = now.next;
			temp.next.prev = now.prev;
			now = null;
			count--;
		}else{
			throw new RuntimeException("Array Index Out Of Bound");
		}
	}
	
	public int get(int index){
		
		if(count != 0 && index <= count){
			Node curr = start;
			for(int i=0; i<index; i++){
				curr = curr.next;
			}
			return curr.ele;
		}else{
			throw new RuntimeException("Index Does not Exists");
		}
	}
	
	public int size(){
		return count;
	}
}
