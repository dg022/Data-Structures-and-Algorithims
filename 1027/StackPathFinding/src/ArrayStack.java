/**
 * This class implements ArrayStack. 
 * @Author David George 
 */



public class ArrayStack<T>implements ArrayStackADT<T>

{
  /**
   * constant to represent the default capacity of the array
   */
  private final int DEFAULT_CAPACITY = 20;

  /**
   * int that represents both the number of elements and the next
   * available position in the array
   */
  private int top = -1; 

  /**
   * array of generic elements to represent the stack
   */
  private T[] stack;
  
  /**
   * Creates an empty stack using the default capacity.
   */
  public ArrayStack()
  {
    stack = (T[])(new Object[DEFAULT_CAPACITY]);
  }

  /**
   * Creates an empty stack using the specified capacity.
   * @param initialCapacity represents the specified capacity 
   */
  
  public ArrayStack (int initialCapacity)
  {
   stack = (T[])(new Object[initialCapacity]);
  }

  /**
   * Adds the specified element to the top of this stack, expanding
   * the capacity of the stack array if necessary.
   * @param dataItem generic dataItem to be pushed onto stack
   */
  public void push (T dataItem)
  {
    if (size() == stack.length) 
      expandCapacity();

    stack[top+1] = dataItem;
    top++;
  }

  /**
   * Removes the element at the top of this stack and returns a
   * reference to it. Throws an EmptyCollectionException if the stack
   * is empty.
   * @return T dataItem removed from top of stack
   * @throws EmptyStackException if a pop is attempted on empty stack
   */
  public T pop() throws EmptyStackException
  {
    if (isEmpty()) {
      throw new EmptyStackException("Stack");
    }
   
    T result = stack[top];
    stack[top] = null; 
    top = top -1;
  
 
    if(stack.length > 20 && size() <(stack.length/3))
    {
    	reduceCapacity();
	}

    return result;
  
  }
   
  /**
   * Returns a reference to the element at the top of this stack.
   * The element is not removed from the stack.  Throws an
   * EmptyCollectionException if the stack is empty.  
   * @return returns T element on top of stack
   * @throws EmptyStackException if a peek is attempted on empty stack
   */
  public T peek() throws EmptyStackException
  {
    if (isEmpty()) {
      throw new EmptyStackException("Stack");
    }

    return stack[top];
  }

  /**
   * Returns true if this stack is empty and false otherwise. 
   * @return boolean true if this stack is empty, false otherwise
   */
  public boolean isEmpty()
  {
    
	  if (top == -1) {
		  return true;
	  }
	  
	  else {
		  return false; 
	  }
	  
  }
 
  /**
   * Returns the number of elements in this stack.
   * @return int the number of elements in this stack
   */
  public int size()
  {
    return top + 1;
  }
  
  public int length() {
	  return stack.length;
	}

  /**
   * Returns a string representation of this stack. 
   * @return String representation of this stack
   */
  public String toString()
  {
    String result = "Stack: " + stack[0];

    for (int index = 1; index < top+1; index++)
      result = result + ", " + stack[index];

    return result;
  }

  /**
   * Creates a new array to store the contents of this stack with
   * twice the capacity of the old one.
   */
  private void expandCapacity() {
		
		if(this.size() <  100) {
			T[] larger = (T[])(new Object[stack.length*2]);
			for (int index= 0; index < stack.length; index++) {
				larger[index] = stack[index];
			}
			stack = larger;
		}
		else {
			
			T[] larger = (T[])(new Object[stack.length+50]);
			for (int index= 0; index < stack.length; index++) {
				larger[index] = stack[index];
		}
			stack = larger;
		}
  }
  
  private void reduceCapacity() 
  {
	  	T[] smaller = (T[])(new Object[stack.length/2]);
		for (int index= 0; index < smaller.length; index++)
		{
			smaller[index] = stack[index];
		}
		stack = smaller; 
  }
  
}
