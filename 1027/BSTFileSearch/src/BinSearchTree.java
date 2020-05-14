/**
 * BinSearchTree defines methods to find the occurences of certain words, along with adding nodes when the word doesnt exist. 
 * Recruisvley iterates through the BST.  
 * @version 1.0, 09/04/19
 * @author davidgeorge
 */

public class BinSearchTree {

	
	
	private BinSearchTreeNode root;
	
	
	/**
	 * @param searchWord is the word that is being looked for in the BST 
	 * @return will return the node with node contians searchWord
	 */

	public BinSearchTreeNode getWord(String searchWord)
	{
		return(getFocus(root, searchWord));
	}

	private BinSearchTreeNode getFocus(BinSearchTreeNode r, String searchWord)

	{

		if (r == null) {
			return null;
		}

		else if (r.getWord().equals(searchWord)) {
			return r;
		}
		
		/**
		 * recurse to the left if the word is lexograpically smaller 
		 */

		else if (searchWord.compareTo(r.getWord()) < 0) {

			return getFocus(r.getLeft(), searchWord);
		}

		/**
		 * recurse to the right if the word is lexograpically larger
		 */

		
		else {

			return getFocus(r.getRight(), searchWord);
		}

	}
	
	/**
	 * Depending on whether whether the word is in the tree alrady or not, has differnt cases 
	 *
	 * @param  theWord is the word to insert 
	 * @param theFileName name of file 
	 * @param thePosistion is the where teh word shows up in the file 
	 * 
	 */
	

	public void insertWord(String theWord, String theFileName, int thePosition)

	{
		BinSearchTreeNode r = root;
		if (root == null) {
			BinSearchTreeNode addd = new BinSearchTreeNode(theWord, theFileName, thePosition);
			root = addd;
		}
		if (r != null) {

			if (r.getWord().equals(theWord)) {
				LinkedList lp = r.getFiles();
				lp.insertWord(theFileName, thePosition);
				
			// If the node is null, then will call insertWordMethod which follows the algo given in the assignment. And add nodes to the binary tree. 
			}
			else {
				insertWordMethod(root, theWord, theFileName, thePosition);
			}
		}
	}
	
	
	
	/**
	 * Depending on whether whether the word is larger smaller, or if the tree exists at all, has differnt cases for each. 
	 * @param r will refernce the root
	 * @param  theWord is the word to insert 
	 * @param theFileName name of file 
	 * @param thePosistion is the where teh word shows up in the file 
	 * 
	 */

	private void insertWordMethod(BinSearchTreeNode r, String theWord, String theFileName, int thePosition)

	{
		if (root == null) {
			BinSearchTreeNode addd = new BinSearchTreeNode(theWord, theFileName, thePosition);
			root = addd;
			r = addd;	
		}
		if (r != null) {

			if (r.getWord().equals(theWord)) {

				LinkedList lp = r.getFiles();

				lp.insertWord(theFileName, thePosition);
			} else {
				
				if (theWord.compareTo(r.getWord()) < 0)
				{
					if (r.getLeft() == null) {
						BinSearchTreeNode adddd = new BinSearchTreeNode(theWord, theFileName, thePosition);
						r.setLeft(adddd);
					}
					else {
						insertWordMethod(r.getLeft(), theWord, theFileName, thePosition);			
					}
				}	
				else if(r.getRight() == null) {
					BinSearchTreeNode addddd = new BinSearchTreeNode(theWord, theFileName, thePosition);
					r.setRight(addddd);
				}
				else {insertWordMethod(r.getRight(), theWord, theFileName, thePosition);}		
			}
		}
}
	
}
