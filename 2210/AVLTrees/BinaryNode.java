//Author David George
// Student ID: 251004930
public class BinaryNode {

	Pixel value;
	BinaryNode left;
	BinaryNode right;
	BinaryNode parent;

	public BinaryNode(Pixel value, BinaryNode left, BinaryNode right, BinaryNode parent) {

		this.value = value;
		this.left = left;
		this.right = right;
		this.parent = parent;

	}
	
	
	public BinaryNode() {
		
		
		this.value = null;
		this.left = null;
		this.right = null; 
		this.parent = null;

		
		
	}
	
	// Get and set based on assignment description 
	
	public BinaryNode getParent() {
		
		
		return this.parent; 
		
	}
	
	public void setParent(BinaryNode parent) {
		
		this.parent = parent; 
		
	} 
	
	
	 public void setLeft (BinaryNode p) {
		 
		 this.left =  p; 
	 }
	 
	 public void setRight (BinaryNode p) {
		 
		 this.right =  p; 
	 }
	 
	 
	 public void setData (Pixel value) {
		 
		 this.value =  value; 
	 }
	 
	 
	 public boolean isLeaf() {
		 
		 if(this.left == null & this.right == null &this.value == null) {
			 
			 return true;
			 }
		 
		 return false; 
	 }
	 
	 
	 public Pixel getData() {
		 
		 return value;
	 }
	 
	 public BinaryNode getLeft() {
		 
		 return left; 
	 }
	 
	 public BinaryNode getRight() {
		 
		 return right; 
	 }
	
	
	
	
	
	

}
