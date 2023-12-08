import java.util.Scanner;

class queue_circular{
    private int size,count;
    private int[] queue;
    private int f=0,r=0;

    public queue_circular(Scanner sc)
    {
       System.out.print("Enter the size :  ");
       size = sc.nextInt();
       queue = new int[size];
       f = 0;
       r = -1;
       count = 0;
    }

    public void insert(int value)
    {
       if( count==size )
          {
            System.out.println("Queue Full!!");
            return;
          }
       r = (r+1)%size;
       queue[r] = value;
       count++;
    }

    public void delete()
    {
       if( count==0 )
       {
         System.out.println("Queue Empty !!");
         return;
       }
       f = (f+1)%size;
       count--;
       if( count==0 )
        {
            f = 0;
            r = -1;
        }
    }

    public void display()
    {
        System.out.print("Queue elements :  ");
        if( count==0 )
        {
           System.out.println("Queue is Empty!!");
           return;
        } 
        int x = f;
        int cnt = count;
        while( cnt!=0 )
          { 
            System.out.print(" "+queue[x]+" ");
            x = (x+1)%size;
            cnt--;
          }
        System.out.println("\n");
    }

}

public class circular_queue
{
    public static void main( String[] args )
    {
        Scanner sc = new Scanner(System.in);
        int ch,x;
        queue_circular q = new queue_circular(sc);

        while( true )
        {
            System.out.println("0.Exit \n1.Insert \n2.Delete \n3.Display \n");
            ch = sc.nextInt();
            switch(ch)
            {
                case 0 : sc.close();  return;
                case 1 : System.out.print("Enter new element :  ");  x = sc.nextInt();
                         q.insert(x);
                         break;
                case 2 : q.delete();
                         break;
                case 3 : q.display();
                         break;
                default : System.out.println("Invalid Choice"); 
                          break;
            }
        }
    }
}
