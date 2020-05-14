import java.util.ArrayList;

// A ypical node, dont foret what it has , typical node will have a refernce to the next,

// and it hav  apointer to the data
// Vsiualuse it, hopeufll thtat makes sense



public class SLList {
	
	// Dont forget all of the special cases, there are two case 
	// for a singlely linked list, list is empty, or you are adding the first one to he list
	
	
	Node front;
	Node rear; 
	int n; 
	
	
	public SLList() {
		
		front = null;
		rear= null; 
		n = 0; 
	} 
	
	public SLList(int data) {
		
		Node current = new Node(); 

		current.SetData(data);
		
		
		front = current; 
		rear = current; 
		n = 1; 
		
		
	} 
	
	
	public boolean palindrome() {
		
		ArrayList <Integer> cool = new ArrayList<Integer>();
		this.reverse();
		for(int i = 0; i<this.n ; i++) {
			cool.add(this.get(i));
		}
	
		this.reverse();
		
		
		for(int i = 0; i<this.n ; i++) {
			if(this.get(i) != cool.get(i)) {
				return false;
			}
		}
		
		
		return true;
	}
	
	
	public int get(int index) {
		
		Node current = front;
		// This is if the list empty 
		if(n==0) {
			return 100000; 
		} 
		
		int count = 0;
		while(current!=null) {
			
			
			
			if(count == index) {
				return current.getData();
			}
	
			count++;
			current = current.GetNext();
			
		}
		return 1000000; 
		
	} 
	
	
	
	public void set(int index, int data) {
		Node current = front;
		if(n!=0) {
			
			int count = 0;
			while(current != null) {
				
				if(count == index) 
				
				{
					current.SetData(data);
					break;
				} 
				
				count++;
				current = current.GetNext();		
			} 

		} 
		
		
	}
	
	// This is adding to the end of the list
	public void addBefore(int data) {
		
		Node temp  = new Node();
		temp.SetData(data);
		
		// Special case, adding to an empty list
		if( n==0) {
			front = temp;
			rear = temp; 
			n++;
			
		} else {
			
			
			rear.SetNext(temp);
			rear = temp; 
			n++;
			
		} 
	} 
	
	
	public void add(int index, int data) {
		Node temp = new Node();
		temp.SetData(data);
		
		Node current = front;
		int count = 0; 
		
		if(n!=0) {
			
			while(current!= null) {
				
				
				if(count == index) {
					// This is the very first element, index 0;
					if(index == 0) {
						
						temp.SetNext(current);
						front = temp;
						n++;
						count++;
						break;
						
					}
					
					// Trying to wedge 
					else if(current == rear) {
						
						Node yolo = front; 
						while(yolo.GetNext()!=rear) {
							yolo = yolo.GetNext();
						}
	
						yolo.SetNext(temp);
						
						temp.SetNext(rear);
						n++;
						count++;
						break;
						
					}
					
					// Adding it to the middle of the linked linked
					else {	
						
						if(count + 1 == index) {
							
							temp.SetNext(current.GetNext());
							current.SetNext(temp);
							n++;
							count++;
							break;
							
							
						}
	
					}
					
				}
				current = current.GetNext();
				n++;
				count++;
			}
			
			
			
			
			
			
		}
		
		
		
		
		
		
	}
	
	
	
	public String toString() {
		
		String output = ""; 
		
		Node current = front; 
		
		
		while( current!= null) {
			
			output = output + "," + current.getData();		
			
			
			current = current.GetNext();
			
		}

		return output; 
		
	} 
	
	
	public void reverse() {
		
		int size = n-2; 
		
		Node real = rear;
		
		while (front!=rear) {
			
			rear.SetNext(reverser(size));
			
			size--;
			rear = rear.GetNext();
		}
		
		rear.SetNext(null);
		
		
	
		front = real;
		
	
	}
	
	
	public void checksize() {
		
		
		Node current = front;
		
		int count = 0; 
		while (current!= null) {
			
			count =  count + 1;
			current = current.GetNext();
		}
		
		
		if(this.n != count) {
			
			System.out.print("You suck");
			
		}
		
		
		
	}
	
	
	
	
	
		
	
	
	
	public Node reverser(int number) {
		
		Node current = front; 
		int count = 0;
		while(count < number) {
			
			current = current.GetNext();
			count++;
		}
		
		return current;
		
	}
	
	
	
	
	
	public static void main(String[] args) {
		
	 SLList swag = new SLList();
		
	swag.addBefore(1);
	swag.addBefore(1);
	swag.addBefore(2);
	swag.addBefore(2);
	swag.addBefore(1);
	swag.addBefore(1);
	 
	 
	 System.out.println(swag.palindrome());
	 
	
	 
		
		
	}
	
	
	
	
}
