import java.util.*;


public class DL {
	
	DLLNode front; 
	DLLNode rear; 
	
	int count; 
	
	
	// default constructor, when nothing is in the list
	// This is where you add stuff!1!
	
	public DL() {
		
		this.front = null;
		this.rear =null;
		this.count = 0; 
		
	}
	
	public void add(int data) {
		
		DLLNode node = new DLLNode();
		node.SetData(data);
		
		
		
		if(count == 0) {
			// If this is the only shit let
			front = node; 
			rear = node;
			
		}
		
		else {
			
			rear.SetNext(node);
			node.SetPrev(rear);
			rear = node;
			
		}
		
		
		count++;
		
		
		
		
		
		
	}
	
	
	// There are three cases, the list is empty, the list only has one item 
	// First, middle, last. 
	
	public int remove (int data) {
		
		DLLNode current = new DLLNode();
		current = front;
		// First case, the list is empty. 
		
		if(count == 0) {
			return 0;
		}
		
	
		// You should go like this, you should be iterating over the whole thing,
		// Checking all the cases as you go. 
		
		
		while(current!=null) {
			
			if(current.GetData()== data) {
				
				// Check the second case, this is if there is only one node
				
				if(count == 1) {
					
					front = null;
					rear = null;
					
					
					count--;
					return data;
				}
				
				// Not one hundred sure how this works with equals method
				else if(current == front) {
					
					front = front.GetNext();
					count --;	
					return data; 
				} 
				
				
				// This is checking the same if you are at the last node
				
				else if(current == rear) {
					
					rear = rear.GetPrev();
					rear.SetNext(null);
					
					count --; 
					return data;
				}
				
				
				else {
					// There are always going to be five cases for linked lists
					// problems 
					current.GetPrev().SetNext(current.GetNext());
					current.GetNext().SetPrev(current.GetPrev());
					count--;
					return data;
				}
				
				
				
				
			}
			
			
			else {
				
				current = current.GetNext();
			}
			
			
			
			
			
			
			
		}
		
		
		
		
		
		return 0; 
	}
	
	
	
	
	
	
	
	
	public String toString() {
		
		
		String output = "";
		
		DLLNode current = front;
		
	
		while(current!=null) {
			
			output = output + "," + current.GetData();
			
			current = current.GetNext();
			

		}

		return output;
		
		
	}
	
	
	
	public void addBefore(DLLNode chode, int data) {
		
		DLLNode node = new DLLNode();
		node.SetData(data);
		
		// What if you are adding a node before a certian node
		// Well, what if the linked list empty? 
		
		
		if(count == 0) {
			// If this is the only shit let
			front = node; 
			rear = node;
			
			
		} else { 
			
			
			DLLNode current = front;
			
			while (current!=null) {
				
				if(current.GetData() == chode.GetData()) {
					
					// Check imagine if there are only8 two nodes
					
					if(current == rear) {
						
						DLLNode temp  = current.GetPrev();
						
						current.SetPrev(node);
						node.SetNext(current);
						node.SetPrev(temp);
						temp.SetNext(node); 
						rear = current;
						count++; 
					}
					
					//at the front 
					
					if(current == front) {
						
						node.SetNext(front);
						front.SetPrev(node);
						front = node; 
						
					}
					
					
					else {
					// if its in the middle 
						
						DLLNode temp  = current.GetPrev();
						
						current.SetPrev(node);
						node.SetNext(current);
						node.SetPrev(temp);
						temp.SetNext(node); 
						count++;
						
					}

				}
				
				current = current.GetNext();
				
			}
			
			
		}
		count++;
	} 
	
	
	public void set(int index, int data) {
		DLLNode current = front;
		if(this.count!=0) {
			
			int n= 0;
			while(current != null) {
				
				if(n == index) 
				
				{
					current.SetData(data);
					break;
				} 
				
				n++;
				current = current.GetNext();		
			} 

		} 
		
		
	}
	
	public int get(int index) {
		DLLNode current = front;
		if(this.count!=0) {
			
			int n= 0;
			while(current != null) {
				
				if(n == index) 
				
				{
					return current.GetData();
					
				} 
				
				n++;
				current = current.GetNext();		
			} 

		}
		return 11111110; 
		
	}
	
	//This will always remove the last one
	public int remove() {
		
		// There are two special cases you have to consider 
		
		if(this.count == 0) {
			System.out.println("no");
			return 000000; 
		} 
		
		else if(this.count ==1) {
			
			int temp = this.get(0);

			front = null;
			rear= null; 
			this.count --;
			return temp;
			
			
		}
		
		else { 
			
			int tempo = this.get(this.count-1);
			
			rear = rear.GetPrev();
			rear.SetNext(null);
			
			
			return tempo;
			
			
		}
	
		
		
		
		
	} 
	
	
	
	
	
	
	
	
	
	public void Rotate(int  r) {
		
		rear.SetNext(front);
		front.SetPrev(rear);
		
		DLLNode Dummy = new DLLNode();
		DLLNode Temp = new DLLNode();
		
		if(r != 0) {
		for(int i = 0; i < this.count   ;i++) {
			
		
			if(i==0) {
			Dummy.SetData(this.get(i));
			
			this.set(i, this.get(mod(i-r)));
			}
			
			else {
			Temp.SetData(this.get(i));
			this.set(i, Dummy.GetData());
			Dummy.SetData(Temp.GetData());
			}
			
			
		} 
		
		// This problem is too insane, come back,
		// You also heavily misenterpreted it 
		// COME BACK
		
		}
		
		
		
		
		
	}
	
	
	public int mod(int s) {
		
		
		if(s<0) { return s + this.count;}
		
		else {return s%this.count;}
		
	}
	
	
	
	
	
	
	public DL truncate(int index) {
		
		
	DLLNode current = front; 
	DL list = new DL();
	
	
	int counts = 0; 
	
	if(this.count!=0) {
		
		while(counts!= index) {current=current.GetNext();
			counts++;}
		this.rear = current.GetPrev();
		list.front = current; 
	}
	
	
	
	current = list.front;
	
	while(current.GetNext()!=null) { 
		
		current=current.GetNext();
		
	}
	
	list.rear = current; 
	
	return list;
		
		
		
		
	}
	
	
	public void absord(DL list) {
		
		
		
		DLLNode Fronter = list.front;
	
		
		while(Fronter!=null) {
			
			rear.SetNext(Fronter);
			Fronter.SetPrev(rear);
			rear = Fronter; 
			this.count++;
			Fronter = Fronter.GetNext();
		}
		
	}
	
	
	public void reverse() {
		
		DLLNode Noder = rear;
		DLLNode node = front; 
		

		DLLNode current = rear; 
		
		
		 while(current.GetPrev()!=null) {
			 
			 
			 current.SetNext(current.GetPrev());
			
		
			 current = current.GetPrev();
		 }
		 
		 
		 current.SetNext(current.GetPrev());
		 
		 front = Noder;
		 rear = node;
		
		
		
	} 
	
	
	
	public void TakeFirst(DL list) {
		
		this.add(list.get(0));
		
	}
	
	
	public  static DL merge(DL l1, DL l2) {
		
		DL temp = new DL();
	
		ArrayList<Integer> cool = new ArrayList<>();
		
		
		for(int i = 0; i<l1.count; i++) {
			cool.add(l1.get(i));
		}
		
		for(int i = 0; i<l2.count; i++) {
			cool.add(l2.get(i));
		}
		
		cool.sort(null);
		
		for(int i = 0; i<cool.size(); i++) {
			temp.add(cool.get(i));
		}
		
		
		
		
		return temp;
		
	}
	
	
	public DL sort(DL list) {
		
		DL swag = new DL();
		
		
		if (list.count == 0 || list.count == 1) {
			return list; 
		}
		
		else {
			
			DL yolo = this.truncate(this.count/2);

			return merge(yolo.sort(yolo), this.sort(this));
			
		}
		
		
	}
	
	
	
	
	
	
	
	
	
	

	
	public static void main(String[] args) {
		
		DL swag = new DL();
		DL yoo = new DL();
		
		
		for(int i = 0; i < 10; i++){
		
			swag.add(i);
		
		}
		
		
		for(int i = 10; i < 0; i--){
			
			swag.add(i);
		
		}
		
		
		
		System.out.print(swag.sort(swag));
		


		
		

	


	}
	

	
	

}
