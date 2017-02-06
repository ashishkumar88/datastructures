package asu.edu;

import asu.edu.datastructures.Queue;

public class MainApp {

	public static void main(String args[]) {
		int size = 10;
		Queue<Integer> queue = new Queue<>(Integer.class, size);
		try {
			queue.dequeue();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
		for (int i = 0; i < size-1; i++) {
			try {
				queue.enqueue((int)(Math.random()*1001));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < size-1; i++) {
			try {
				int data = queue.dequeue();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		for (int i = 0; i < size-1; i++) {
			try {
				queue.enqueue((int)(Math.random()*1001));
				int data = queue.dequeue();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
