
/*
	 * @Author: David George 
	 * @Student ID: 251004930 
	 * @Class: CS2110
	 */




public class Record {
	
	
	/*
	 * This class is used to create record objects
	 * @param Config is a string representation of the board
	 * @score is and integer value of the score
	 * 
	 */

	String config;
	int score;
	
	public Record(String config, int score) {
		
		this.config = config; 
		this.score = score; 
		
	
	}
	
	/*
	 * @return will return the string representation in the record object
	 */
	
	
	public String getConfig() {
		return config; 
	}
	
	/*
	 * @return will return integer value for score
	 * 
	 */ 
	
	
	public int getScore() {
		return score; 
	}

}
