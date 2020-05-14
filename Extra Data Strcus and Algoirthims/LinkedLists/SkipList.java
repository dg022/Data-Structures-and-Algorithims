public class SkipList{
	
	SkipNode stack[] = new SkipNode[10];
	SkipNode findPredNode(int data) {
		
		SkipNode u = new SkipNode(0,10);
		
		int r = 10; 
		
		while(r >=0) {
			
			
			while(u.next[r]!=null & u.next[r].x < data) {
				
				u = u.next[r];
			}
			
			r--;
		}
		
		return u;
	
		
	}
	
	
	int find(int data) {
		
		SkipNode u = findPredNode(data);
		
		if (u.next[0]==null)
			return 0;
		else
			return u.next[0].x;
		
	}
	
	int pickHeight() {
		
		int k = 0;
		int z = (int) Math.round( Math.random());
		while(z!=1) {
		
			z = (int)Math.round( Math.random());
			
			k++;
		}
		
		return k;
	}
	
	
	boolean add(int x) {
		
		SkipNode u = new SkipNode(0,10);
		int r = u.h;
		while(r>=0) {
			
			while(u.next[r]!=null & u.next[r].x < x) {
				u = u.next[r];
			}
			if(u.next[r]!=null & u.next[r].x == x) {
				return false;
				
			}
			
			r--;
			
			
		}
		
		
		SkipNode w = new SkipNode(x, pickHeight());
		while(u.h < w.height()) {
			stack[++u.h] = u; // height increased
			
		}
		
		for(int i = 0; i < w.next.length;i++) {
			w.next[i] = stack[i].next[i];
			stack[i].next[i] = w;

	}
	
	return true;
	
	
}
	
	
	public static void main(String[] args) {
		
		 SkipList list  = new SkipList();
		 
		 for(int i= 0; i < 10; i++) {
			 list.add(i);
		 }
	}
	
}


