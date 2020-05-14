import java.util.*;
import java.lang.*;
public class BinaryTree {
	
	BinaryNode r; 
	int count; 
	int swaggerCount = 0; 
	BinaryNode Saver;
	ArrayList <BinaryNode> l1 = new ArrayList<BinaryNode>();
	
	
	
	
	public BinaryTree() {
		r = new BinaryNode();
		r.data = 0;
		
		BinaryNode u = new BinaryNode();
		BinaryNode s = new BinaryNode();
		//Left hand side of the left node 
		r.left = u; 
		u.data =1;
		//Right hand side of the r node 
		r.right = s ;
		s.data = 2;
		
		// Right hand side 
		BinaryNode t = new BinaryNode();
		BinaryNode q = new BinaryNode();
		s.right =t;
		t.data = 6;
		s.left = q ; 
		q.data = 5;
		
		
		// Right, left 
		BinaryNode qs = new BinaryNode();
		q.left = qs;
		qs.data=9;
		
		//Right, right 
		BinaryNode ts = new BinaryNode();
		BinaryNode qe = new BinaryNode();
		t.left = ts;
		ts.data = 10;
		t.right = qe;
		qe.data = 11;
		
		
		
		// Left hand side 
		BinaryNode e = new BinaryNode();
		BinaryNode w = new BinaryNode();
		u.left = e;
		e.data = 3;
		u.right  = w; 
		w.data = 4;
		
		
		// Left, right 
		BinaryNode b = new BinaryNode();
		BinaryNode i = new BinaryNode();
		w.left = b;
		b.data = 7;
		w.right = i;
		i.data = 8;
		
		
		
		
		
		
	}
	
	
	public BinaryTree(BinaryNode cool) {
		
		this.r = cool; // This means you are initialsing a tree with a node. 
		count = 0;
	}
	
	
	public int depth(BinaryNode u) {
		
		// Depth is how far away is the given node, awauy from the root 
		
		
		int d = 0; 
		while(u!=r) {
			
			u = u.parent; 
			d++; 
		}
		
		return d;
	}
	
	
	
	public int size(BinaryNode u) {
		
		// This will give you the number nodes in some subtree
		
		if(u == null) {return 0;}
		
		
		return 1 + size(u.left) + size(u.right);
	}
	
	
	
	public int height(BinaryNode u) {
		
		
		if(u == null) {return -1;}
		
		
		
		
		return 1+ max(height(u.left), height(u.right));
		
	}
	
	public int max(int i1, int i2) {
		
		
		if(i1 > i2) {return i1;}
		
		else if(i2 > i1) {return i2;}
		
		return i1;
	}
	
	
	public void Traverse(BinaryNode u) {
		
		if(u == null) {return ;}
		
		System.out.print(u.data);
		if(u.right!=null) {Traverse(u.right);}
		if(u.left!=null) {Traverse(u.left);}
		
		
	}
	
	
	public void NormalSetter(BinaryNode u) {
		
		if(u == null) {return ;}
		
		System.out.print(u.data);
		if(u.right!=null) {Traverse(u.right);}
		if(u.left!=null) {Traverse(u.left);}
		
		
	}
	
	
	
	
	
	
	public void preOrderNumber(BinaryNode u) {
		
		if(u == null) {return ;}
		
		System.out.print(u.data);
		if(u.left!=null) {preOrderNumber(u.left);}
		if(u.right!=null) {preOrderNumber(u.right);}
		
		
		
	}
	
	
	public void preOrderAdder(BinaryNode u) {
		
		if(u == null) {return ;}
		
		l1.add(u);
		if(u.left!=null) {preOrderAdder(u.left);}
		if(u.right!=null) {preOrderAdder(u.right);}
		
		
		
	}
	
	public BinaryNode nextPreOrder(BinaryNode u) {
		
		if(Saver!=null) {
			
			u = Saver;
		}
		
		if(swaggerCount == 0) {
			
			preOrderAdder(u);
			//Thats the first one  thats been added, take it off
			l1.remove(0);
			swaggerCount++;
		}
		
		
		if(!l1.isEmpty()) {
			
			
			 Saver = l1.remove(0);
			 System.out.print(Saver.data);
			 return Saver;
			 
			
			
			
		}
		
		return Saver;
		
		// Now the queue only has the next steps 
		
		
		
		
		
	}
	
	
	
	
	public void inOrderNumber(BinaryNode u) {
		
		if(u == null) {return ;}
		
		if(u.right!=null) {inOrderNumber(u.right);}
		System.out.print(u.data);
		if(u.left!=null) {inOrderNumber(u.left);}
		
		
	}
	
	public void postOrderNumbers(BinaryNode u) {
		
		if(u == null) {return ;}
		
		
		if(u.right!=null) {Traverse(u.right);}
		if(u.left!=null) {Traverse(u.left);}
		System.out.print(u.data);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	public void adds(int data) {
		
		
		BinaryNode u = new BinaryNode();
		u.data=data;
		BinaryNode prev = null;
		BinaryNode s = new BinaryNode();
		s=r;
		
		if(count == 0) {
			
			this.r  = u; 
			this.r.data = u.data;
			count++;

		}
		
		else {
			
			// When it first starts off
			if(s.right==null & prev == null) {
				
				s.right = u;
				prev = s;
				s = s.right;
				count++;
			}
			
			if(prev==s.parent & prev.left == null) {
				
				prev.left = u;
				prev = s; 
				s = u; 
				
			}
			
			
			
			
			
		}
		
		
		
		
		
	}
	
	
	
	
	public void add(int data) {
		
		
		BinaryNode u = new BinaryNode();
		u.data=data;
		
		
		
		if(count == 0) {
			
			this.r  = u; 
			this.r.data = u.data;
			count++;
			
			

		}
		
		else {
			
			BinaryNode s = r;
			
			while(s!=null) {
				int rando = (int) Math.round( Math.random() )  ;
				
				if(rando == 1) {
					if(s.right!=null) {
						s=s.right;
						
						
					}
					else if(s.left!=null) {
						s = s.left;
					
					
					} else {
					s.right = u;
					u.parent =s;
					count++;
					break;
					}
				}
				
				else if(rando == 0) {
					if(s.left!=null) {
						s=s.left;
						
					}
					else if(s.right!=null) {
						s = s.right;
					
					}
					
					else {
					s.left = u;
					u.parent =s;
					count++;
					break;
					}
				}
				
				
				
			}
			
		}
		
	}
	
	
	// This finds the total size of the binary tree, starting at the root 
	
	int size2() {
		BinaryNode u = r ;
		BinaryNode prev = null;
		BinaryNode next;
		int n = 0;
		
		while (u != null) {
			
			//Its only going to be null when you first begin 
			if(prev==null) {
				n++;
				
				if (u.left != null) next = u.left;
				
				else if (u.right != null) next = u.right;
				
				else {
					return n;
				}				
				
			}
			
			else if (prev == u.parent) {
				n++;
				if (u.left != null) next = u.left;
				
				else if (u.right != null) next = u.right;
				
				else next = u.parent;
				
			} else if (prev == u.left) {
				
				if (u.right != null) next = u.right;
				else next = u.parent;
			} else {
				next = u.parent;
		}
			
		prev = u;
		u = next;
		}
		
		return n;
		}
	
	
	// This will return the subtree 
	int size2(BinaryNode u) {
		BinaryNode prev = null;
		BinaryNode next = null;
		int n = 0;
		BinaryNode original = u; 
		int count = 0;
		
		
		//You need to somehow organically stop this from double counting 
		while (u != null) {
			
			//Its only going to be null when you first begin 
			if(prev==null) {
				n++;
				
				if (u.left != null) next = u.left;
				
				else if (u.right != null) next = u.right;
				
				else {
					return n;
				}				
				
			}
			
			else if (prev == u.parent) {
				
				if(count!=1) {
				n++;
				}
				
				
				if (u.left != null) {
					
					next = u.left;
				}
				
				else if (u.right != null) {
					
					next = u.right;
				}
				
				else {next = u.parent;}
				
			} else if (prev == u.left) {
				
				if (u.right != null) {
					
					
					// Right here
					n++;
					next = u.right;
				}
				return n;
			} 

			else {
				return n; 
				}
			
		
		prev = u;
		u = next;
		if(u == original) {count++;}
		}
		
		if(u == original  & count == 2) {return n;}
		
		return n;
		}
	
	
	
	
	public int Trav(BinaryNode u) {
		
		
		Queue<BinaryNode> swag = new LinkedList<BinaryNode>();
		
		swag.add(u);
		
		int counter = 0; 
		boolean add;
		while(!swag.isEmpty()) {
		
			add = false; 
		
			BinaryNode y = swag.remove();
			if(y.left!=null){
				
				if(add==false) {
					add = true;
					counter++;}
				swag.add(y.left);
				
			}
			
			if(y.right!=null){
				
				if(add==false) {
					add = true;
					counter++;}
				swag.add(y.right);
				
				
			}
		
	}
		
		return counter;
		
	}
	
	
	public boolean isBalenced(BinaryNode r) {
		
		if(balnecedSize(r)>-1) {return true;}
		return false;
		
	}
	
	
	
	public int balnecedSize(BinaryNode n) {
		
		if(n == null) {return 0;}
		
		int h1 =size(n.left);
		
		int h2 = size(n.right);
		
		if(h1 == -1 || h2 == -1) {return -1;}
		
		if(Math.abs(h1-h2)>1) {return -1;}
		
		return h1+h2;
		
		
		
		
	}

		
		
		
		
	
	
	
	public static void main(String[] args) {
		
		BinaryTree cool = new BinaryTree();
		
		cool.nextPreOrder(cool.r);
		cool.nextPreOrder(cool.r);
		cool.nextPreOrder(cool.r);


		
		
		
	}
	
	

}
