import java.util.LinkedList;

public class ArrayStackV2 {
	
	// An array stack workk, by shifting all the elemtns when adding, or removing — setting and getting
	// very easy 
	
	LinkedList<Integer> cool = new LinkedList<Integer>();
	
	int A[];
	int n;
	
	
	public ArrayStackV2() {
		
		A = new int[10];
		n = 10; 
	}
	
	
	public int Get(int index) {
		
		return A[index];
	}
	
	
	public void Set(int index, int item) {
		
		
		
		A[index] = item;
		
	}
	
	
	public void Add(int index, int item) {
		
		if(this.n + 1 > A.length) {
			resize();
		}
		
		for(int j = this.n; j > index; j--) {
			
			A[j] = A[j-1];
			
		}
		
		A[index] = item; 
		n++; 
	}
	
	
	public int remove(int index) {
		
		if(this.n == 0) {
			
			System.out.print("This cannot work, you will get an error");
			
		}
		
		
		
		int temp = A[index];
		
		for(int i=index;i < n-1; i++) {
			
			A[i] = A[i+1];
			
		}
	
		n--;
		return temp; 
	}
	
	
	
	
	public void resize() {
		
		
		int [] Temp = new int[n*2];
		
		for(int i = 0; i<n; i++) {
			Temp[i]= A[i];
		}
		A = Temp; 		
	}
	
	public String toString() {
		
		String output =""; 
		
		
		for(int i =0; i < this.n; i++) {
			
			
			output= output + "," + A[i];
			
		}
		
		
		
		
		
		
		
		return output; 
		
		
	}
	
	
	
	

	
	public static void main(String[] args) {
		
		ArrayStackV2 Test = new ArrayStackV2();
		
		for(int i = 0;  i< 10; i++) {
			Test.Add(i, i);

		}
		
		
		for(int i = 0;  i< 10; i++) {
			Test.remove(i);

		}
		
		System.out.print(Test.toString());
		
		
	}
	
	
}




