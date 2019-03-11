class Node1
{
    //intializes the node with the data
    constructor(element)
    {
        this.element = element;
        this.next = null;
        this.prev = null;
    }
}

class LinkedList1
{
    //constructor to intialize the Linked List
    constructor()
    {
        this.size = 0;
        this.head = null;
            
    }

    //method to add the element at the specified position or at the end of the list
    addDouble()
    {
        var value = document.getElementById("getValueDouble").value;
        var position = document.getElementById("getPositionDouble").value;
        if(value == "") 
        {
            alert("Element Can't be null");
        }
        else{
            //it will add the element at the end of the list as the position is null
            if(position == "")
            {

                var node = new Node1(value); 

                //it node is the first element in the list
                if(this.head == null)
                {
                    this.head = node; 
                    this.size++;
                }

                else{
                    var currentNode = this.head;
                    while (currentNode.next != null)
                     {
                        currentNode = currentNode.next;
                    }
                    currentNode.next = node;
                    node.prev = currentNode;
                    this.size++;
                }
            }
            //this will add the element at the specified position
            else{
                if(position <0 || position >this.size)
                {
                    alert("Position is out of range!!");
                }
                else
                {
                    var node = new Node1(value); 
                    var curr , prev;
                    curr = this.head;

                    //if node to be add at the first position
                    if(position == 0)
                    {
                        node.next=this.head;
                        this.head = node;
                        node.prev = null;
                        this.size++;
                    }
                    else
                    {
                        curr = this.head;
                        var it=0;
                        while(it<position)
                        {
                            it++;
                            prev=curr;
                            curr = curr.next;
                        }
                        node.next = curr;
                        prev.next = node;
                        node.prev = prev;
                        curr.prev = node;
                        this.size++;
                    }
                }
            }
            document.getElementById("getValueDouble").value="";
            document.getElementById("getPositionDouble").value="";
            this.printListDouble();
        }
    }

    //this method will delete the first element matched in the list
    deleteDouble()
    {
        var value = document.getElementById("getValueDouble").value;
        var current = this.head; 
        var prev = null; 
        var flag=0;
        if(this.size == 0)
        {
            alert("List is Empty");
        }
        else if(value == "")
        {
            alert("Input Can't be null");
        }
        else{
            while(current != null)
            {

                if(current.element == value)
                {
                    
                    if(current.next)
                    {
                        current.next.prev = current.prev;
                    }
                    if(current.prev)
                    {
                        current.prev.next = current.next;
                    }
                    //if the node is the first node
                    else{
                        this.head = current.next;
                        if(this.head)
                        {
                            this.head.prev = null;
                        }
                    }
                    flag=1;
                    break;
                }
                current = current.next;
            }

            if(flag == 0)
            {
                alert("Element Not found");
            }

        }

        document.getElementById("getValueDouble").value="";
        document.getElementById("getPositionDouble").value="";
        this.printListDouble();
    }

    //prints the list with current elements in it
    printListDouble()
     { 

	    var curr = this.head; 
	    var str = ""; 
        while (curr) 
        { 
		    str += curr.element + " "; 
		    curr = curr.next; 
        } 
        if(str=="") alert("no element");
    
	    document.getElementById("resultDouble").innerHTML=str; 
    } 

}

let doubleObject = new LinkedList1();