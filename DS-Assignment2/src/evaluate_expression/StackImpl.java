package evaluate_expression;

public class StackImpl implements Stack
{
	
	  Node head, top;
	  
	  /**
	   * Push method will add the data at the top of the stack
	   * @param data
	   */
	  @Override
	  public void Push(int data) 
	  {
	     Node node =new Node(data);
	     
	     if(head == null) 
	     {
	        head = node;  
	        top = node;
	     }
	     else 
	     {
	        node.setNext(top);
	        
	        top = node;
	     }
	  }

	  /**
	   * Pop method deletes the Top node of the stack
	   * @return the deleted data from the stack
	   */
	  @Override
	  public int Pop() 
	  {
	     int data = top.data;
	     top = top.next;
	     
	     return data;
	  }

	  /**
	   * This method performs the peek operation of the stack
	   * @return the top data of the stack
	   */
	  @Override
	  public int Top() 
	  {
	     return top.data;
	  }
	
}