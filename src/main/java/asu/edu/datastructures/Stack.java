package asu.edu.datastructures;

import java.util.logging.Level;
import java.util.logging.Logger;

import asu.edu.exceptions.StackOverflowException;
import asu.edu.exceptions.StackUnderflowException;

public class Stack<T> {
	T[] data;
	int length;
	int top;
	private static final Logger LOGGER = Logger.getLogger(Stack.class.getName());
	
	@SuppressWarnings("unchecked")
	public Stack(Class<?> type, int length) {
		data = (T[])java.lang.reflect.Array.newInstance(type, length);
		top = -1;
	}
	
	public boolean isStackEmpty() {
		return top == -1 ? true : false;
	}
	
	public void push(T data) throws StackOverflowException {
		this.top++;
		if(top == length) {
			LOGGER.log(Level.SEVERE, data + " cannot be pushed.");
			throw new StackOverflowException(data + " cannot be pushed.");
		} else {
			this.data[top] = data;
		}
	}
	
	public T pop() throws StackUnderflowException {
		if(this.isStackEmpty()) {
			LOGGER.log(Level.SEVERE, "No data items available.");
			throw new StackUnderflowException("No data items available.");
		} else {
			this.top--;
			return this.data[top];
		}
	}
}
