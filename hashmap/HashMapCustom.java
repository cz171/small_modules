package hashmap;

/**
* @author Zhan CHEN
* This class provides custom implementation of HashMap(without using java api's)-
* which allows us to store data in key-value pair form.
* insertion order of key-value pairs is not maintained.
* @param <K>
* @param <V>
*/
class HashMapCustom<K, V> {
    
	 private Entry<K, V>[] table;
	 private int capacity = 4;
	 
	 class Entry<K, V> {
		 K key;
		 V value;
		 Entry<K, V> next;
		 
		 public Entry(K key, V value) {
			 this.key = key;
			 this.value = value;
			 this.next = null;
		 }
		
	 }
	 
	 public HashMapCustom() {
		 table = new Entry[capacity];
	 }
	 
	 
	   /**
	    * Method allows you put key-value pair in HashMapCustom.
	    * If the map already contains a mapping for the key, the old value is replaced.
	    * Note: method does not allows you to put null key though it allows null values.
	    * Implementation allows you to put custom objects as a key as well.
	    * Key Features: implementation provides you with following features:-
	    *     >provide complete functionality how to override equals method.
	    *  >provide complete functionality how to override hashCode method.
	    * @param newKey
	    * @param data
	    */

	 public void put(K key, V value) {
		 if (key == null) {
			 return;
		 }
		 
		 int hash = hash(key);
		 Entry<K, V> newEntry = new Entry<>(key,value);
		 
		 Entry<K, V> head = table[hash];
		 if (head == null) {
			 table[hash] = newEntry;
			 return;
		 } 
		 
		Entry<K, V> current = table[hash];
		Entry<K, V> prev = null;
		while (current != null) {
			if (current.key.equals(key)) {
				if (prev == null) {
					newEntry.next = current.next;
					table[hash] = newEntry;
					return;
				} else {
					newEntry.next = current.next;
					prev.next = newEntry;
					return; 
				}
			}
			
			prev = current;
			current = current.next;
		}
		
		prev.next = newEntry;
		
	 }
	 

   /**
    * Method returns value corresponding to key.
    * @param key
    */
     public V get(K key) {
    	 int hash = hash(key);
    	 if (table[hash] == null) {
    		 return null;
    	 }
    	 
    	 Entry<K, V> current = table[hash];
    	 while (current != null) {
    		 if (current.key.equals(key)) {
    			 return current.value;
    		 } 
    		 
    		 current = current.next;
    	 }
    	 
    	 return null;
    	 
     }

     
     /**
      * Method removes key-value pair from HashMapCustom.
      * @param key
      */
   public boolean remove(K deleteKey) {
	   int hash = hash(deleteKey);
	   if (table[hash] == null) {
		   return false;
	   }
	   
	   Entry<K, V> prev = null;
	   Entry<K, V> current = table[hash];
	   while (current != null) {
		   if (current.key.equals(deleteKey)) {
			   if (prev == null) {
				   table[hash] = table[hash].next;
				   return true;
			   } else {
				   	prev.next = current.next;
				   	return true;
			   }
		   } 
		   
		   prev = current;
		   current = current.next;
	   }
	   
	   return false;
   }


  

   /**
    * Method displays all key-value pairs present in HashMapCustom.,
    * insertion order is not guaranteed, for maintaining insertion order
    * refer LinkedHashMapCustom.
    * @param key
    */
   public void display(){
      
      for(int i=0;i<capacity;i++){
          if(table[i]!=null){
                 Entry<K, V> entry=table[i];
                 while(entry!=null){
                       System.out.print("{"+entry.key+"="+entry.value+"}" +" ");
                       entry=entry.next;
                 }
          }
      }             
   
   }
   /**
    * Method implements hashing functionality, which helps in finding the appropriate
    * bucket location to store our data.
    * This is very important method, as performance of HashMapCustom is very much
    * dependent on  this method's implementation.
    * @param key
    */
   private int hash(K key){
       return Math.abs(key.hashCode()) % capacity;
   }
   

}