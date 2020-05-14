import java.util.*;


public class RedBlackTree {
	
	bn r; 
	int count; 
	
	
	
	
	public RedBlackTree() 
	{
		
		r = null;
		count = 0;
		
	}
	
	
	
	
	public boolean add(int data) {
		
		bn u = new bn();
		u.data = data;
		boolean added = false;
		
		if(count == 0) {
			
			
			r = u;
			r.color = "b";
			count ++;	
			return true;
		} 

			bn current = r;
			
			while(!added) {
				
				if(current.data < data) {
					
					if(current.right == null) {
						
						current.right =  u; 
						u.parent = current;
						count++;
						break;
						
					} else {current  = current.right;} 
					
				}
				
				
				else if( current.data > data) {
					
					
					if(current.left == null) {
						current.left =  u; 
						u.parent = current;
						count++;
						break;
						
					} else {current = current.left;}
					// if you get to this point and it hits the else statement, then you 
					// The element is already in the binary tree
				} else {
					return false;		
				}
			}
			
			
			if(u.parent.color.equals("b")) {
				
				return true;

			}
			
			
			// If you are at the second level the rewill never be the case where your parent will be red
			while(u.parent.color.equals("r")) {  
			
				
			
				
				if(sibling(u).equals("r")){
					
					recolor(u);
					if(u.parent.parent!=null) {
						u = u.parent.parent;
						
						if(u.parent == null) {
							break;
						}
					}
					
				}
				
				
				
				else if(sibling(u).equals("b") || sibling(u).contentEquals(("null"))) {
					
					
					
					
					// If your parents parents left child is your parent, and ou are a left child of you parent, then you do a right rotatio 
					
					 
					if(u.parent.parent.left == u.parent & u.parent.left == u) {
						
						
						bn temp =  new bn();
						temp = u.parent.parent;
						bn temper = new bn();
						temper = u.parent;
						u.parent.color = temp.color;
						u.parent.parent.color = temper.color;
						
						// sSwitch on my mama bro, tons of possbility for null pointers here
						RightRotate(u.parent);
						break;
	 
					}
					
					else if(u.parent.parent.left == u.parent & u.parent.right == u) {
						
						
						bn temp =  new bn();
						temp = u.parent.parent;
						bn temper = new bn();
						temper = u;
						u.color = temp.color;
						u.parent.parent.color = temper.color;
						
						
						
						LeftRotate(u.parent);
						RightRotate(u.parent.parent);
						break;
						
					} else if(u.parent.parent.right == u.parent & u.parent.right ==u) {
						
						bn temp =  new bn();
						temp = u.parent.parent;
						bn temper = new bn();
						temper = u.parent;
						u.parent.color = temp.color;
						u.parent.parent.color = temper.color;
						
						// sSwitch on my mama bro, tons of possbility for null pointers here
						LeftRotate(u.parent);
						break;
						
					}
					
					
					
					else if(u.parent.parent.right == u.parent & u.parent.left == u) {
						
						bn temp =  new bn();
						temp = u.parent.parent;
						bn temper = new bn();
						temper = u;
						u.color = temp.color;
						u.parent.parent.color = temper.color;
						
						
						
						RightRotate(u.parent);
						LeftRotate(u.parent.parent);
						break;
						
					}
				}
				
 
				
				

				
			
			}
			
			
			
			return true;
			
			
			
		}
	
	
		public void recolor(bn u) { 
			
			u.parent.color = "b";
			
			if(u.parent.parent.left == u.parent) {
				u.parent.parent.right.color = "b";
			}
			
			 if(u.parent.parent.right == u.parent) {
				u.parent.parent.left.color = "b";
			}
			
			if(u.parent.parent != this.r) {
				u.parent.parent.color = "r";
				
			}
			
			
			
		}
		
		
		public void RightRotate(bn a) {
			
			bn p = null;
			bn b = null; 
		
		if(a.parent !=null) {
			p = a.parent;
		}
		
		if(a.left != null) {
			
			b = a.left;
			a.left = b.right;
			if(a.left!=null) {
			a.left.parent = a;
			}
			b.right = a;
			b.parent = a.parent;
			a.parent = b; 
			
		}
		if(p!=null) {
			
			if(p.left == a) {
				p.left = b;
				
			}else {
				
				p.right = b; 
			}
			
		}	
		}
		
		
		
		
		public void LeftRotate(bn a) {
			bn p = null;
			bn b = null;
			if(a.parent!= null) {	
			 p = a.parent;
			}
			if(a.right!=null) {
				
				b =  a.right;
				a.right = b.left;
				
				if(a.right!=null) {
					a.right.parent = a;
					}
		
				b.left = a;
				b.parent = a.parent;
				a.parent = b; 
				
			}
			if(p!=null) {
				if(p.left == a) {
					
					p.left = b;

				} else {
					p.right = b;
		
				}
			}
		}
		
		
		
		public String sibling(bn u) {
			
			String r = "r";
			String b = "b";
			String nill = "null";
			String root = "root";
			String override = "over";
			
			if(u.parent == null) {
				return root;
				
			}
			
			
			if(u.parent.parent == null) {
				
				// at this point in the tree of the tree, you mUST be red. 
				
				return override;
				// this is happening at a at the second level of it. 
			}
			// First check if its a left or right child 
			
			if(u.parent.parent.left == u.parent) {
				
				// This means you will be checking the right sibling
				
				
				if(u.parent.parent.right.color.equals("r")) {
					
					return r;
				}
				
				
				else if(u.parent.parent.right.color.equals("b")) {
					
					return b;
				}
				
				
				else return nill;
				
				
				
			}
			
			
			else  {
				
				if(u.parent.parent.left!=null) {
				
				if(u.parent.parent.left.color.equals("r")) {
					
					return r;
				}
				
				
				 if(u.parent.parent.left.color.equals("b")) {
					
					return b;
				}
				
				
				else return nill;
				
				
				
				}
				
			}
			return nill;
		}
		
		
		
		
		public bn find(int data) {
			
			bn  current = new bn();
			
			current.data = data; 
			
			
			if(count == 0) {
				
				// There is nothing here that you remove
				return null;
				
				
				
			}
			
			else {
				
				
				
				current =  r; 
				
				boolean added = false;
				
				while(!added) {
					
					
					if(current.data <  data) {
						
						
						if(current.right == null) {
							// Its not in the bst
							return null;
						}
						
						else {
							
							current = current.right;
							
						}
						
						
						
						
						
					} else if(current.data > data) {
						
						if(current.left  == null) {
							return null;
						}
						
						else {current = current.left;
						}
						
						
						
					} else {
						
						
						return current;
	
					}
						
				}
						
				
				
			}
			return null;
				
			
		}
		
		
		
		public  boolean remove(int data) {
			
			bn u = find(data);
			bn holder = u; 
			
			
			
			// You cannot remove whats not in  the binary search tree
			if(u == null) {return false;} 
			
			
			
			
			
			else {
				
				// If the node you are trying to delete has two not null nodes, find the in-order successor of 30 
				// The inorder succsor will be in the smallest node in the right tree
				
				if(u.right != null & u.left!=null) {
					
					u = u.right;
					
					while(u.left!=null) {
						
						u = u.left;
					}
					
					
					holder.data = u.data; 
					
					holder = holder.right; 
					
					while(holder.left!=u) {
						
						holder = holder.left;
					}
					
					if(u.color.contentEquals("r")) {
					holder.left = null;
					}
					
					
				}
				
			} 
			return false;
			
		}

		public void BreadthTraverseal()
		{
			
			Queue<bn> list = new LinkedList<bn>();
			
			
			bn current = r; 
			list.add(current);
			
			
			while(!list.isEmpty()) {
				
				
				current = list.remove();
				
				
				
				System.out.println(current.data);
				
				if(current.left!=null) {
					
					
					list.add(current.left);
				}
				
				
				if(current.right!=null) {
					
					
					list.add(current.right);
				}
				
			}
			
		}	
		
		public static void main(String[] args) {
			
			
			
			RedBlackTree cool = new RedBlackTree();
			
			cool.add(10);
			cool.add(5);
			cool.add(30);
			cool.add(-5);
			cool.add(7);
			cool.add(20);
			
			cool.add(38);
			cool.add(35);
			cool.remove(30);
			
			
			
			cool.BreadthTraverseal();
			
			
			
			
		}
		
	
	
	
	}


