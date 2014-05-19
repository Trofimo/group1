package Generic;

import java.util.ArrayList;

public class Stack<E> extends ArrayList<E>{
	
	



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	public void push(E item) {
		super.add(item);
	}
	
	public E pop() {
		if (super.isEmpty()) {
			return null;
		}
		return super.remove(super.size()-1);
	}
	
	public E top() {
		return super.get(super.size()-1);
	}
	
	
	
	
	
	public static void main(String[] args) {
		
		Stack<String> stack = new Stack<String>();
		
		stack.push("one");
		stack.push("two");
		stack.push("three");
		
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
		
		
		
	}
}
