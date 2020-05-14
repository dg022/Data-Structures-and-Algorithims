//Author: David George
// Student ID: 251004930
public class BinarySearchTree implements BinarySearchTreeADT {
	private BinaryNode root;

	public BinarySearchTree() {
		root = new BinaryNode();
	}

	public BinaryNode getRoot() {
		return root;
	}

	public Pixel get(BinaryNode r, Location key) {
		if (r.isLeaf()) {
			return null;
		} else {
			BinaryNode current = r;
			
			// Iterativley look through tree, checking left right and going to the correect posisiotn
			// If exact match return data, otherwise if leaf ecountered before, return null. 

			while (current != null) {
				if (current.getData().getLocation().compareTo(key) > 0) {

					if (current.getLeft().isLeaf()) {

						return null;
					} else {

						current = current.getLeft();
					}
				} else if (current.getData().getLocation().compareTo(key) < 0) {

					if (current.getRight().isLeaf()) {

						return null;
					} else {
						current = current.getRight();
					}
				} else {

					return current.getData();
				}
			}
		}
		return null;
	}

	private BinaryNode get_Node(BinaryNode r, Location key) {
		if (r.isLeaf()) {
			return r;
		} else {

			BinaryNode current = r;
			
			// Iterativley look through tree, checking left right and going to the correect posisiotn
			// Return the node if already there, or a leaf if there is none and that would be its correct posisition
			while (current != null) {
				if (current.getData().getLocation().compareTo(key) > 0) {

					if (current.getLeft().isLeaf()) {

						return current.getLeft();
					} else {

						current = current.getLeft();
					}
				} else if (current.getData().getLocation().compareTo(key) < 0) {

					if (current.getRight().isLeaf()) {

						return current.getRight();
					} else {
						current = current.getRight();
					}
				} else {

					return current;
				}
			}
		}
		return null;
	}

	
	
	public void put(BinaryNode r, Pixel data) throws DuplicatedKeyException {
		// This will get the correct insertion posisiton of the node
		BinaryNode willAdd = get_Node(r, data.getLocation());

		// That means it found a node with the same value
		if (!willAdd.isLeaf()) {
			throw new DuplicatedKeyException();
		} else {
			
			//If it was a leaf, add it correctly given the posisiotn and set left, right, and parent
			willAdd.setData(data);
			BinaryNode leftChild = new BinaryNode();
			willAdd.setLeft(leftChild);
			BinaryNode rightChild = new BinaryNode();
			willAdd.setRight(rightChild);
			leftChild.setParent(willAdd);
			rightChild.setParent(willAdd);
		}
	}

	public void remove(BinaryNode r, Location key) throws InexistentKeyException {

		BinaryNode current = get_Node(r, key);
		if (current.isLeaf()) {
			throw new InexistentKeyException();
		} else {

			if (current == r) {

				// If root only has two leaves as childern, set root to a leaf 

				if (current.getRight().isLeaf() && current.getLeft().isLeaf()) {

					root.setLeft(null);
					root.setRight(null);
					root.setData(null);
					root.setParent(null);
				
					// If root only has one leavef as child, iterate properly and swap appporpirate data
					// If left it s a leaf, go the right, then all the way to the left and swap
				} else if (current.getLeft().isLeaf() && !current.getRight().isLeaf()) {

					BinaryNode oldsaved = current;

					current = current.getRight();

					while (!current.getLeft().isLeaf()) {

						current = current.getLeft();

					}

					oldsaved.setData(current.getData());
					current.setData(null);
					current.setLeft(null);
					current.setRight(null);
					
					
					// If root only has one leaf as child, iterate properly and swap appporpirate data
					// If Right is leaf and left isnt, go left and all the way to right and swap dat. 

				} else if (current.getRight().isLeaf() && !current.getLeft().isLeaf()) {

					BinaryNode oldsaved = current;

					current = current.getLeft();

					while (!current.getRight().isLeaf()) {

						current = current.getRight();

					}

					oldsaved.setData(current.getData());
					current.setData(null);
					current.setLeft(null);
					current.setRight(null);

				}else {
		
					BinaryNode oldsaved = current;

					current = current.getLeft();

					while (!current.getRight().isLeaf()) {

						current = current.getRight();

					}

					oldsaved.setData(current.getData());
					current.setData(null);
					current.setLeft(null);
					current.setRight(null);
				}

			} else {
				
				
				// The cases are repeated here, only diffence is root is not being changed.
				// Cases are: all children are leaves, left is leaf right is not, right is leaf left is not, both are not leaves

				if (current.getRight().isLeaf() && current.getLeft().isLeaf()) {

					current.setLeft(null);
					current.setRight(null);
					current.setData(null);
				}

				
				
				else if (!current.getRight().isLeaf() && !current.getLeft().isLeaf()) {

					BinaryNode oldsaved = current;

					current = current.getLeft();

					while (!current.getRight().isLeaf()) {

						current = current.getRight();

					}

					oldsaved.setData(current.getData());
					current.setData(null);
					current.setLeft(null);
					current.setRight(null);

				} 
				
				else if (current.getRight().isLeaf() && !current.getLeft().isLeaf()) {

					BinaryNode oldsaved = current;

					current = current.getLeft();

					while (!current.getRight().isLeaf()) {

						current = current.getRight();

					}

					oldsaved.setData(current.getData());
					current.setData(null);
					current.setLeft(null);
					current.setRight(null);

				} else if (!current.getRight().isLeaf() && current.getLeft().isLeaf()) {

					BinaryNode oldsaved = current;

					current = current.getRight();

					while (!current.getLeft().isLeaf()) {

						current = current.getLeft();

					}
					oldsaved.setData(current.getData());
					current.setData(null);
					current.setLeft(null);
					current.setRight(null);

				}

			}

		}

	}

	// this successor agorithim was taken straight from slides
	public Pixel successor(BinaryNode r, Location key) {
		
		BinaryNode parent_node; 
		BinaryNode current = null; 
		
		if (r.isLeaf()) {
			return null;
		} else {
			 current = get_Node(r, key);
			if (!current.isLeaf() && !current.getRight().isLeaf()) {
				try {
					return smallest(current.getRight());
				} catch (EmptyTreeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				parent_node = current.getParent();
				while (current != r && parent_node.getRight() == current) {
					current = parent_node;
					parent_node = parent_node.getParent();
				}
				if (current == r) {
					return null;
				} else
					return parent_node.getData();
			}
		}
		return null;
	}

	// this predecessor agorithim was taken straight from slides
	public Pixel predecessor(BinaryNode r, Location key) {
		
		BinaryNode parent_node; 
		BinaryNode current = null; 
		
		
		if (r.isLeaf()) {
			return null;
		} else {
			current = get_Node(r, key);
			if (!current.isLeaf() && !current.getLeft().isLeaf()) {
				try {
					return largest(current.getLeft());
				} catch (EmptyTreeException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} else {
				parent_node = current.getParent();
				while (current != r && parent_node.getLeft() == current) {
					current = parent_node;
					parent_node = parent_node.getParent();
				}
				if (current == r) {
					return null;
				} else
					return parent_node.getData();
			}
		}
		return null;
	}

	private BinaryNode smallestNode(BinaryNode r) throws EmptyTreeException {

		
		
		if (r.isLeaf()) {
			throw new EmptyTreeException();
		} else {
			
			// Iterativley go all the way to the left most node

			BinaryNode current = r;

			while (!current.getLeft().isLeaf()) {

				current = current.getLeft();
			}

			return current;

		}
	}

	public Pixel smallest(BinaryNode r) throws EmptyTreeException {

		return smallestNode(r).getData();
	}

	public Pixel largest(BinaryNode r) throws EmptyTreeException {
		return largestNode(r).getData();
	}

	private BinaryNode largestNode(BinaryNode r) throws EmptyTreeException {
		if (r.isLeaf()) {
			throw new EmptyTreeException();
		} else {

			// Iterativley go all the way to the right most node
			BinaryNode current = r;

			while (!current.getRight().isLeaf()) {

				current = current.getRight();
			}

			return current;

		}

	}
}
