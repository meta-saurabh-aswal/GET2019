import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class LinearList
{
	Node head = null;
	int size = 0;
	
	//Utility method to find the last node.
	public Node endNode()
	{
		Node lastNode;
		lastNode = head;
		
		while(true)
		{
			if(null == lastNode.next)
			{
				return lastNode;
			}
			
			lastNode = lastNode.next;
		}
	}
	
	//Utility method to add a list of elements to the linked list.
	public void addFullList(int[] array)
	{
		for(int i=0; i<array.length; i++)
		{
			addAtEnd(array[i]);
		}
	}
	
	//Utility method to return a node at a given position.
	public Node searchNode(int position)
	{
		Node current = head;
		
		for(int i=0; i < size; i++)
		{
			if(i == position-1)
				break;

			current = current.next;
		}
		
		return current;
	}

	//To add a list through JSON file
	public void addJsonList()
	{
		FileReader reader = null;
		
		try
		{
			reader = new FileReader("input.json");	
		}
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
		 
        JSONParser jsonParser = new JSONParser();
        JSONArray jsonArr = null;
        try
        {
			Object temp = jsonParser.parse(reader);
			 jsonArr = (JSONArray) temp;
		}
        catch (IOException | ParseException e)
        {
			e.printStackTrace();
		}

        for(int i = 0; i<jsonArr.size(); i++)
        {
        	if(jsonArr.get(i) instanceof Long)
        	{
        		addAtEnd((int)((long)jsonArr.get(i)));
        	}
        	else
        	{
        		JSONArray jsonSubArr = (JSONArray) jsonArr.get(i);
        		int javaArr[] = new int[jsonSubArr.size() - 1];
        		
        		for(int j =0; j<javaArr.length; j++)
        		{
        			javaArr[j] = (int)((long)jsonSubArr.get(j+1));
        		}
        		
        		addAtEnd((int)((long)jsonSubArr.get(0)));
        		
        		addListAt(i+1, javaArr);       		
        	}
        }
        
	}
	
	//To add a list as branch at a specific position  
	public void addBranch(int[] array, int position)
	{
		Node current = searchNode(position);
		Node newNode = new Node(array[0]);
		current.branch = newNode;
		
		for(int i=1; i<array.length; i++)
		{
			 newNode.next = new Node(array[i]);
			 newNode = newNode.next;			 
		}
	}
	
	//To add element at the end of the Linked List
	public void addAtEnd(int data)
	{
		Node newNode = new Node(data);
		newNode.next = null;
		
		if(null == this.head)
		{
			Node node = newNode;
			this.head = node;
			newNode.next = null;
			size++;
		}
		else
		{
			Node lastNode = endNode();
			lastNode.next = newNode;
			newNode.next = null;
			size++;
		}
	}
	
	//To add element after a specific position 
	public void addNodeAfter(int position, int data)
	{
		if(null == this.head)
		{
			System.out.println("Empty list");
			System.exit(0);
		}
		
		Node newNode = new Node(data);
		Node current = searchNode(position);
		
		Node temp = current.next;
		current.next = newNode;
		newNode.next = temp;
		size++;
	}
	
	//To add a whole list at a specific position
	public void addListAt(int position, int[] array)
	{
		Node current = searchNode(position);		
		Node newNode = new Node(array[0]);
		current.branch = newNode;
		current = current.branch;
		
		for(int i=1; i<array.length; i++)
		{
			Node newNode2 = new Node(array[i]);
			current.next = newNode2;
			
			current = current.next;
		}
	}
	
	//To print the whole linked List
	public void printList()
	{
		if(null == this.head)
		{
			System.out.println("Empty list");
			System.exit(0);
		}
		
		Node current = head;
		
		while(null != current)
		{
			System.out.print(current.data);
			
			if(null != current.branch)
			{
				Node branchCurrent = current.branch;
				
				while(null != branchCurrent)
				{
					System.out.print("\t"+ branchCurrent.data);
					branchCurrent = branchCurrent.next;
				}
			}
			
			System.out.println();
			current = current.next;
		}
		
	}

}
