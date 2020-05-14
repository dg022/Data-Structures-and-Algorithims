import  java.lang.*;
public class ChainedHashTable {
	
	
	int n; 
	LinkedStack [] ay; 
	
	
	
	public ChainedHashTable(int d) {
		
		n =  0;
		
		ay = new LinkedStack [2*d]; // Creates a an array, of linked stacks, and the number of openungs in the array is 2^d, d is inputed by the user 
		
	}
	
	
	public void resize() {
		
		
		
	}
	
	public boolean Find(int data) {
		
		
		// You need to find the correct posisition in the list 
		
		
		int index = hash(data); // This refers to the index with the correct linked list
		
		if(ay[index]==null) {
			
			return false; //This means its in the list
		}
		
		
		
		
		if(ay[index].find(data)) {
			
			return true; //This means its in the list
		}
		
		
		return false;// This means its not in the list.
	}
	
	
	public int hash(int data) {
		Integer s_int = new Integer(data);
		int w  = s_int.hashCode();
		
		return w%ay.length; // Returns the index varaible where the item will be added, the hashing funciton should return indexes that are uniformly positened. 
	}
	
	
	public boolean add(int data) {
		
		if(Find(data)!=false) {return false;} // This is saying, if its aleady in the list dont add it 
		
		if(n+1 >= ay.length) {resize();}
		
		if(ay[hash(data)] == null) {
			
			LinkedStack swago = new LinkedStack();
			swago.add(data);
			ay[hash(data)] = swago;
			n++;
			return true;
			
		}
		
		
		else{ay[hash(data)].add(data); 
		
		n++;
		return true;}//This goes to the correct place, and then from there it will add it to the end of list 
		
		

		
	}
	
	
	public boolean remove(int data) {
		
		if(!Find(data)) {return false;} // If its not in here, return a sentinel value
		
		int index = hash(data);
		
		if(ay[index].remove(data)) {
			 n--;
			 return true;} // You need to add a function where you can remove a certain value
		
		return false;

	}
	
	
	public String toString() {
		
		String output  = "";
		
		for(int i = 0; i < ay.length; i++) {
			
			if(ay[i]!=null) {
			output = output + ay[i].toString();
			}
			
			
		}
		
		return output;
		
		
	}
	
	
	
	public static void main(String[] args) {
		
		
		
		
		ChainedHashTable  swag = new ChainedHashTable(10);
		
		for(int i = 0; i < 10; i++) {
			
			swag.add(i);
			
		}
		
		
		System.out.println(swag);
		
		swag.remove(0);
		
		System.out.println(swag);
		
		
	}
	
	
	
	
	
	

}
