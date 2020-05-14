
//Name: David George
//Student ID: 251004930

import java.util.Iterator;
import java.util.LinkedList;

public class Graph implements GraphADT {

	Container AdjacencyList[];

	public Graph(int n) {

		// Creates an array of containers
		// They contain nodes, and point the connections that each node has
		AdjacencyList = new Container[n];

		for (int i = 0; i < n; i++) {
			
		
			
			AdjacencyList[i] = new Container(new Node(i));
		}

	}

	public Node getNode(int name) throws GraphException {

		if (name >= AdjacencyList.length) {

			// You are supposed to throw a GraphException
			throw new GraphException(); 
		}
		return AdjacencyList[name].vertex;
	}

	public void insertEdge(Node u, Node v, int edgeType) throws GraphException {

		if (getNode(u.getName()) == null || getNode(v.getName()) == null) {

			throw new GraphException(); 

		}

		// Check if Node u is connected to Node V, no need to check vise versa
		// Because when the edges are inserted, they are inserted only ever both ways

		if (AdjacencyList[u.getName()].connections.contains(v)) {

			throw new GraphException(); 

		}

		// Add to the linked list for both nodes, since the graph is undirected
		
		Edge UtoV = new Edge(u, v, edgeType); 
		Edge VtoU = new Edge(v, u, edgeType); 
		AdjacencyList[u.getName()].connections.add(UtoV);
		AdjacencyList[v.getName()].connections.add(VtoU);

	}
	
	
	
	public Iterator incidentEdges  (Node u) throws GraphException {
		
		
		if (getNode(u.getName()) == null) {

			throw new GraphException(); 

		}
		
		
		if(AdjacencyList[u.getName()].connections.isEmpty()) {
			
			return null; 
		}
	
		
		
		
		Iterator itr = AdjacencyList[u.getName()].connections.iterator();  
		
		
		return itr; 
	
		
		
	}
	
	
	
	
	
	public Edge getEdge(Node u, Node v) throws GraphException{
		
		if (getNode(u.getName()) == null || getNode(v.getName()) == null) {

			throw new GraphException(); 

		}
	
		Edge found =  AdjacencyList[u.getName()].find(u, v); 
		
		if (found !=null) {

			return found; 
		}
		
		return null; 
		
	}
	
	
	
	
	public boolean areAdjacent(Node u, Node v) throws GraphException {
		
		
		
		
		if (getNode(u.getName()) == null || getNode(v.getName()) == null) {

			throw new GraphException(); 

		}
		
		Edge found =  AdjacencyList[u.getName()].find(u, v); 
		if(found!=null) {
			return true; 
		}
		
		return false; 
		
	}
	
	

}



