package asu.edu.datastructures;

import java.util.logging.Level;
import java.util.logging.Logger;

import asu.edu.exceptions.QueueOverflowException;
import asu.edu.exceptions.QueueUnderflowException;

/**
 * @author ashish
 *
 * @param <T>
 */
public class Queue<T> {
	private T[] data;
	private int length;
	private int head;
	private int tail;
	private static final Logger LOGGER = Logger.getLogger(Queue.class.getName());

	@SuppressWarnings("unchecked")
	public Queue(Class<?> type, int length) {
		this.length = length;
		data = (T[]) java.lang.reflect.Array.newInstance(type, length);
		this.head = 0;
		this.tail = 0;
	}

	public boolean isEmpty() {
		return this.head == this.tail;
	}

	public boolean isFull() {
		return this.head == (this.tail + 1) % this.length;
	}

	public void enqueue(T data) throws QueueOverflowException {
		if (this.isFull()) {
			LOGGER.log(Level.SEVERE, data + " cannot be queued.");
			throw new QueueOverflowException(data + " cannot be queued.");
		}
		this.data[this.tail] = data;
		if (this.tail == this.length - 1) {
			this.tail = 0;
		} else {
			this.tail++;
		}
	}

	public T dequeue() throws QueueUnderflowException {
		if (this.isEmpty()) {
			LOGGER.log(Level.SEVERE, "No data items available.");
			throw new QueueUnderflowException("No data items available.");
		}
		T data = this.data[this.head];
		if (this.head == this.length - 1) {
			this.head = 0;
		} else {
			this.head++;
		}
		return data;
	}
}
