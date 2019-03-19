package infix_to_postfix;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class InfixToPostfixTest
{

    @Test
    public void stackInfixToPostfixPositiveTest()
    {
    	InfixToPostfix obj = new InfixToPostfix();
    	
        assertEquals("abcd^e-fgh*+^*+i-", obj.infixToPostfix("a + b * ( c ^ d - e ) ^ ( f + g * h ) - i"));
    }
    
    @Test
    public void stackInfixToPostfixPositive()
    {
    	InfixToPostfix obj = new InfixToPostfix();
    	
        assertEquals("abcd^e-fgh*+^*i->=",obj.infixToPostfix("a >= b * ( c ^ d - e ) ^ ( f + g * h ) - i"));
    }
    
    @Test
    public void stackNegativeTest()
    {
    	InfixToPostfix obj = new InfixToPostfix();
    	
    	Assertions.assertThrows(AssertionError.class, () -> obj.infixToPostfix("a + b * c ^ d - e ) ^ ( f + g * h ) - i"));
    } 
    
}

