class Stack{

    constructor(){

        this.element=[];
    }

    pushValue()
    {

       try{

            var value = document.getElementById("getValue").value;

            if(value=="")
            {
                alert("Input can't be null");
            }
            else{
                this.element.unshift(value);
                console.log(this.element);
    
                document.getElementById("getValue").value="";
    
                this.showStack();
            }

            

       }
       catch(err){

           console.log(err.message);
       }

    }

    popValue()
    {

       try{

            if(this.element.length==0){

                alert("Stack is empty!!");
              }
           else{
            this.element.shift();
            document.getElementById("getValue").value="";
            this.showStack();
           }

       }
       catch(err){

           console.log(err.message);
       }

    }

    showStack()
    {

        try{

            var str="";
         
                for(let i=0; i<this.element.length;i++){

                    str= str+"   "+(this.element[i].toString());
                }
    
                document.getElementById("demo").innerHTML=str;
        }

        catch(err){

            console.log(err.message);
        }

    }

}

let stc=new Stack();

class Queue{

    constructor(){
        this.element1=[];
    }

    enQueue()
    {
        var input=document.getElementById("getQueueValue").value;
        if(input=="")
        {
            alert("Input cannot be null");
        }
        else{
            this.element1.push(input);
            document.getElementById("getQueueValue").value="";
            this.showQueue();
        }
    }
    deQueue()
    {
        if(this.element1.length==0)
        {
            alert("Queue is Empty");
        }
        else{
            this.element1.shift();
            document.getElementById("getQueueValue").value="";
            this.showQueue();
        }
    }

    showQueue()
    {
        var result="";
       
            for(let i=0;i<this.element1.length;i++)
            {
            result = result+"  "+(this.element1[i].toString());
            }

            document.getElementById("result").innerHTML=result;
    }
        

}

let queue =new Queue();