
/*
	 * @Author: David George 
	 * @Student ID: 251004930 
	 * @Class: CS2110
	 */

import java.lang.*;

public class ChainedHashTable {

	/*
	 * This class creates an array of LinkedStacks This method will be the hashtable
	 * 
	 */

	int n;
	LinkedStack[] ChainedHashTable;
	int size; 

	public ChainedHashTable(int size) {

		/*
		 * The array is initalised with a prime number
		 */
		
		this.size = size; 
		ChainedHashTable = new LinkedStack[this.size];

	}

	public boolean Find(Record data) {

		/*
		 * This index holds the index number for assoscaited Record object, using the
		 * hash method
		 */

		int index = hash(data.config);

		/*
		 * If the posisition is null in the array, then the reocrd does not exist
		 */

		if (ChainedHashTable[index] == null) {
			return false;
		}

		/*
		 * If the posistion is not null, then it iterates over the linked list at the
		 * posistion, and checks if the object is there If it is, then true is returned,
		 * other wise false is returned
		 */

		if (ChainedHashTable[index].LinkedStackFind(data.getConfig())) {

			return true;
		}

		return false;
	}

	public int get(String data) {

		int index = hash(data);

		if (ChainedHashTable[index] == null) {

			/*
			 * Returning -1 means it did not find the object with the asscoated String
			 */

			return -1;
		}

		if (ChainedHashTable[index].LinkedStackFind(data)) {

			/*
			 * This calls the get method asscoaited with the LinkStack, this get method
			 * returns the interger requreid
			 */

			return ChainedHashTable[index].LinkedStackGet(data);
		}

		return -1;
	}

	public int hash(String pair) {

		
		int hash = 0; 
		for(int j = 0; j < pair.length(); j ++) {
			
			hash = (int) pair.charAt(j) + hash;
			
		}
		
		for(int i = 0; i < pair.length() -2 ; i++) {
	
			hash = (hash *331 + (int) pair.charAt(i)) % size; 
			
			
			
		}
		
		
		for(int k = pair.length()/20; k > 0; k--) {
			
			hash = (hash *21 + (int) pair.charAt(k)) % size; 
			
		}
		
		return hash;

	}



	
	public int add(Record pair) {

		/*
		 * Checks if its already in the table, if so return -1.
		 * 
		 * if its null, at that posisiton, then it will initialsse a new linked stack at
		 * that posisiton, and will add a new record there If its null, that means there
		 * as no colision, and it will return 0 for no collision. If its not null, add
		 * the record if possible, and return one as there was a collision
		 */

		if (Find(pair) != false) {
			return -1;
		}

		if (ChainedHashTable[hash(pair.getConfig())] == null) {

			LinkedStack willAdd = new LinkedStack();
			willAdd.LinkedStackAdd(pair);
			ChainedHashTable[hash(pair.getConfig())] = willAdd;
			n++;
			return 0;

		}

		else {
			ChainedHashTable[hash(pair.getConfig())].LinkedStackAdd(pair);

			n++;
			return 1;
		} // This goes to the correct place, and then from there it will add it to the end
			// of list

	}

	public boolean remove(String config) {

		int index = hash(config);

		/*
		 * If its null, that means its not there to remvoe in the beginning If its not
		 * null remove if possible, that is, if the LinkedStackRemove method returns
		 * true
		 * 
		 */

		if (ChainedHashTable[index] == null) {

			return false;
		}

		if (ChainedHashTable[index].LinkedStackRemove(config)) {
			n--;
			return true;
		}

		return false;

	}

}
