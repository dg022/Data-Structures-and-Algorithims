import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree {
	
	
	BinaryNode r; 
	int count; 
	ArrayList<Integer> swag = new ArrayList<Integer>();
	
	
	BinarySearchTree(){
		
		
		r = null;
		count = 0; 
	}
	
	
	
	public boolean add(int data ) {
		
		
		
		BinaryNode u = new BinaryNode();
		u.data = data;
		boolean added = false; 
		
		
		if(count == 0) {
			
			r = u;
			count++;
			return true; 
			
			
			
		}
		
		
		else {
			
			
			
			
			
			BinaryNode marker = r;
			
			// Then it will go to the right
			
			
			while(!added) {
			if(u.data > marker.data) {
				
				
				if(marker.right == null)
				{
					
					marker.right = u;
					count++;
					return true; 
	
				} else {
					
					marker = marker.right;
					
				}	
				
				
			} else if(u.data < marker.data) {
				
				
				if(marker.left == null)
				{
					
					marker.left= u;
					count++;
					return true; 
	
				} else {
					
					marker = marker.left;
				}
				
				
				
				
			} else {

				return  false; // This means that its already in the list and it cannot be found 

			}
			
			}
			

			
		}
		

		
		return false;

		
	}
	
	
	// Holy DUDE IM SO FUCKIN PROUD OF you, this was a diffiuclt ass quesiton
	// But you found a recursive sololution to it, which is FOOOkin sick 
	public ArrayList GetLe(int data, BinaryNode s) {
		
		
		if(s.left == null & s.right == null ) {
			
			if(s.data<=data) {this.swag.add((s.data));}
			
			return this.swag;
		}

		if(s.data <= data) {
			
			this.swag.add(s.data);
			if(s.left!=null) {
			BD(s.left);
			}
			
			if(s.right!=null) {
			GetLe(data, s.right);
			}
		}
		
		
		
		else if(s.data > data) {
			
			// At this point the rifht subtree will not even be considered
			
			if(s.left!=null) {
			GetLe(data, s.left);
			}
			
			
		}
		return this.swag;
	}
	
	//  This Breadth  Addidtion will be added I reach a certain point in the list 
	public void BD(BinaryNode u) {
		
	Queue<BinaryNode> swag = new LinkedList<BinaryNode>();
	
	swag.add(u);
	
	while(!swag.isEmpty()) {
		
		BinaryNode y  = swag.remove();
		this.swag.add(y.data);
		if(y.left!=null) {swag.add(y.left);}
		if(y.right!=null) {swag.add(y.right);}
		
	}
		
	}
	

	public void bf() {
		
		BinaryNode u = r; 
		
		Queue<BinaryNode> swag = new LinkedList<BinaryNode>();  // Dont forget that a queue is an abstreact type, you stull gotta implment it some how 
		
		if(r!=null) {swag.add(r);}
	
		
		while(!swag.isEmpty()) {
			
			BinaryNode y  = swag.remove();
			System.out.print(y.data);
			if(y.left!=null) {swag.add(y.left);}
			if(y.right!=null) {swag.add(y.right);}
			
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		
		
		BinarySearchTree u = new BinarySearchTree();
		
		u.add(7);
		u.add(3);
		u.add(11);
		u.add(1);
		u.add(5);
		u.add(9);
		u.add(13);
		
		
		System.out.println(u.GetLe(13, u.r));
		
		

		
		
		
	}
	
	

}
