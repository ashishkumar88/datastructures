package asu.edu.datastructures;

import asu.edu.exceptions.StackOverflowException;
import asu.edu.exceptions.StackUnderflowException;
import junit.framework.TestCase;

/**
 * Unit test for Data Structures.
 */
public class DataStructuresTest extends TestCase {

	public void testStack() {
		int size = 10;
		Stack<Integer> stack = new Stack<>(Integer.class, size);
		try {
			stack.pop();
		} catch (Exception e) {
			assertTrue(stack.isEmpty());
		}
		for (int i = 0; i < size; i++) {
			try {
				stack.push((int)(Math.random()*1001));
			} catch (StackOverflowException e) {
				assertTrue(stack.getSize() == size);
			}
		}
		assertTrue(stack.getSize() == size);
		try {
			stack.push((int)Math.random()*1001);
		} catch (StackOverflowException e) {
			assertTrue(stack.getSize() == size);
		}
		for (int i = 0; i < size; i++) {
			try {
				int number = stack.pop();
				assertTrue(number >= 0 && number <= 1000);
			} catch (StackUnderflowException e) {
				assertTrue(stack.isEmpty());
			}
		}
		try {
			int number = stack.pop();
			assertTrue(number >= 0 && number <= 1000);
		} catch (StackUnderflowException e) {
			assertTrue(stack.isEmpty());
		}
	}

	public void testQueue() {
		int size = 10;
		Queue<Integer> queue = new Queue<>(Integer.class, size);
		try {
			queue.dequeue();
		} catch (Exception e) {
			assertTrue(queue.isEmpty());
		}
		
		for (int i = 0; i < size-1; i++) {
			try {
				queue.enqueue((int)(Math.random()*1001));
			} catch (Exception e) {
				assertTrue(!queue.isEmpty());
			}
		}
		
		for (int i = 0; i < size-1; i++) {
			try {
				Integer data = queue.dequeue();
				assertNotNull(data);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		assertTrue(queue.isEmpty());
		
		for (int i = 0; i < size-1; i++) {
			try {
				queue.enqueue((int)(Math.random()*1001));
				Integer data = queue.dequeue();
				assertNotNull(data);
			} catch (Exception e) {
				assertTrue(queue.isEmpty());
			}
		}

		assertTrue(queue.isEmpty());
	}
	
	public void testSingleLinkedList() {
		SingleLinkedList<Integer> list = new SingleLinkedList<>();
		int size = 10;
		Stack<Integer> stack = new Stack<>(Integer.class, size);
		for (int i = 0; i < size; i++) {
			int value = (int)(Math.random()*1001);
			list.insert(value);
			try {
				stack.push(value);
			} catch (StackOverflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		assertEquals(size, list.size());
		assertNotNull(list.toString());
		for (int i = 0; i < size; i++) {
			try {
				list.delete(stack.pop());
			} catch (StackUnderflowException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
		}
		assertEquals(0, list.size());
	}
}
