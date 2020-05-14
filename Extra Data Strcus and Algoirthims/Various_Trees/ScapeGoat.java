
public class ScapeGoat {
	
	
	
	BSTNode r; 
	
	int count;
	
	
	BSTNode [] a = new BSTNode[20];
	int q = 10;

	
	
	
	public ScapeGoat(){
		
		r = null;
		count = 0; 
		
		
		
	}
	
	
	
	
	public BSTNode find(int data) {
		
		// Here i am creating a new node that will be added to shit if need be 
		BSTNode u = new BSTNode();
		u.data  = data;
		
		BSTNode current = r; 
		
		
		if(count == 0) {
		
	
			return r;
			
		}
		
		else {
			
			
			boolean added = false;
			
			
			while(!added) {
				
				if(current.data < u.data) {
					
					current = current.right;
					
					
				} else if(current.data  > u.data) {
					
					current= current.left;
					
				} else {

					return current; 
					
				}
			}

			
		}
		return current;
		
	}
	
	
	public boolean BinaryAdder(int data) {
		
		// Here you hace created a new node
		BSTNode u =   new BSTNode();
		u.data = data;
		
		// Now check if you are empty
		
		if(count == 0) {
		
			
			r = u;
			count++;
			return true;
			
		}
		
		
		else {
			
			
			boolean added = false; 
			BSTNode current = r; 
			
			while(!added) {
				
				
				
				
				// The problem with the code is that you havent set the parent so it comes up as null
				// We are not doing less than or equal to, if its equal to then you will not add it to the binary structure as it implments the SSet interface 
				if(current.data < u.data) {
					
					if(current.right == null) {
						current.right = u;
						// This will put a pointer in the correct posisiton
						u.parent = current;
						
						return true;
					} else {
						
						
						current = current.right;
						
					}

				} else if(current.data > u.data ) {
					
					if(current.left == null) {
						
						count++;
						current.left = u;
						u.parent = current;
						return true;
						
					} else {
						
						current = current.left;
						
					}
					
					
					
				} else {
					// right here that means its equal to another element in the binary tree so no need to add i, return false
					return false;
				}

			}

		}

		return false;
		
	}
	
	
	
	// This will reeturn the number of nodes subrooted at u 
	public static int Size(BSTNode u) {
		
		if(u == null) 
		
		{
			return 0;
		}
		
		
		return 1 + Size(u.left) + Size(u.right);
		
		
		
	}
	
	
	
	public void rebuild(BSTNode u) {
		
		
		int ns = Size(u);
		
		BSTNode p =  u.parent; 
		
		// An array with 10 spots to begin
		BSTNode [] a = new BSTNode[10];
		
		
		
		ArrayPacker(u, a, 0);
		
		// If u's parent is null therefore it is the root
		if(p == null) {
			
			r = buildBalenced(a , 0, ns);
			r.parent = null; 
			
		} else if(p.right == u) {
			// This is if u's parent right child is u
			p.right = buildBalenced(a, 0, ns);
			p.right.parent = p; 
			
			
		} else {
			
			
			p.left  =  buildBalenced(a, 0, ns);
			p.left.parent = p; 

		}
		
		
		
		
		
	}
	
	// U willl be the node that you feed into the rebuild funciton, hence why 
	// They have the same names
	public static int ArrayPacker(BSTNode u,  BSTNode a[], int i) {
		
		if(u == null) {
			
			return i;
		}
		
		
		i = ArrayPacker (u.left, a , i);
		a[i++] = u;
		
		return ArrayPacker(u.right, a, i);
		
		
		
	}
	
	
	
	
	
	 
	public BSTNode buildBalenced( BSTNode[] a, int i, int ns) {
		
		
		if(ns == 0) 
		{
			
			return null;
			
		}
		
		int m = ns / 2; 
		
		a[i + m].left = buildBalenced(a, i, m);
		
		if (a[i + m].left != null) {
			a[i + m].left.parent = a[i + m];
		}
		
		a[i + m].right = buildBalenced(a, i + m + 1, ns - m - 1);
		
		if (a[i + m].right != null) {
			a[i + m].right.parent = a[i + m];
		}
			
		
		return a[i + m];

	}
	
	
	
	public int Depth(BSTNode u) {
		
		int d  = 0;
		
		
		
		while(u!=r) {
			d++;
			u=u.parent;
		}
		
		return d;
		
		
	}
	
	
	
	public double logOfBase(int base, int num) {
	    return Math.log(num) / Math.log(base);
	}
	
	
	
	
	public void add(int x) {
		
		BinaryAdder(x);
		
		count++;
		
		
		BSTNode u = find(x);
		int d = Depth(u);
		
		if(d > logOfBase(32, q)) {
			
			BSTNode w = u.parent;
			
			// This finds the scape goat for you
			while(3*Size(w) <= 2*Size(w.parent)) {
				
				w = w.parent; 
				
			}
			
			rebuild(w.parent);
			
			
		}
		
		
		
		
	}
	
	
	
	
	public static void main(String[] args) {
		
		
		ScapeGoat yolo  = new ScapeGoat(); 
		
		for(int i = 0; i < 100; i++) {
		yolo.add(i);		
		
		}
		
		
	}
	
	

}
