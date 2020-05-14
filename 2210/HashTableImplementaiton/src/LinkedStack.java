
	/*
	 * @Author: David George 
	 * @Student ID: 251004930 
	 * @Class: CS2110
	 */
public class LinkedStack {
	
	Node front;
	Node rear; 
	int count; 
	
	
	public LinkedStack() {
		front = null;
		rear = null;
		count = 0; 
	}
	
	public void LinkedStackAdd(Record pair) {
		
		Node node = new Node();
		
		node.SetData(pair);
		
		if(count == 0) {
			
			this.front = node;
			this.rear = node;
			
		} else {
			
			rear.SetNext(node);
	
			rear = node; 
		}
		
		count++;
		
	}
	
	public boolean LinkedStackRemove(String config) {
		
		if(isEmpty()) {
			
			return false; 
			
		}
		
		String temp = front.GetData().getConfig();
		
		//You are removing the first element in the list
		if(count==1 & temp.equals(config)) {
		rear = null;
		front = null;
		count --;
		return true;}
		
		

		Node current = new Node();
		current = front;
		
		
		// Here I will be iterating over the entire list to check 
		while(current.GetNext()!=null) {

			// There are going to be three possible scenarios, you are removing from the front, the middle, or the end
			
			// If you are at the front of the list, and the first item is the one you are to remove
			if(current == front & config.equals(current.GetData().getConfig())){
				
				front = front.GetNext();// You have moved the front pointer forward
				count --;
				return true ;
				
			}
			// You are removing the end of the list 
			else if(current.GetNext() == rear & config.equals(current.GetNext().GetData().getConfig() )) {
				current.SetNext(null);
				rear = current;
				count--;
				return true;
			}
			
			
			// You are removing the middle of the list
			else if(current.GetNext().GetData().getConfig() == config){
				
				
				current.SetNext(current.GetNext().GetNext());
				count--;
				return true;
				
				
			}
			
			
			current = current.GetNext();
			
			
			}
		
		// You were not able to remove it becuase it was not in the table
		return false; 
		
		
	 
		
		
	}
	
	
public boolean LinkedStackFind(String config) {

		
		if(isEmpty()) {
			
			return false;
		}
		
		// need to iterate over it, and check each item
		
		 Node current = front;
		 
		 
		 while(current!=null) {
			 
			 if(current.GetData().getConfig().equals(config) ) {return true;}
			 

			 current = current.GetNext();
		 }
		 
		 return false;
		
		
		
	}
	
	
	

	public int LinkedStackGet(String config) {

		
		if(isEmpty()) {
			
			return -1;
		}
		
		// need to iterate over it, and check each item
		
		 Node current = front;
		 
		 
		 while(current!=null) {
			 
			 if(current.GetData().getConfig().equals(config) ) {
				 
				 return current.GetData().getScore();
				 
			 }
			 

			 current = current.GetNext();
		 }
		 
		 return -1;
		
		
		
	}
	public boolean isEmpty() {
		
		
		if(count ==0) {return true;}
		
		return false; 
		
		
	}


}
