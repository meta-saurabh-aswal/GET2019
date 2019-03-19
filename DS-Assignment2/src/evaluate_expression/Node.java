package evaluate_expression;

public class Node 
{
	
	int data;
    Node next;
    
    //parameterized constructor to initialize the properties
    public Node(int data)
    {
        this.data=data;
        this.next=null;
    }

    //method to return the data of the node 
    public int getData()
    {
        return this.data;
    }

    //method to return the next node location 
    public Node getNext()
    {
        return this.next;
    }

    //method to set the next node location
    public void setNext(Node node)
    {
        this.next=node;
    }
	
}
