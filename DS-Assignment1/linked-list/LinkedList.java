import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LinkedList
{
	Node head = null;
	int size = 0;
	
	//Utility
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
	
	public void addNodeAfter(int position, int data)
	{
		if(null == this.head)
		{
			System.out.println("Empty list");
			System.exit(0);
		}
		
		Node current = head;
		Node newNode = new Node(data);
		
		for(int i=0; i < size; i++)
		{
			if(i == position-1)
				break;
			System.out.println(i+" "+current.data+" "+position);
			current = current.next;
		}
		
		Node temp = current.next;
		current.next = newNode;
		newNode.next = temp;
		size++;
	}
	
	//To rotate a sublist from L (left) to R (right) by N steps.
	public void rotateSublist(int L, int R, int N)
	{
		if(null == this.head)
		{
			System.out.println("Empty Linked List");
			System.exit(0);
		}
		
		N = N % (R - L + 1);
		
		Node left = null, right = null, current, beforeLeft = null, afterRight = null, nth = null;
		current = head;
		
		for(int i=0; i<=R ; i++)
		{
			if(i+1 == L)
			{
				left = current.next;
				beforeLeft = current;
			}
			if(i == R-N)
			{
				nth = current;
			}
			if(i == R)
			{
				right = current;
				afterRight = current.next;
				break;
			}
			
			current = current.next;
		}
		
		//System.out.println(left.data +" "+right.data+" "+beforeLeft.data+" "+afterRight.data+" "+nth.data+" "+N);
		beforeLeft.next = nth.next;
		right.next = left;
		nth.next = afterRight;
	}
	
	public int loopDetect()
	{
		Node current = head;
		
		Map<Node, Boolean> visited = new HashMap<Node, Boolean>();
		
		for(int i = 0; null != current; i++)
		{
			if(null == visited.get(current))
			{
				visited.put(current, true);
				current = current.next;
			}
			else
			{
				System.out.println("Loop at : "+i);
				return i;
			}
		}
		return -1;
	}
	
	public int[] printList()
	{
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		
		if(null == this.head)
		{
			System.out.println("Empty list");
			System.exit(0);
		}
		
		Node current = head;
		
		while(null != current)
		{
			System.out.println(current.data);
			arrList.add(current.data);
			current = current.next;
		}
		
		int array[] = new int[arrList.size()];
		int itr=0;
		for(Integer i: arrList)
		{
			array[itr] = i;
			itr++;
		}
		return array;
	}

}
