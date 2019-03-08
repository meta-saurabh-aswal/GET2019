class Node 
{ 
	//intializes the node with the data
	constructor(element) 
	{ 
		this.element = element; 
		this.next = null
	} 
} 
 
class LinkedList
 { 
	//constructor to intialize the Linked List
	constructor() 
	{ 
		this.head = null; 
		this.size = 0; 
	} 

	//method to add the element at the specified position or at the end of the list	 
	add() 
	{ 
		let element=document.getElementById("getValue").value;
		let position = document.getElementById("getPosition").value;
		if(element==""){
			alert("Input can't be null");
		}
		//add the element at the specified position
        else if(position != "")
        {
		
            if (position < 0 || position > this.size) 
            {
				alert("Position entered out of range");
			}
			else { 
		
				var node = new Node(element); 
				var curr, prev; 
	
				curr = this.head; 
				//to add the element at the
                if (position == 0) 
                { 
					node.next = this.head; 
					this.head = node; 
				} 
				else { 
					curr = this.head; 
					var it = 0; 
					//iterarting until the input position comes
                    while (it < position) 
                    { 
						it++; 
						prev = curr; 
						curr = curr.next; 
					} 
	
				node.next = curr; 
				prev.next = node; 
				} 
				this.size++; 
				document.getElementById("getValue").value="";
				document.getElementById("getPosition").value="";
				this.printList();
			} 

		}
		//add the element at the last of the list
		else{
			var node = new Node(element); 

			var current; 

			if (this.head == null) 
				this.head = node; 
			else { 
				current = this.head; 

			
                while (current.next)
                 { 
					current = current.next; 
				}  
				current.next = node; 
			} 
			document.getElementById("getValue").value="";
			this.size++; 
			this.printList();
		}
	} 
    //delete the first element matched in the list
	removeElement() 
	{ 
		let element=document.getElementById("getValue").value;
		var current = this.head; 
		var prev = null; 
		var flag=0;

		if(this.size == 0){
			alert("List is Empty");
		}
		else{
            while (current != null)
             { 
			
                if (current.element === element) 
                { 
                    if (prev == null) 
                    { 
						this.head = current.next; 
					} else { 
						prev.next = current.next; 
					} 
					this.size--;
					flag=1;
					break;
				} 
				prev = current; 
				current = current.next; 
			} 
            if(flag==0)
            {
				alert("ELement Not found");
			}
			else{
				this.printList();
			}
		}
		document.getElementById("getValue").value="";
		
		
	} 

	//prints the list with the currently updated data in it
    printList() 
    { 
		var curr = this.head; 
		var str = ""; 
        while (curr) 
        { 
			str += curr.element + " "; 
			curr = curr.next; 
		} 
		if(str=="") alert("no element");
		
		document.getElementById("resultSingle").innerHTML=str; 
	} 

} 
let object=new LinkedList();