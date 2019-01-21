import java.util.*;

/*
StringHandler is a class for taking strings as input and doing operations on it
like reverse, finding the largest word in the string, and changing the
case of characters from uppercase to lowercase and vice-versa.

@author Saurabh Aswal
@version 1.0
@since 20/01/18
*/

class StringHandler
{	
	/*
	Method for taking a string as an input.
	@return String type.
	*/
	String inputString()
	{
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		return input;
	}
	
	/*
	Method for reversing the input string.
	@param String type.
	@return String type.
	*/
	String reverse(String s)
	{
		int sSize = s.length();
		
		String temp = new String();
		
		for(int i=sSize-1; i >= 0; i--)
		{
			temp = temp + s.charAt(i);
		}
		return temp;
	}
	
	/*
	 * To compare the two strings input by the user.
	 * 
	 * @param s1 & s2 of String type for comparison.
	 * @return 0 or 1 as int for unequal or equal strings respectively.
	 */
	int compare(String s1, String s2)
	{
		int sSize = s1.length();
		
		if(s1.length() == s2.length())
		{
			s1 = lowercase(s1);
			s2 = lowercase(s2);
			
			for(int i=0; i < sSize; i++)
			{
				if(s1.charAt(i) != s2.charAt(i))			//Stop if any character mismatches.
					return 0;
			}
			return 1;
		}
		else
			return 0;
	}
	
	/*
	 * To change the case from uppercase to lowercase and vice-versa.
	 * 
	 * @param String s input by the user to convert.
	 * @return converted String.
	 */
	String flipCase(String s)
	{
		int ch;										//to store each character of string while looping.
		String temp = new String();
		
		for(int i=0; i< s.length(); i++)
		{
			ch = (int)s.charAt(i);
			
			
			if(ch >= 65 && ch <= 90)				//ASCII of A to Z.
			{
				ch+=32;								//converting to lower-case.
				temp += Character.toString((char)ch);
			}
			else if(ch >= 97 && ch <= 122)				//ASCII of a to z.
			{
				ch-=32;									//converting to upper-case.
				temp +=  Character.toString((char)ch);
			}
		}
		return temp;
	}
	
	/*
	 * To find the largest word in the string by subtracting
	   indices of adjacent spaces.
	 * 
	 * @param String input by the user.
	 * @return Largest word as string.
	 */
	String largestWord(String s)
	{
		int maxUpIndex=0, maxLowIndex=0, lowIndex=0, upIndex=0, maxWord=0;
		
		s = s + " ";						//adding a space at the end of the string for iterating.
		
		for(int i=0; i< s.length(); i++)
		{
			if(s.charAt(i) == ' ')
			{
				lowIndex = upIndex;			//iterating spaces with lower bound and upper bound.
				upIndex = i;
				
				if(upIndex - lowIndex >= maxWord)
				{
					maxUpIndex = upIndex;
					maxLowIndex = lowIndex;
					maxWord = maxUpIndex - maxLowIndex + 1;			//Calculating the word length.
				}
			}
		}
		
		String temp = new String();
		
		for(int i= maxLowIndex+1; i<= maxUpIndex; i++ )
		{
			temp = temp + s.charAt(i);
		}
		return temp;
	}
	
	String lowercase(String s)
	{
		String temp = new String();
		System.out.println(temp);
		
		for(int i=0; i < s.length(); i++)
		{
			int ch = (int)s.charAt(i);
			ch += 32;
			
			if(ch >= 65 && ch <= 90)
			{
				temp = temp + Character.toString((char)ch);
			}
			else if(ch >=97 && ch <= 122 )
				temp = temp + Character.toString((char)ch);
			
		}
		return temp;
	}
	
	/*
	 * Menu for the user to choose operations.
	 * 
	 * @param the choice input by the user as char.
	 */
	void menu(char choice)
	{	
		int answer;
		String result;
		switch(choice)
		{
			case 'a':
				System.out.println("Enter 2 strings to compare");
				answer = compare(inputString(), inputString());
				System.out.println(answer);
				break;
			case 'b':
				System.out.println("Enter the string to reverse");
				result = reverse(inputString());
				System.out.println(result);
				break;
			case 'c':
				System.out.println("Enter the string to change its case");
				result = flipCase(inputString());
				System.out.println(result);
				break;
			case 'd':
				System.out.println("Enter the string to find the largest word");
				result = largestWord(inputString());
				System.out.println(result);
				break;
			case 'e':
				System.exit(0);
			default:
				System.out.println("Invalid Choice");
				break;
		}
	}
	
	public static void main(String args[])
	{
		Scanner sc1 = new Scanner(System.in);
		StringHandler handler = new StringHandler();
		
		System.out.println("Press a to Compare\nPress b to Reverse\nPress c change the case\nPress d to find the largest word\nPress e to exit"); 
		char choice = sc1.next().charAt(0);
		
		int val = (int)choice;
		if(val >= 65 && val <=90 )				//converting choice to lower-case to keep the same case
		{
			val +=32;
		}
		
		handler.menu((char)val);
		
		sc1.close();
	}
	
}
