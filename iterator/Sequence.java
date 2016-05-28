package iterator;

import java.util.*;
public class Sequence<Item> implements Iterable<Item>{
	private Item[] a = (Item[]) new Object[10];
	private int size = 0;
	public void add(Item item) {
		if (size >= a.length) {
			a = Arrays.copyOf(a, a.length);
		}
		a[size++] = item;
	}
	
	
	public Iterator<Item> iterator() {
		return new IteratorCustom();
	}
	
	private class IteratorCustom implements Iterator<Item>{
		int i = 0;
		
		public boolean hasNext() {
			return i < size;
		}
		
		public Item next() {
			if (!hasNext()) {
				throw new IllegalArgumentException("index out of bound");
			}
			
			return a[i++];
		}
	}
	
}

