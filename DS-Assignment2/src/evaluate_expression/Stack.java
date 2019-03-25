package evaluate_expression;

//Stack interface defined with the following Operations
public interface Stack 
{
	//To add the data into the stack
	public void Push(int data);
	
	//to remove the top node of the stack
  public int Pop();
  
  //It will return the top data of the stack
  public int Top();

}
