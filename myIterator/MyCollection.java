package myIterator;

import java.util.Iterator;

public class MyCollection<E> implements Iterable<E>{
	public Iterator<E> iterator() {
		return MyIterator<E>();
	}
	
	public class MyIterator<T> implements Iterator<T> {
		public boolean hasNext() {
			if ()
		}
		
		public T next() {
			
		}
		
		public void remove() {
			
		}
	}
}
