package infix_to_postfix;

public class InfixToPostfix
{
    
	/**
	 * this method convert infix expression into postfix expression
	 * 
	 * @param expression
	 * @return postfix expression
	 */
	public String infixToPostfix(String expression) 
	{
		String result = new String("");
		Stack stack = new StackImpl();
		
		String expressionElements[] = expression.split(" ");
		
		for (int i = 0; i < expressionElements.length; i++)
		{
			String element = expressionElements[i];
			
			// If the scanned character is an operand, add it to output
			if (isElementNumeric(element) || isElementLetter(element))
			{
				result = result + element;	
			}		
			// If the scanned character is an '(', push it to the stack.
			else if (element.equals("("))
			{
				stack.push(element);
			}
			
			// If the scanned character is an ')', pop and output from the stack
			// until an '(' is encountered.
			else if (element.equals(")")) 
			{
				while (!stack.isEmpty() && !(stack.peek().equals("(")))
				{
					result += stack.pop();
				}
				
				// will throw an exception when infix expression will be invalid
				if (!stack.isEmpty() && !(stack.peek().equals("(")))
				{
					throw new RuntimeException("Invalid Expression"); 
				}		
				else
					stack.pop();
			}
			
			// an operator is encountered
			else 
			{
				// if current operator is has less precedence then pop from stack
				while (!stack.isEmpty() && Prec(element) <= Prec(stack.peek()))
				{
					result += stack.pop();
				}
				stack.push(element);
			}
		}
		
		// pop all the operators from the stack
		while (!stack.isEmpty())
		{
			result += stack.pop();
		}
		
		return result;
	}

	/**
	 * @return true if it contain only one latter
	 */
	private boolean isElementLetter(String element) 
	{
		if (Character.isLetter(element.charAt(0))) 
		{
			return true;
		}
		return false;
	}

	/**
	 * @return true if it contain only numeric value
	 */
	private boolean isElementNumeric(String element) 
	{
		try
		{
			Integer d = Integer.parseInt(element);
		}
		catch (NumberFormatException | NullPointerException nfe)
		{
			return false;
		}
		
		return true;
	}

    /**
     *  Higher returned value means higher precedence
     *  
     * @param element
     * @return precedence value
     */
	static int Prec(String element)
	{
		switch (element) 
		{
		case "=":
			return 1;
			
		case "||":
			return 2;
			
		case "&&":
			return 3;
			
		case "|":
			return 4;
			
		case "&":
			return 5;
			
		case "==":
		case "!=":
			return 6;
			
		case "<":
		case ">":
		case "<=":
		case ">=":
			return 7;
			
		case "+":
		case "-":
			return 8;
			
		case "*":
		case "/":
			return 9;
			
		case "^":
			return 10;
		}
		
		return -1;
	}
}
