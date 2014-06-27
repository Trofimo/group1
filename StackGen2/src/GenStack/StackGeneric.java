package GenStack;

import java.util.EmptyStackException;

public class StackGeneric<E> {

	private E[] elements;
	private int size = 0;

	@SuppressWarnings("unchecked")
	public StackGeneric(int iCAPACITY) {

		elements = (E[]) new Object[iCAPACITY];
	}

	public void push(E e) {

		if (size == elements.length)
			
			throw new FullStackException();
		elements[size++] = e;
	}

	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		E result = elements[--size];
		elements[size] = null;
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public static void main(String[] args) {
		StackGeneric<String> stack = new StackGeneric<String>(3);
		for (String arg : args)
			stack.push(arg);
		while (!stack.isEmpty())
			System.out.println(((String) stack.pop()).toUpperCase());
	}
}
