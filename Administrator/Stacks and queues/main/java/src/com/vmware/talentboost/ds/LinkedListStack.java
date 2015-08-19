package com.vmware.talentboost.ds;

public class LinkedListStack<E> implements Stack<E> {
	private Node head;
	private Node tail;
	private int count = 0;
	
	public class Node<E>{
		private E element;
		private Node left;
		private Node rigth;
		
		public Node(){
			
		}
		
		public Node(E element){
			this.element = element;
		}
	}
	@Override
	public void push(E element) {
		// TODO Auto-generated method stub
		if (this.tail == null) {
			Node node = new Node(element);
			this.head = node;
			this.tail = node;
			this.count++;
			return;
		}
		
		Node node = new Node(element);
        node.left = this.tail;
        this.tail.rigth = node;
        this.tail = node;    
		this.count++;
	}

	@Override
	public E pop() {
		// TODO Auto-generated method stub
		E result = (E) this.tail.element;
        this.tail = this.tail.left;
		this.count--;
		return result;
	}

	@Override
	public E peek() {
		// TODO Auto-generated method stub
		return (E)this.tail.element;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return this.count;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return this.count == 0;
	}

}
