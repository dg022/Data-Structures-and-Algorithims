
public class SLL {
	
	
	Node front; 
	Node rear; 
	 int n; 
	 
	 
	 
	 public SLL() {
		 front = null; 
		 rear = null;
		 n  = 0; 
	 }
	 
	 
	 public SLL(int data) {
		 
		 Node temp = new Node();
		 temp.SetData(data);
		 front = temp;
		 rear = temp;
		 n = 1;	 
	 } 
	 
	 
	 public void add(int data) {
		 
		 Node temp = new Node();
		 temp.SetData(data); 
		 
		 // This mehtod is just used to add to then end of the linked list 
		 
		 
		 if(n == 0) {
			 rear = temp;
			 front = temp; 
			 n++; 
			 
		 }
		 
		 else {
			 // This is adding to the end of the list
			 
			 rear.SetNext(temp);
			 rear = temp;
			 n++;
			
		 }
		 
		 
		 
		 
	 }
	 
	 
	 public int secondlast() {
		 
		 // if there is only one element, this cannot work
		 //So you just have to return a  
		 
		 Node current = front; 
		 
		 if (front == rear) {
			 System.out.println("This cannot work");
			 return 0;
			  }
		
		 
		 else {
			 
			 
			 while(current.GetNext().GetNext() != null) {
				 
				 current = current.GetNext();
			 }

		 }

		 return current.getData();
	 } 
	 
	 
	 public String toString() {
		 
		 String output = ""; 
		 
		 
		 Node current = front;
		 
		 if(rear==null & front == null) {
			 
			 return output;
		 }
		 
		 while(current!= null) {
			 
			 output = output + "," + current.getData();
			 
			 current = current.GetNext();
 	
			 
		 }
		
		 return output;
		 
	 }
	 
	 
	 
	 
	 public static void main(String[] args) {
		 
		 SLL swag  = new SLL(); 
		 
		 for(int i = 0; i < 10; i++)  {
			 
			 swag.add(i);
			 
		 }
		 
		 
		 System.out.print(swag.secondlast());
		 
		 
	 }
	 
	 
	 
	 

}
