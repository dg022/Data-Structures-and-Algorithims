

	/*
	 * @Author: David George 
	 * @Student ID: 251004930 
	 * @Class: CS2110
	 */


	/*
	 * This is a basic node class, LinkedStack will hold these nodes
	 */


public class Node {
	
	Node next; 
	Record data;
	
	public Node() {
		
		this.next = null; 
		data = null;
		
	}
	
	
	public Node(Record data) {
		
		this.next = null; 
		this.data = data; 
	
		
	}
	
	
	public void SetNext(Node node) {
		this.next =  node; 
	}
	
	
	public Record GetData() {
		return this.data; 
	}
	
	public Node GetNext() {
		
		return this.next;
	}
	
	
	public void SetData(Record data) {
	
		this.data = data;
		
	}
	
	
	

}
