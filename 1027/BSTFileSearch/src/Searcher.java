/**
 * Searcher will look through text files, and find the occcurences of certain words in a given text file. 
 * @author David George 
 * @version 1.0, 09/04/19
 */



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException; 
import java.util.*;



public class Searcher {
	
	private HashTable table;
	private String inputFile;
	 
	
	/**
	 * This is the constructor for this classs
	 */

	
	
	 public Searcher(HashTable wordHashTable, String theInputTestFile) {
		 
		 this.table = wordHashTable; 
		 this.inputFile = theInputTestFile; 
		
	}

	 
	 /**
	  * FindAllWords will take the input file with the given words to search for 
	  * Will iterate over the textfile and call findWord to find each given word. 
	  */
	 

	public void findAllWords() {
		 
		 try {
			 
			 BufferedReader in = new BufferedReader(new FileReader(inputFile));
			 String line = in.readLine();
			 String[] text = line.split(" ");
			 for (int i = 0; i < text.length; i++) {
					findWord(text[i]);
			 }
		 } catch (IOException e) {
				System.out.println(e.getMessage());
			}

	 }
	
	 /**
	  * @param searchWord is the given word to look for 
	  * Goes to the binary search tree stored in a the hash table at a given index
	  * getWord(searchWord) will return null if the node with the word cannot be found in the binary tree
	  * getWord(searchWord) else will iterate the through the linked list of files and print out the occurences
	  * and the posisitions. 
	  * 
	  */
	 
	

	 public void findWord(String searchWord) {
		 
		
		 /**
		  *  index contains the integer index posisistion where the binary search tree exists where the word
		  * would most likely be stored. 
		  */
		 
		 int index  =  table.computeIndex(searchWord); 
		 
		 BinSearchTree[] HashTableTree = table.getTable();
		 
		 BinSearchTree BTree = HashTableTree[index];
		 
		 BinSearchTreeNode text = BTree.getWord(searchWord);
		 
		 if(text == null) {
			 CustomPrinter.wordNotFound(searchWord, inputFile);
		
		 }else {
			 
			 CustomPrinter.wordFound(searchWord, inputFile); 
			 
			 LinkedList Lp = text.getFiles();
			 
			 FileNode current = Lp.getHead();
		
			 /**
			  * Iterate through all of the files n the linked list, printing out the results while the next node isn't null. 
			  */
			 
			 while(current.getNext() !=null) {
				 CustomPrinter.printPositionsPerFileFound(current.getFilename(), current.getPositions(), inputFile);
				 current = current.getNext();
			 }
			 if (current!=null) {CustomPrinter.printPositionsPerFileFound(current.getFilename(), current.getPositions(), inputFile);}
		 }
		 
	 }
}