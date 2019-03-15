package virtual_cmd;

public class Dir
{
	String name = new String();
	Branches next;
	Branches parentBr;
	
	Dir(String name)
	{
		this.name = name;
		this.next = null;
		this.parentBr = null;
	}
}