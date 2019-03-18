package dictonary_bst;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class BST implements Dictonary
{	
	Node root = null;
	ArrayList<String> inorderKeyList;

	// A utility function to insert a new  
	// Node with given key in BST  
	public Node insert(Node root, String key, String value)  
	{  
		// Create a new Node containing  
		// the new element  
		Node newNode = new Node(key, value);  

		if(null == this.root)
		{
			this.root = newNode;
			return this.root;
		}
		else
		{
			// To iterate till the position where the node is to be inserted  
			Node current = root;  

			// Trailing the parent of current 
			Node trail = null;

			while (current != null)
			{  
				trail = current;  
				if (key.compareTo(current.key) < 0)  
				{
					current = current.left;  
				}
				else
				{
					current = current.right;  
				}
			}  

			// If the root is null i.e the tree is empty
			if (trail == null)  
			{
				trail = newNode;
			}

			// If the new key is less then the leaf node key  
			// Assign the new node to be its left child  
			else if (key.compareTo(trail.key) < 0)  
			{
				trail.left = newNode; 
			}

			// else assign the new node its right child  
			else
			{
				trail.right = newNode;
			}

			// Returns the pointer where the  
			// new node is inserted  
			return trail;	    
		} 
	}

	public void addJson()
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
		JSONObject jsonObject = null;
		try
		{
			jsonObject = (JSONObject) jsonParser.parse(reader);
		}
		catch (IOException | ParseException e)
		{
			e.printStackTrace();
		}

		for(Iterator itr = jsonObject.keySet().iterator(); itr.hasNext();)
		{
			String key = (String) itr.next();
			insert(root, key, (String)jsonObject.get(key));
		}

	}

	//To insert key-value pairs from an array.
	public void addArray(String []keys, String [] values)
	{
		for(int i=0; i<keys.length; i++)
		{
			insert(root, keys[i], values[i]);
		}
	}

	// A utility method to do inorder traversal of BST 
	void inorder(Node current)
	{ 
		if (current != null)
		{ 
			inorder(current.left); 

			inorderKeyList.add(current.key);
			inorder(current.right); 
		} 
	}

	void inorderRecord(Node current)
	{
		inorderKeyList = new ArrayList<String>();

		inorder(current);
	}

	// Helper function to find minimum value node in subtree rooted at current
	public static Node minimumKey(Node current)
	{
		while(current.left != null)
		{
			current = current.left;
		}
		return current;
	}

	public Node deleteNode(Node root, String key)
	{
		// pointer to store parent node of current node
		Node parent = null;

		// start with root node
		Node current = root;

		// search key in BST and set its parent pointer
		while (current != null && current.key != key)
		{
			// update parent node as current node
			parent = current;

			// if given key is less than the current node, go to left subtree
			// else go to right subtree
			if (key.compareTo(current.key) < 0)
			{
				current = current.left;
			}
			else
			{
				current = current.right;
			}
		}

		// return if key is not found in the tree
		if (current == null)
		{
			return root;
		}

		// Case 1: node to be deleted has no children i.e. it is a leaf node
		if (current.left == null && current.right == null)
		{
			// if node to be deleted is not a root node, then set its
			// parent left/right child to null
			if (current != root) {
				if (parent.left == current)
				{
					parent.left = null;
				}
				else
				{
					parent.right = null;
				}
			}
			// if tree has only root node, delete it and set root to null
			else
			{
				root = null;
			}
		}

		// Case 2: node to be deleted has two children
		else if (current.left != null && current.right != null)
		{
			// find its in-order successor node
			Node successor  = minimumKey(current.right);

			// store successor value
			String val = successor.key;

			// recursively delete the successor. Note that the successor
			// will have at-most one child (right child)
			deleteNode(root, successor.key);

			// Copy the value of successor to current node
			current.key = val;
		}

		// Case 3: node to be deleted has only one child
		else
		{
			// find child node
			Node child = (current.left != null)? current.left: current.right;

			// if node to be deleted is not a root node, then set its parent
			// to its child
			if (current != root)
			{
				if (current == parent.left)
				{
					parent.left = child;
				}
				else
				{
					parent.right = child;
				}
			}

			// if node to be deleted is root node, then set the root to child
			else
			{
				root = child;
			}
		}

		return root;
	}

	//To search a key in the BST
	public Node searchNode(String key)
	{
		Node current = this.root;

		while(current != null)
		{
			if(key.compareTo(current.key) == 0)
			{
				return current;
			}
			else if(key.compareTo(current.key) < 0)
			{
				if(null != current.left)
				{
					current = current.left;
				}
				else
				{
					System.out.println("Not found");
					break;
				}
			}
			else
			{
				if(null != current.right)
				{
					current = current.right;
				}
				else
				{
					System.out.println("Not found");
					break;
				}
			}
		}

		return null;
	}
}
