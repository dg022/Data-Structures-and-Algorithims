import java.util.*; 
public class TripleQueue {
	 ArrayStack front;
	 ArrayStack back;
	 ArrayStack middle;
	
	
	 public TripleQueue() {
		 
		 
		 front = new ArrayStack();
		 back = new ArrayStack();
		 middle = new ArrayStack();
		 
	 }
	


	
	public void add(int i, int item) {
		
		if(i<= front.size()) {
			
			front.Add(front.size() - i, item);	
		}
		
		
		else if (i > front.size() + middle.size() - 1) {
			
			back.Add((i-front.size() + middle.size()), item);
			
		} 
		
		
		else {
			
			middle.Add(i -front.size(), item);
			
		} 
		
	}
	
	public int remove(int index) {
		int temp;
		// Front
		if(index < front.size()) {
			
			temp =  (int) front.remove(front.size() - index-1);
			
		}
		
		// Last array
		else if (index > front.size() + middle.size() - 1) {

			
			temp = (int) back.remove((index -front.size() + middle.size()));
			
		} 
		
		// This will be the middle array
		
		else {

			temp = (int) middle.remove(index -front.size());
			
		} 
	
	
		return temp; 
	}
	
	
public static void main(String[] args) {
	
	
	TripleQueue cool = new TripleQueue();
	
	cool.add(0, 1);
	System.out.print(("THis is working"));
	
}
	
	

}



