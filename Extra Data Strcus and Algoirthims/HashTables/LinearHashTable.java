
public class LinearHashTable {
	
	int [] t;
	int n;
	int q; // Number of dataitems  plus deleted values
	int dele; // this is the sentinel deleted value 
	
	
	public LinearHashTable() {
		
		t = new int [32];
		n = 0;
		q = 0;
		dele = -10000; 
	}
	
	//Lets make the null value be -14.5
	
	
	public boolean find(int data) {
		
		// when you are adding items to the list, if they are null or deleted they will be added
		// Otherwise   
		
		int index = hash(data);
		
		while(t[index]!= 0) {
			
			
			if(t[index] == data & t[index]!= dele ) {return true;}
			
			
			index = (index+1)%t.length;
			
			
		}

		return false;
	}
	
	public boolean remove(int data) {
		
		int index = hash(data);
		
		while(t[index]!= 0) {
			
			if(t[index] == data) {
				
				t[index] = dele;
				n--;
				return true;

			}
			
			index = (index+1)%t.length;

		}

		return false;
	}
	
	
	
	
	
	public boolean add(int data) {
		
		if(find(data)) {return false;}
		
		int index = hash(data);
		
		while(t[index]!=0 & t[index]!=dele) {index = (index +1)%t.length;}
		
		
		if(t[index] == 0) {
			
			n++;
			q++;
			
			
		}
		
		
		t[index] = data;
		
		return true;
	}
	
	
	
	
	public int hash(int data) {
		Integer s_int = new Integer(data);
		int w  = s_int.hashCode();
		
		return w%t.length; // Returns the index varaible where the item will be added, the hashing funciton should return indexes that are uniformly positened. 
	}
	
	
	public String toString() {
		
		String output = "";
		
		for(int i = 0; i<t.length; i++) {
			
			output  = output + "," + t[i]; 
			
			
		}
		
		return output;
		
	}
	
	
	public static void main(String[] args) {
		
		
		LinearHashTable cool = new LinearHashTable();
		
		for(int i = 0; i < 10; i ++) {
			
			
			cool.add(i);
		}
		
		
		
		System.out.println(cool);
		
		cool.remove(1);
		
		System.out.println(cool);
		
		cool.add(1);
		
		System.out.println(cool);
		
		
	}
	
	
	
	
	
	

}
