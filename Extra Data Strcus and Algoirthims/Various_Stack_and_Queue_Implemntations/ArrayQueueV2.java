
public class ArrayQueueV2 {
	
	// An array que is simialr to an array stack, but that you add to one end and take off from another,
	// this removes the need for shfting elements, because when an element is added, it just wraps around
	// 
	
	int[] A; 
	int n; 
	int j; 
	
	
	public ArrayQueueV2() {
		A = new int[10];
		n =0; 
		j = 0; 
	}
	
	
	// Yeah you can only add an item to an end, its a queue right, this way you are not shifting shit
	//constnatly 
	public void Add( int item) {
		
		//When ever you do any kind of add operation you have to make sure you check if there is enough 
		// space 
		
		if(this.n + 1 > A.length) {resize();}
		
		A[(n + j)%A.length] = item; 
		
		n++;
		
	}
	
	
	
	
	// REEMEBR you can only remove from somehting that has somehting inside of it,
	// make sure you check if it is emoty first before doing shit like this. 
	
	
	public int remove(int index) {
		
		if(this.n == 0) {System.out.print("This will not work u goon"); }
		
		int temp = A[(index+j)%A.length];
		
		j = (j+1)%A.length ; 
		
		
		n--; 
		
		//When ever you remove something make sure you decrment the counter, thats super important 
		
		return temp; 
	}
	
	
	public void  resize() {
		
		int [] B = new int[n*2];
		
		for(int i = 0 ; i < this.n; i++) {
			
			
			// Does this make sense, for every index in the array B
			// you iterate through every rear posisition 
			
			B[i] = A[(i+j)%A.length];
					
		}
	
		A = B; 
		j = 0; 
		
		
		
		
	} 
	
	
	
	

}
