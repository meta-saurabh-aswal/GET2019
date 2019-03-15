package organic_chemistry;

import java.util.Stack;

public class OrganicMolecularMass
{
    private Stack<Element> stack = new Stack<Element>();
    
    /**
     * calculates the molecular mass of organic compounds 
     * @param compound
     * @return molecular mass
     */
    public int evaluate(String compound)
    {
        String input = compound.toUpperCase() + ")";    // append a right bracket to string
        
        int i =0, totalMass =0;
        this.stack.push(new Element('(',1));           // push a left bracket to stack
        
        while(i<input.length())
        {
            char symbol = input.charAt(i);
            
            //pushing the elements to stack
            switch(symbol)
            {
            case 'C':
            case 'H':
            case 'O':
                if(i==input.length()-1)
                {
                    this.stack.push(new Element(symbol,1));
                    i++;
                }
                else
                {
                    int base = this.digitMaker(input.substring(i));
                    this.stack.push(new Element(symbol,base));
                    i++;
                }
         
                break;
                
            case '(':
                this.stack.push(new Element('(',1));
                i++;
                break;
                
              // if right bracket is encountered, we will pop the stack until left bracket is found
              // and evaluate the bracket for the final result
            case ')':
                if(i==input.length()-1)
                {
                    totalMass += this.eval(1);
                }
                else
                {
                    int base = this.digitMaker(input.substring(i));
                    totalMass += this.eval(base);
                }
                i++;
                break;
                
                //if it's a digit
            default:
                i++;
            }
        }
        
        this.stack.clear();
        return totalMass;
    }
    
   
   // this method is used to find the number of atoms
   public int digitMaker(String subCompound)
   {
        int digit = 0;
        
        for(int i=1; i<subCompound.length(); i++)
        {
            char symbol = subCompound.charAt(i);
            
            if(Character.isDigit(symbol))
            {
                digit = digit*10 + (int)(symbol - '0');
            }
            else
            {
                break;
            }
        }
        
        if(digit == 0)
        {
            return 1;
        }
        return digit;
    }
   
   // this method is used to actually evaluate the compound
   // based on molar mass and number of atoms
    private int eval(int base)
    {
        int subMass = 0;
        Element e;
        
        while(true)
        {
           e = this.stack.pop();
           
           // pop until left bracket is found
           if(e.getSymbol() == '(')
           {
               break;
           }
           else
           {
               switch(e.getSymbol())
               {
                   case 'C':
                             subMass+= (12*e.getBase());
                             break;
                   case 'O':
                             subMass+= (16*e.getBase());
                             break;
                   case 'H':
                             subMass+= (1*e.getBase());
                             break;
               }
          } 
       }
        return (subMass*base);
    }
}