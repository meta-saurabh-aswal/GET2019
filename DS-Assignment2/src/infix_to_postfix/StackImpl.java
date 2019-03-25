package infix_to_postfix;

public class StackImpl implements Stack
{
	private int top;
    String stack[] = new String[MAX];
   
    /**
     * create stack with top=-1
     */
    StackImpl()
    
    {
        top = -1;
    }
    
    /**
     * pop element from stack 
     */
    @Override
    public String pop() 
    {
        if(isEmpty())
        {
        	throw new AssertionError("Stack Underflow Occured");
        }
        
        String popElement = stack[top];
        top--;
        
        return popElement;
    }

    /**
     * push element into stack
     */
    @Override
    public void push(String newElement) 
    {
        if(isFull())
        {
        	throw new AssertionError("Stack Overflow Occured");
        }
        top++;
        stack[top] = newElement;
    }

    /**
     * return last element of stack
     */
    @Override
    public String peek() 
    {
        if(isEmpty())
        {
        	throw new AssertionError("Stack Underflow Occured");
        }
        String popElement = stack[top];
        
        return popElement;
    }

    /**
     * check if stack is empty or not
     */
    @Override
    public boolean isEmpty()
    {
        if(top == -1)
        {
        	return true;
        }
        
        return false;
    }

    /**
     * check if stack is full or not
     */
    @Override
    public boolean isFull() 
    {
        if(top == MAX)
        {
        	return true;
        }
        
        return false;
    }
	
}