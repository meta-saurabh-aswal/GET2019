package unique_characters;

import java.util.HashMap;

public class UniqueChar
{
	HashMap <String, Integer> hMap = new HashMap<String, Integer>();
	
	public int checkString(String input)
	{
		if(hMap.containsKey(input))
		{
			return hMap.get(input);
		}
		
		int charCheck[] = new int[26];
		input = input.toLowerCase();
		
		for(int i=0; i<input.length(); i++)
		{
			char ch = input.charAt(i);
			
			if((int)ch >=97 && (int)ch <= 122)
				charCheck[(int)ch - 97]++;
			
		}
		
		int unique = 0;
		
		for(int i=0; i<charCheck.length; i++)
		{
			if(charCheck[i] == 1)
			{
				unique++;
			}
		}
		
		hMap.put(input, unique);
		
		return unique;
	}
	

}
