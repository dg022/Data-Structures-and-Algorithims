
public class ArrayDeque {
	
	int [] A;
	int n;
	int j; 
	
	
	public ArrayDeque(){
		
		A = new int[10];
		n  = 0;
		j = 0;
		
	}
	
	public ArrayDeque(int capacity) {
		
		A = new int[capacity];
		n  = 0;
		j = 0;
		
		// TODO Auto-generated constructor stub
	}

	public int Get(int index) {
		
		return A[(index + j)%A.length];
		
	}
	
	
	public void add(int index, int item) {
		
		if(n+1 > A.length) {resize();}
		
		if(index > this.n/2) {
			
			for(int k = this.n; k > index ; k-- ) {
				
				// represents a shift of one rightwards
				//every point moves one forward
				A[(j+k)%A.length] = A[(j+k-1)%A.length]; 
				
			}
			
			
			
		}else{
			
			// This is for when you are adding elments that are
			// less than half way. 
			j = (j==0)? A.length -1: j-1; 
			
			for(int k = 0; k < index; k++) {
				A[(k+j)%A.length] = A[(k+j+1)%A.length];
			}
		}
		
		n++;
		A[(index + j)%A.length] = item; 
	}
	
	public int remove(int index) {
		
		int temp = A[(index + j)%A.length];
		
		if(index > this.n/2) {
			
			for(int k = index; k < n-1 ; k++) { 
				A[(j+k)%A.length] = A[(j+k+1)%A.length];
			}
		
			j = (j+1)%A.length;
			
		}
		
		
		
		
		else {
			
			for(int k = index; k > 0; k --) {
				
				A[(k+j)%A.length] = A[(j+k-1)%A.length];
				
			}
			
			
		}
		
		n--;
		
		return temp;
	}
	
	
	public void resize() {
		
		int [] B =  new int[n*2];
		
		for(int i = 0; i< this.n; i++) {
			
			B[(i+j)%B.length] = A[(i+j)%A.length];
			
		}
		
		j = 0;
		A = B; 
		
	}
	
	
	
	public static void main(String[] args) {
		
		ArrayDeque col = new ArrayDeque(); 
		
		for(int i=0; i< 11; i++) {
			col.add(i, i);
		}
		
	}
	
			
	
	
	

}
