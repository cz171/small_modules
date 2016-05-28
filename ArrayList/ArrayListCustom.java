package ArrayList;
import java.util.Arrays;

public class ArrayListCustom<E> {
	private Object[] elements;
	public int size = 0;
	private static final int DEFAULT_SIZE = 10;
	
	public ArrayListCustom() {
		elements = new Object[DEFAULT_SIZE];
	}
	
	public void add(E e) {
		if (size == elements.length) {
			elements = Arrays.copyOf(elements, elements.length * 2);
		}
		
		elements[size++] = e;
	}
	
	public E get(int index) {
		if (index >= size || index < 0) {
			 throw new ArrayIndexOutOfBoundsException();	
		}
		
		return (E) elements[index];
	}
	
	public E remove(int index) {
		if (index >= size || index < 0) {
			 throw new ArrayIndexOutOfBoundsException();	
		}
		
		Object ele = elements[index];
		int i = index;
		while (i < size) {
			elements[i] = elements[i + 1];
			i++;
		}
		
		elements[size--] = null;
		return (E) ele;
	}
	
	public int size() {
		return size;
	}
}
