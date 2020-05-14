
public class DLList<T> implements DLListADT<T> {

	private DLNode<T> front; 
	private DLNode<T> rear; 
	private int count;
	
	public DLList() {
		 front = null;
		 rear = null;
		 count = 0 ; 
	}
	
	public void insert(T dataItem, int value){
	
		DLNode<T> node = new DLNode<T>(dataItem, value);
		
		/**
		 * If its empty, this node will be the first node in the list. 
		 */
		
		if(isEmpty()) {
			front = node;
			rear = node;
			count++;
			
		}
		
		/**
		 * If not empty, add to the end,increase the count. 
		 */
		
		else if(!isEmpty()) {
				
			node.setPrevious(rear);
			rear.setNext(node);
			rear = node;
			count++ ; 
			
		}
		
	}

	
	public T getSmallest() throws EmptyListException
	{
		
		if (isEmpty()) {
		      throw new EmptyListException("list");
		}
		
		DLNode<T> current = front;
		T data = front.getData(); 
		int small = front.getValue();
		
		while ((current.getNext()!= null) || (current.getNext()== null && current == front && current == rear) || (current.getNext()== null && current == rear)) {
			
			
			/**
			 * Save the smallest value, which will update every time there is a smaller value. 
			 */
			
			if(current.getValue()< small) {
				
				small = current.getValue();
				data = current.getData(); 
				
			}
			
			
			
			if(current != rear) {
				current = current.getNext(); 
				}
				else {
					break;
				} 
		}
		
		/**
		 * Will return the deleted node with the smallest value, using helper delete method. 
		 */
		return(Delete(data)); 
		
		}
		
		
		
	/**
	 * Chnages the value given a node and replaces it with anoother intiger. 
	 */
	
	

	public void changeValue(T dataItem, int newValue) throws InvalidDataItemException {
		
		DLNode<T> current = front; 
		boolean found = false; 
		
		while(current !=  null) {
			
			/**
			 * If information is found, will change it with data from the specfic paramter. 
			 */
			
			if(current.getData().equals(dataItem)){
				
				found = true;
				current.setValue((newValue));
				break;
			}
			
			current = current.getNext();
			
		}
		
		if(!found) {
			
			throw new InvalidDataItemException("Data not in list");
			
		}
		
	}
	
	
	/**
	 * Deltes the node
	 * @return the deleted node
	 */
	
	private T Delete(T dataItem) throws EmptyListException {
		
		// Will iterate through the list
		// If the node to delete is at the front, middle or end, will do differnt things. 
		
		DLNode<T> current = front; 
		DLNode<T> temp;
		boolean found = false; 
		
		current = front; 
		while ((current.getNext()!= null) || (current.getNext()== null && current == front && current == rear) || (current.getNext()== null && current == rear))   {
			
			
			
			
			if (current.getData().equals(dataItem)) {
				
				
				/**
				 * if its the first and only node in the list 
				 */
				if(current == front && current == rear) {
					front = null;
					rear = null; 
					temp = current; 
					current.setPrevious(null);
					current.setNext(null);
					front = null;
					rear = null; 
					count--; 
					return temp.getData();
					
				}
				
				/**
				 * If its the first node but not the only node 
				 */
				
				if(current == front && current != rear) {
				
					temp = front; 
					front = current.getNext(); 
					count--; 
					current = front; 
					return temp.getData();
					
				}
				
				/**
				 * If its the end of the list 
				 */
				
				if(current== rear && current!=front) {
					
					temp = rear;
					rear = current.getPrevious();
					rear.setNext(null);
					count--;
					
					return temp.getData();
				}
				
				/**
				 * If  its at some point between the front or middle.  
				 */
				if (current!=front && current !=rear){
					current.getPrevious().setNext(current.getNext());
					current.getNext().setPrevious(current.getPrevious());
					count--; 
					return current.getData();
		
				}
			}
		
			if(current != rear) {
				current = current.getNext(); 
				}
				else {
					break;
				} 
		}
		
		throw new InvalidDataItemException("Can't find it here");
	}	
	
	
	
		
	public int getDataValue(T dataItem) throws InvalidDataItemException {
		
		DLNode<T> current = front; 
		
		/**
		 *  Goes through until it can find it. 
		 */
		while (current.getNext()!= null) {
			
			if (current.getData().equals(dataItem)) {
				
				return current.getValue(); 
			}
			
			if(current != rear) {
				current = current.getNext(); 
				}
				else {
					break;
				} 
		}
		
		throw new InvalidDataItemException("Invalid Data Item ");
	}

	public boolean isEmpty() {
		
		return(count == 0);
	}

	public int size() {
		
		return count;
	} 
	
	public String toString(){
	    DLNode<T> current = front;
	    String answer = "";
	    String first = current.getData().toString();
	    String list = "List:";
	    while ( current != null ){
	          	answer =  answer + " " + current.getData().toString() +","+ current.getValue() +";";
	            current = current.getNext();
	          }
	    return list + answer;
	  }
	
	
}
