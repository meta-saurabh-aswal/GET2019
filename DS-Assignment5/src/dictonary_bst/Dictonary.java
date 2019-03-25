package dictonary_bst;

public interface Dictonary
{
	public Node insert(Node current, String key, String value);
	public Node deleteNode(Node current, String key);
	public Node searchNode(String key);

}
