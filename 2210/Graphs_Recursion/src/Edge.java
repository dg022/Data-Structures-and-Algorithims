//Name: David George
// Student ID: 251004930 


public class Edge {
	
	
	Node EndPoint1;
	Node EndPoint2;
	int type; 
	
	// Constructor, setting the end points and type 
	
	public Edge(Node u, Node v, int type) {
		
		EndPoint1 = u; 
		EndPoint2 = v; 
		this.type = type; 
	}
	
	//The following are all getters and setters

	Node firstEndpoint() {
		
		
		return EndPoint1; 
	}
	
	
	Node secondEndpoint() {
		
		
		return EndPoint2; 
	}
	
	
	int getType() {
	
		return type; 
	}

}
