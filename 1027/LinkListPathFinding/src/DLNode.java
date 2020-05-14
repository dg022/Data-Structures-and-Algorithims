
public class DLNode <T> {

	private T dataItem; 
	private DLNode <T> next; 
	private DLNode <T> previous; 
	private int value; 

	
	public DLNode (T data, int value) {
		 next = null;
	     previous = null;
	     this.dataItem = data; 
	     this.value = value; 
	}
	
	public int getValue() {
		return value; 
	}
	
	public T getData() {
		
		return dataItem; 
	}
	
	public DLNode<T> getNext() {
		
		return next; 
	}
	
	public DLNode<T> getPrevious(){
		
		return previous; 
	}
	
	public void setData(T node) {
		
		dataItem = node;
	}
	
	public void setNext(DLNode <T> node) {
		next = node;
		
	}
	
	
	public void  setPrevious(DLNode <T> node) {
		
		previous = node;
	}
	
	public void  setPrev() {
		
		previous = null;
	}	
	
	public void  setValue(int value) {
		
		this.value = value; 
		
	}

	
	
	
}
