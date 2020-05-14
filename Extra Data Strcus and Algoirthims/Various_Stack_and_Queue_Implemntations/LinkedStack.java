
public class LinkedStack {
	
	Noder front;
	Noder rear; 
	int count; 
	
	
	public LinkedStack() {
		front = null;
		rear = null;
		count = 0; 
	}
	
	public LinkedStack(Noder node) {
		front = node;
		rear = node;
		count = 1; 
	}
	
	
	// Add to the front always, it acts like a stack  
	
	/*
	public void add(int data) {
		
		Noder node = new Noder(); 
		node.SetData(data);
		
		// If the stack is empty, and you need to add to it 
		
		if(count == 0) {
			
			front = node;
			rear = node;
		}
		
		// Otherwise you just have to make it point to the other one 
	
		else {	
			node.SetNext(front);
			front = node; 
		} 
		
		count++;
	 
	} 
	*/
	
	// Make sure to make your typical node, never ever forge to do that
	
	public void add(int data) {
		
		Noder node = new Noder();
		
		node.SetData(data);
		
		if(count == 0) {
			
			this.front = node;
			this.rear = node;
			
		} else {
			
			rear.SetNext(node);
	
			rear = node; 
		}
		
		count++;
		
	}
	
	public void add(Noder node) {
		
		
		
		
		
		if(count == 0) {
			
			this.front = node;
			this.rear = node;
			
		} else {
			
			rear.SetNext(node);
	
			rear = node; 
		}
		
		count++;
		
	}
	
	
	
	
	// Rememebr dont forget the 
	public int remove() {
		
		if(isEmpty()) {
			
			System.out.print(("critical failure"));
			
		}
		
		int temp = front.GetData();
		
		if(count-- == 0) {
		rear = null;
		front = null;
		count --;
		return temp;}
		
		

	 
	   front = front.next; 
		
		
	   
	   count--;
	   
		return temp;
		
		
	}
	
	public boolean remove(int data) {
		
		if(isEmpty()) {
			
			return false; 
			
		}
		
		int temp = front.GetData();
		
		//You are removing the first element in th list
		if(count==1 & temp == data) {
		rear = null;
		front = null;
		count --;
		return true;}
		
		

		Noder current = new Noder();
		current = front;
		
		
		// Here I will be iterating over the entire list to check 
		while(current.GetNext()!=null) {

			// There are going to be three possible secarios, you are removing from the front, the middle, or the end
			
			// If you are at the front of the list, and the first item is the one you are to remove
			if(current == front & data == current.GetData()){
				
				front = front.GetNext();// You have moved the front pointere forward
				count --;
				return true ;
				
			}
			// You are removing the end of the list 
			else if(current.GetNext() == rear & data == current.GetNext().GetData() ) {
				current.SetNext(null);
				rear = current;
				count--;
				return true;
			}
			
			
			// You are removing the middle of the list
			else if(current.GetNext().GetData() == data){
				
				
				current.SetNext(current.GetNext().GetNext());
				count--;
				return true;
				
				
			}
			
			
			current = current.GetNext();
			
			
			}
		
		return false; 
		
		
	 
		
		
	}
	
	
	
	
	
	
	
	
	public boolean find(int data) {

		
		if(isEmpty()) {
			
			return false;
		}
		
		// need to iterate over it, and check each item
		
		 Noder current = front;
		 
		 
		 while(current!=null) {
			 
			 if(current.GetData() == data) {return true;}
			 

			 current = current.GetNext();
		 }
		 
		 return false;
		
		
		
	}
	
	
	
	
	public String toString() {
		
		
		String output = "";
		
		Noder current = front;
		
		
		while(current!= null) {
			
			output = output + "," + current.GetData();
			
			current = current.GetNext();

		}
		
		
		return output;
		
		
	}
	
	
	
	
	public boolean isEmpty() {
		
		
		if(count ==0) {return true;}
		
		return false; 
		
		
	}


}
