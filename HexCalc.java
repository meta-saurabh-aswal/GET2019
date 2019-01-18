import java.util.*;

/*
This is a hexadecimal calculator.
HexCalc class is for taking hexadecimal numbers and doing operations on them.
Operations include addition, subtraction, multiplication, division and comparison.
Assumption is that all the input hexadecimal numbers are positive.
*/

public class HexCalc
{
	static Scanner sc = new Scanner(System.in);
	
	static double decimalNum;
	static double total=-1;				//initializing result with a negative number.
	String oldNum;						//for holding the previous value of hexadecimal string for comparison with the new string.
	
	public static void main(String args[])
	{
		char choice;
		
		HexCalc hex = new HexCalc();
		String hexaNum2 = hex.inputHexa();				//taking initial input.
		
		decimalNum=hex.toDecimal(hexaNum2);				//converting the hexadecimal string to decimal number using method given below.
		System.out.println(decimalNum);
		
		do
		{
			if(total==-1)
			{
				total=decimalNum;						//putting the initial valid value to total.
			}
			
			hex.oldNum = hexaNum2;
			
			System.out.println("Press 0 to exit\nPress 1 for comparison\nPress + for addition\nPress - for subtraction\nPress * for multiplication\nPress / for division");
			choice=sc.next().charAt(0);
			
			hex.options(choice);
			
			System.out.println("Result: "+total + "\t" + hex.toHexa(total));
			
		}while(choice!='0');					// 0 to exit the loop
	}
	
	
	double toDecimal(String hexaNum2)
	{
		
		double tempDecimal=Integer.parseInt(hexaNum2, 16);				//hexadecimal to decimal conversion.
		return tempDecimal;
	}
	
	String toHexa(double num)
	{
		int trim=(int)num;
		return (Integer.toHexString(trim));					//making the double to integer to avoid floating point value operations.
	}
	
	
	
		void add(String next2)
		{
			decimalNum=toDecimal(next2);
			total+=decimalNum;
		}
		
		void subtract(String next2)
		{
			decimalNum=toDecimal(next2);
			total-=decimalNum;
			if(total<0)
				total-= 2*total;						//making he result positive, if the second hexadecimal number is greater, i.e the result is negative.
		}
		
		void multiply(String next2)
		{
			decimalNum=toDecimal(next2);
			total*=decimalNum;
		}
		
		void divide(String next2)
		{
			decimalNum=toDecimal(next2);
			total/=decimalNum;
		}
		
		String compare(String next2)
		{
			if(next2.length() == oldNum.length())
			{
				if(next2.equalsIgnoreCase(oldNum))			//check for equal numbers.
				{
					return "Both numbers are equal";
				}
				
				for(int i=0; i<next2.length(); i++ )
				{
					if(next2.charAt(i) > oldNum.charAt(i))
						return (next2+" is the larger number");
					
					if(next2.charAt(i) < oldNum.charAt(i))
						return (oldNum+" is the larger number");
				}
				return null;
			}
			else
			{
				if(next2.length() < oldNum.length())
					return (oldNum+" is the larger number");
				else
					return (next2+" is the larger number");
			}
			
		}
		
		/*
		method for taking the input.
		For checking if the hexadecimal number is valid.
		Retaking the input if not valid.
		*/
		
		String inputHexa()
		{
			System.out.println("Enter the hexaDecimal number");
			String hexaNum=sc.next();
			
			hexaNum.toUpperCase();
			
			if(checkHexa(hexaNum))
			{
				System.out.println("Invalid hexadecimal number. Enter again.");
				hexaNum=inputHexa();
			}
			
			return hexaNum;
		}
		
		/*
		method for checking the validity of the hexadecimal number.
		*/
		boolean checkHexa(String number)
		{
			boolean flag=false;
			
			for(int i=0; i<number.length(); i++)
			{
				int character=(int)number.charAt(i);
				
				if((character>=65 && character<=70)||(character>=97 && character<=102)||(character>=48 && character<=57))
				{
					flag=false;
				}
				else
				{
					flag=true;
					return flag;
				}
			}
			return false;	
		}
		
		/*
		menu for the user to choose from the operations.
		*/
		
		void options(char operation)
		{			
			String next;
			
			switch(operation)
			{
			case '+':
				next=inputHexa();
				add(next);
				break;
			case '-':
				next=inputHexa();
				subtract(next);
				break;
			case '*':
				next=inputHexa();
				multiply(next);
				break;
			case '/':
				next=inputHexa();
				divide(next);
				break;
			case '1':
				next=inputHexa();
				System.out.println(compare(next));
			case '0':
				System.exit(0);
			default:
				System.out.println("invalid choice");
				break;
			}
		}
}
