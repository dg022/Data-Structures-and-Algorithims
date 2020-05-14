// Author David George
// 

import java.util.Iterator;
import java.util.LinkedList;


public class Container {
	
	Node vertex; 
	LinkedList connections;   
	
	public Container(Node vertex) {
		
		this.vertex = vertex; 
		
		connections = new LinkedList<Edge>(); 
	}
	
	

	
	public Edge find(Node u, Node v) {
		
		
		
		for(int i = 0; i<connections.size(); i++) {
			
			 Edge found = (Edge) connections.get(i); 
			 if(found.EndPoint1 == u && found.EndPoint2 == v)  {
				 return found; 
			 }
		}
		
		
		return null; 
		

		
		
		
		
	}
	

}
