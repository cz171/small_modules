package arraylistCustom;

import java.util.Arrays;

public class ArrayListCustom<E> {
	int DEFAULT = 10;
	int size = 10;
	int index;
	Object[] elements;
	public ArrayListCustom() {
		index = 0;
		elements = new Object[DEFAULT];
	}
	
	public void add(E e) {
		if (index == size) {
			elements = Arrays.copyOf(elements, size * 2);
			size *= 2;

		}
		
		elements[index++] = e;
	}
	
	public E get(int i) {
		if (i >= index) {
			throw new IllegalArgumentException("out of bounds");
		}
		return (E) elements[i];
	}
	
	public void set(int i, E e) {
		if (i >= index) {
			throw new IllegalArgumentException("out of bounds");
		}
		elements[i] = e;
	}
	
	public E remove(int i) {
		if (i >= index) {
			throw new IllegalArgumentException("out of bounds");
		}
		
		E toBeRemove = (E) elements[i];
		
		for (int k = i; k < index - 1; k++) {
			elements[k] = elements[k + 1];
		}
		
		index--;
		
		return toBeRemove;
	}
	
	public int size() {
		return index;
	}
	
	
	
}
