package virtual_cmd;
import java.util.Scanner;

public class Cmd
{
	public static void main(String args[])
	{
		Tree dirTree = new Tree();
		String name = new String();		
		
		while(true)
		{
			Scanner sc = new Scanner(System.in);
			System.out.println(" Enter 1 for creating dir \n Enter 2 for cd\n Enter 3 to print parent directory\n Enter 4 to print the whole tree\n Enter 5 to search a directory\n Enter 0 to exit");
			char choice = sc.next().charAt(0);
			
			switch(choice)
			{
			case '1':
				name = sc.next();
				dirTree.mkDir(name);
				break;
			
			case '2':
				name = sc.next();
				dirTree.cd(name);
				break;
				
			case '3':
				dirTree.parentNode();
				break;
				
			case '4':
				dirTree.printTree(dirTree.root.next);
				break;
				
			case '5':
				System.out.println("Enter the name of the directory");
				name = sc.next();
				dirTree.search(name, dirTree.root.next);
				break;
					
			case '0':
				System.exit(0);
			}
		}
	}

}
