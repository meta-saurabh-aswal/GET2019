package evaluate_expression;

public class EvaluateExpression 
{
	
	Stack stack = new StackImpl();
	
	/**
	 * This method evaluates the postfix expression
	 * @param exp
	 * @return the final result of the postfix expression
	 * @throws Exception if expression is not valid
	 */
    public int evaluate(String exp) throws Exception 
    {	
    	//loop to iterate over the expression given as input
        for(int index=0;index<exp.length();index++) 
        {
            char character = exp.charAt(index);
            if(character == ' ')
            {
            	continue;
            }
            else if(Character.isDigit(character))
            {
            	int tempNum=0;
            	while(Character.isDigit(character))
            	{
            		tempNum =tempNum*10+(Character.getNumericValue(character));
            		index+=1;
            		character = exp.charAt(index);
            	}
            	index-=1;
            	stack.Push(tempNum);
            	
            }
            else 
            {
                int value1 = stack.Pop();
                int value2 = stack.Pop();

                switch(character) 
                {

                case '+': 
                    stack.Push(value2+value1); 
                    break; 

                case '-': 
                    stack.Push(value2-value1); 
                    break; 

                case '/': 
                    stack.Push(value2/value1); 
                    break; 

                case '*': 
                    stack.Push(value2*value1); 
                    break; 

                default:
                    throw new Exception("Wrong Expression");
               }
            }
        }
        //returns the top value by deleting the value(free space)
        return stack.Pop(); 
    }
    
}