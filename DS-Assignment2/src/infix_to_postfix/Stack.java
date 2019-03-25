package infix_to_postfix;

public interface Stack 
{
    int MAX = 10;
    
    String pop();
    
    void push(String c);
    
    String peek();
    
    boolean isEmpty();
    
    boolean isFull();
    
}
