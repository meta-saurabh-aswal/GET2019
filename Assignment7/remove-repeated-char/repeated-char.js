function charReplace()
{
    var inputString = document.getElementById("string").value;

	for(let j=0; j<inputString.length; j++)
	{ 
		for(let i=1; i<inputString.length; i++)
		{  
			let char = inputString.charAt(i);

			if(char == inputString.charAt(i-1));
			{
           		let r = char + char;
           
				inputString = inputString.split(r).join("");
			}
		}		
	}
	document.writeln(inputString);
}