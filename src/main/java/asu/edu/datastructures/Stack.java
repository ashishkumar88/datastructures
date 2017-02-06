package asu.edu.datastructures;

import java.util.logging.Level;
import java.util.logging.Logger;

import asu.edu.exceptions.StackOverflowException;
import asu.edu.exceptions.StackUnderflowException;

/**
 * @author ashish
 *
 * @param <T>
 */
public class Stack<T> {
	private T[] data;
	private int length;
	private int top;
	private static final Logger LOGGER = Logger.getLogger(Stack.class.getName());

	@SuppressWarnings("unchecked")
	public Stack(Class<?> type, int length) {
		this.length = length;
		data = (T[]) java.lang.reflect.Array.newInstance(type, length);
		top = -1;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	public int getSize() {
		return top + 1;
	}
	
	public boolean isFull() {
		return top == length - 1;
	}

	public void push(T data) throws StackOverflowException {
		if (this.isFull()) {
			LOGGER.log(Level.SEVERE, data + " cannot be pushed.");
			throw new StackOverflowException(data + " cannot be pushed.");
		} else {
			this.top++;
			this.data[top] = data;
		}
	}

	public T pop() throws StackUnderflowException {
		if (this.isEmpty()) {
			LOGGER.log(Level.SEVERE, "No data items available.");
			throw new StackUnderflowException("No data items available.");
		} else {
			return this.data[this.top--];
		}
	}
}
