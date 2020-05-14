
	/*
	 * @Author: David George 
	 * @Student ID: 251004930 
	 * @Class: CS2110
	 */

	/*
	 * This class creates a dictionary object, which stores
	 * A chained hashtable, a count and size.
	 * 
	 * To ensure proper encapsulation, I hid the inmplementation of the table
	 * in its own class, called ChainedHashTable
	 */





public class Dictionary implements DictionaryADT {
	
	int size;
	int count =0;
	
	
	/* Initialing a new table of type ChainedHashTable
	 */
	
	ChainedHashTable table;
		
	
	
	public Dictionary(int size ) {
		
		this.size = size; 
		table = new ChainedHashTable(size);
	}

	public int insert(Record pair) throws DictionaryException {
		
		
		/* table.add(pair), this method returns an integer 
		 * 0  means there is no collision, -1 its already in the hashtable, 1 means there is a collision
		 */
		
		
		int answer = table.add(pair) ;
		
		if(answer == -1) {
			
			throw new DictionaryException();
		} 
		
		// Count keeps a counter of the number of items
		count++;
		return answer;

	}

	public void remove(String config) throws DictionaryException {
	
		/*
		 * table.remove(config) removes the object with the same configuration 
		 * If the method returns true, then it was removed.
		 * If the method returns false, then it was not in the table to begin with.
		 * 
		 */
		
		
		
		boolean added = table.remove(config);
		if(!added) {
			throw new DictionaryException();
		}
		
		// Decrement a counter if the number items has decreased 
		count--;
		
	}


	public int get(String config) {
		
		
		/*
		 * Will return the score associated with the particular object with the config
		 * the get method calls the get method within the ChainedHashTable class
		 */
		
		
		return table.get(config);
	}

	
	public int numElements() {
		
		/*
		 *  
		 *  This method will return the number of items in the hash table
		 */
		
		return count; 
	}

}
