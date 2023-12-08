import java.util.Scanner;

class stack_class
{
    private int top,size;
    private int[] stack_arr;
    private Scanner sc ;

    public stack_class( Scanner sc )
    {
        this.sc = sc;
        get_stacksize();
        top = -1;
        stack_arr = new int[size];
    }

    public int get_stacksize()
    {
        System.out.print("Enter stack size :  ");
        size = sc.nextInt();
        return size;
    }

    public void push(int value)
    {
        if( top==size-1 )
        {
            System.out.println("Stack is full !!   "+" New value="+value+" is rejected");
            return;
        }
        stack_arr[++top] = value;
    }

    public void pop()
    {
        if( top==-1 )
        {
            System.out.println("Stack is empty");
            return;
        }
        System.out.println("Popped "+stack_arr[top--]+" out of stack !!");
    }

    public int peek()
    {
       if( top==-1 )
        {
            System.out.println("Stack is empty");
            return Integer.MIN_VALUE;
        }
       return stack_arr[top];
    }
}

public class stack
{
    public static void main( String[] args)
    {
       Scanner sc = new Scanner(System.in);
       stack_class stack_obj = new stack_class(sc);

       stack_obj.pop();
       stack_obj.push(5);
       System.out.println(stack_obj.peek());
       stack_obj.push(20);
       System.out.println(stack_obj.peek());
       stack_obj.push(15);
       System.out.println(stack_obj.peek());
       stack_obj.pop();
       System.out.println(stack_obj.peek());
       stack_obj.push(50);
       System.out.println(stack_obj.peek());
       stack_obj.push(25);
       System.out.println(stack_obj.peek());
       stack_obj.push(100);
       stack_obj.push(70);
       System.out.println(stack_obj.peek());
       stack_obj.pop();
       System.out.println(stack_obj.peek());
       stack_obj.pop();
       System.out.println(stack_obj.peek());
       stack_obj.pop();
       System.out.println(stack_obj.peek());
       stack_obj.pop(); 
       System.out.println(stack_obj.peek());
       stack_obj.pop(); 
       System.out.println(stack_obj.peek());
       stack_obj.pop();            
    }
}