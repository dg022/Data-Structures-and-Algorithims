import java.util.*;


public class MinStack {
	
	DL list;
	DL Mini;
	int n; 
	
	public MinStack() {
		
	list = new DL();
	Mini = new DL() ;
	 n =  0;
	}
	
	
	public void push(int x) {
		
		if(n == 0) {
			list.add(x);
			Mini.add(x);
			n++;
		}
		
		
		else {
			
			list.add(x);
			n++;
			if(list.get(list.count-1) <= Mini.get(Mini.count-1)) {
				Mini.add(x);
				
			}
			
			
			
			
		} 
		

		
	}
	
	public int size() {
		
		
		return list.count;
	}
	
	
	public int pop() {
		
		if(list.count!=0) {
		
		if(list.get(list.count-1) ==  Mini.get(Mini.count-1)) {
			
			list.remove();
			return Mini.remove();
			
		}
		
		else {
			return list.remove();
		}
		
		}
		
		
		
		return 0000;
	}
	
	
	public int min () {
		return Mini.get(Mini.count-1);
	}
	
	
	
	
	
	
	public static void main(String[] args) {
		
		MinStack cool = new MinStack(); 
		
		
		
		for(int i = 0; i < 10; i++) {
	
			cool.push(i);
		}
		
		
		
		System.out.println(cool.min());
		
		
	} 

	
	
	
	
	
	

}






