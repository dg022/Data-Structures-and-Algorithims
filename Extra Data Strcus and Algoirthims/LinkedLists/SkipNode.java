import java.lang.reflect.Array;
import java.util.*;
public class SkipNode {
	
	
	
	int x;
	

	
	SkipNode[] next;

	public int h;
	
	
	SkipNode(int data, int h){
		
		this.x = data;
		this.h = h;
		next =(SkipNode[]) Array.newInstance(SkipNode.class, h+1);
	}
	
	
	int height(){
		return next.length-1;
	}

}
