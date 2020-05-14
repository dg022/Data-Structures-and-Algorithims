import java.util.Random;

import java.util.*;


public class LinkdedList {
	
	ArrayList<Integer>cool;
	Random rand = new Random();
	

	
	
	public LinkdedList() {
		
		cool = new ArrayList<Integer>(); 
		int n = cool.size();
	
	}
	
	public void add(int item) {
		
		cool.add(item);
		
	}
	
	public int remove() {
		
	
		 int r  = rand.nextInt(cool.size());
		 
		
		 
		 int temp = cool.get(r);
		 
		 cool.set(r, (cool.get(cool.size()-1)));
		 
		 cool.remove(cool.size()-1);
		 
		 return temp; 
		 
		
	}
	
	public String toString() {
		String output = "";
		
		for(int i =0; i < cool.size(); i++) {
			
			output = output + "," + cool.get(i);
			
		}
		
		
		return output; 
		
	}
	
	
	public static void main(String[] args) {
		
		
		LinkdedList swag  = new LinkdedList();
		
		for(int i =0; i < 10; i++) {
			
			swag.add(i);
			
			
		}
		
		
		
		System.out.println(swag);
		

		for(int i =0; i < 3; i++) {
			
			swag.remove();			
			
		}
		
		System.out.println(swag);
		
		
	}

	
	
} 







