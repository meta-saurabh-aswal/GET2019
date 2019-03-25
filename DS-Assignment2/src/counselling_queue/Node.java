package counselling_queue;

class Node <type>
{
	type data; //data of <type> type
	Node link; //reference of next node
	
	/**
	 *Constructor to create a node with passed element as data and link as null
	 *@param: element
	 */
	Node(type element)
	{
		data = element;
		link = null;
	}
}