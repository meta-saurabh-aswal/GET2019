package dictonary_bst;

public class Node
{
	String key;
	String value;
	Node left, right;
	
	Node(String key, String value)
	{
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
	}

}
