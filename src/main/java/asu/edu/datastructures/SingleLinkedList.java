package asu.edu.datastructures;

public class SingleLinkedList<T> {

	private SingleLinkedNode<T> head;

	public SingleLinkedList() {
		head = null;
	}

	public SingleLinkedNode<T> search(T data) {
		SingleLinkedNode<T> x = this.head;
		while (x != null && !x.getData().equals(data)) {
			x = x.getNext();
		}
		return x;
	}
	
	public void insert(T data) {
		SingleLinkedNode<T> x = new SingleLinkedNode<>(data);
		x.setNext(head);
		this.head = x;
	}
	
	public void delete(T data) {
		SingleLinkedNode<T> x = this.head;
		SingleLinkedNode<T> prev = null;
		while (x != null && !x.getData().equals(data)) {
			x = x.getNext();
			prev = x;
		}
		if(x != null) {
			if(head == x) {
				head = null;
			} else {
				prev.setNext(x.getNext());
			}
		}
	}

	public int size() {
		SingleLinkedNode<T> x = this.head;
		int counter = 0;
		while(x != null) {
			x = x.getNext();
			counter++;
		}
		return counter;
	}
	
	@Override
	public String toString() {
		StringBuilder value = new StringBuilder();
		value.append("[");

		SingleLinkedNode<T> x = this.head;
		while(x != null) {
			if(this.head == x) {
				value.append(x.getData());
			} else {
				value.append(", "+ x.getData());
			}
			x = x.getNext();
		}
		value.append("]");
		return value.toString();
	}	
}

class SingleLinkedNode<T> {
	private SingleLinkedNode<T> next;
	private T data;

	public SingleLinkedNode() {
		this.data = null;
		this.next = null;
	}

	public SingleLinkedNode(T data) {
		this.data = data;
		this.next = null;
	}

	public SingleLinkedNode<T> getNext() {
		return next;
	}

	public void setNext(SingleLinkedNode<T> next) {
		this.next = next;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
