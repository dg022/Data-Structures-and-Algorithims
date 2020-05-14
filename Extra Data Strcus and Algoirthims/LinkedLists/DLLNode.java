
public class DLLNode {
	
	
	DLLNode next; 
	DLLNode prev;
	int data;
	int min; 
	
	
	public DLLNode() {
		this.next = null;
		this.prev = null; 
		this.data = 0;
	}
	
	
	public void SetNext(DLLNode node) {
		
		this.next = node; 
		
	}
	
	public void SetPrev(DLLNode node) {
		
		this.prev = node;
		
	}
	
	public DLLNode  GetPrev() {
		
		return this.prev;
		
		
	}
	
	
	

	public int GetData() {
		
		return this.data;
		
		
	}
	
	
	public DLLNode GetNext() {
		
		return this.next;
	}
	
	public void SetData(int data) {
		
		this.data  = data;
		if(data < this.min) {
			this.min = data; 
		}
	}
	
	
	

}
