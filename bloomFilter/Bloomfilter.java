package bloomFilter;
import java.math.BigInteger;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;
public class Bloomfilter<E> {
	private int k;  // no of hash functions
	private int size;
	private int currentSetSize;
	byte[] set;
	MessageDigest m;

	public Bloomfilter(int size, int keySize) {
		this.size = size;
		set = new byte[size];
		k = keySize;
		currentSetSize = 0;
		
		try {
			m = MessageDigest.getInstance("MD5");
		} catch (NoSuchAlgorithmException e) {
			throw new IllegalArgumentException("MD5 Hash not found");
		}
	}
	
	private int getHash(int i) {
		m.reset();
		byte[] bytes = ByteBuffer.allocate(4).putInt(i).array();
		m.update(bytes, 0, bytes.length);
		return Math.abs(new BigInteger(1, m.digest()).intValue()) % (set.length - 1);
	}
	
	public boolean add(E e) {
		int[] toSet = getSetArray(e);
		for (int x : toSet) {
			set[x] = 1;
		}
		
		currentSetSize++;
		return true;
		
	}
	
	private int[] getSetArray(E e) {
		int[] toSet = new int[k];
		toSet[0] = getHash(e.hashCode());
		
		for (int i = 1; i < k; i++) {
			toSet[i] = getHash(toSet[i - 1]);
		}
		
		return toSet;
	}
	public boolean mightContain(E e) { 
		int[] toSet = getSetArray(e);
		
		for (int x: toSet) {
			if (set[x] != 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public int size() {
		return currentSetSize;
	}
}
