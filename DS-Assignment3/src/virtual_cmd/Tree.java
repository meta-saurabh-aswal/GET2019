package virtual_cmd;

public class Tree
{
	Dir root = new Dir("root");
	Dir currentDir = root;
	//Branches currentBr = currentDir.next;
	
	//Utility
	public String dirPath(Dir currentDir)
	{
		Dir current = currentDir;
		String path = new String();
		
		while(null != current.parentBr)
		{
			path = current.name +"/"+ path;
			current = current.parentBr.parentDir;
		}  
		
		path = "root:/" + path;
		return path;
	}	
	
	public void search(String data, Branches fromBr)
	{
		if(fromBr == root.next && null == fromBr)
		{
			if(root.name.equalsIgnoreCase(data))
				System.out.println("root");
			
			System.exit(0);
		}
		
		Branches currentBr = fromBr;
		
		if(null != currentBr)
		{
			if(null != currentBr.child.next)
			{
				if(currentBr.child.name.equalsIgnoreCase(data))
				{
					System.out.println(dirPath(currentBr.child));
					System.exit(0);
				}	
				else
				{	
					search(data, currentBr.child.next);
				}
			}
			else
			{
				if(currentBr.child.name.equalsIgnoreCase(data))
				{
					System.out.println(dirPath(currentBr.child));
					System.exit(0);
				}	
				else
				{	
					search(data, currentBr.nextBr);
				}
			}
						
			if(null == currentBr.nextBr)
			{
				search(data, currentBr.parentDir.parentBr.nextBr);
			}
		}
	}
	
	public void mkDir(String name)
	{
		Dir newDir = new Dir(name);
		Branches newBranch = new Branches(newDir, currentDir);
		
		if(null == currentDir.next)
		{
			currentDir.next = newBranch;
			newBranch.parentDir = currentDir;
			newBranch.child = newDir;
			newDir.parentBr = newBranch;
		}
		else
		{
			Branches itr = currentDir.next;
			
			while(null != itr.nextBr)
			{
				itr = itr.nextBr;
			}
			
			itr.nextBr = newBranch;
			newBranch.child = newDir;
			newDir.parentBr = newBranch;
			newBranch.parentDir = currentDir;
		}
		
		System.out.println(dirPath(currentDir));
	}

	public void cd(String name)
	{
		Branches current = currentDir.next;
		
		 while(null != current)
		 {
			 Dir itr = current.child;
			 
			 if(itr.name.equalsIgnoreCase(name))
			 {
				 currentDir = itr;
			
				 System.out.println(dirPath(itr));
				 break;
			 }
			 
			 current = current.nextBr;
		 }
	}
	
	public void parentNode()
	{
		currentDir = currentDir.parentBr.parentDir;
		
		System.out.println(dirPath(currentDir));
	}
	
	public void printTree(Branches fromBr)
	{
		if(fromBr == root.next && null == fromBr)
		{
			System.out.println("root");
			System.exit(0);
		}
		
		Branches currentBr = fromBr;
		
		if(null != currentBr)
		{
			if(null != currentBr.child.next)
			{
				System.out.println(dirPath(currentBr.child));
				
				printTree(currentBr.child.next);
			}
			else
			{
				System.out.println(dirPath(currentBr.child));
				
				printTree(currentBr.nextBr);
			}	
			
			if(null == currentBr.nextBr)
			{
				printTree(currentBr.parentDir.parentBr.nextBr);
			}
		}
		
	}
	
}
