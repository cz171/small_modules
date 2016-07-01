package oOneDataStructure;
import java.util.*;
public class FastDataStructure<E> {
	//a data structure to O(1) add, O(1) delete, O(1) find, O(1) random
	//reference stackoverflow
	List<E> elements;
	Map<E, Integer> map;
	
	public FastDataStructure() {
		elements = new ArrayList<>();
		map = new HashMap<>();
	}
	
	public void add(E e) {
		elements.add(e);
		map.put(e, elements.size() - 1);
	}
	
	public E remove(E e) {
		if (!map.containsKey(e) || map.get(e) == -1) {
			throw new IllegalArgumentException("element does not exist");
		}
		
		int index = map.get(e);
		E toBeRemoved = elements.get(index);
		elements.set(index, elements.get(elements.size() - 1));
		map.put(e, -1);
		elements.remove(elements.size() - 1);
		return toBeRemoved;
	}
	
	public void printAllEle() {
		for (E e: elements) {
			System.out.print(e + " ");
		}
	}
	
}
