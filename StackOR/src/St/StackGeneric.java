package St;

import java.util.Arrays;
import java.util.EmptyStackException;

public class StackGeneric<E> {
	private E[] elements;
	private int size = 0;
	private static final int DEFAULT_INITIAL_CAPACITY = 16;

	@SuppressWarnings("unchecked")
	public StackGeneric() {
		elements = (E[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}

	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		E result = (E) elements[--size];
		elements[size] = null; // Eliminate obsolete reference
		return result;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	private void ensureCapacity() {
		if (elements.length == size)
			elements = Arrays.copyOf(elements, 2 * size + 1);
	}
	public static void main(String[] args) {
		StackGeneric<String> stack = new StackGeneric<String>();
		for (String arg : args)
		stack.push(arg);
		while (!stack.isEmpty())
		System.out.println(((String) stack.pop()).toUpperCase());
		}
}
