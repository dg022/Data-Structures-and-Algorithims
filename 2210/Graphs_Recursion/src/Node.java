
// Author: David George
// Student Number: 251004930


public class Node {
	
	//Defining the Node class
	// Getters and setters for the node class
	
	int name; 
	boolean marked; 
	
	public Node(int name) {
		
		this.name = name; 
	}
	
	public void setMark(boolean mark) {
		
		this.marked = mark; 
		
	}
	
	boolean getMark() {
		
		return marked; 
		
	}
	
	
	
	int getName() {
		
		return this.name;
		
	}
	

}
