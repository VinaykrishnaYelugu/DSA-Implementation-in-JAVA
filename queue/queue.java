import java.util.Scanner;

class queue_class
{
   private int front,rear,size;
   private int[] Queue;
   private Scanner sc;

   public void get_size()
   {
       System.out.print("Enter queue size :  ");
       size = sc.nextInt();
   }

   public queue_class(Scanner sc)
   {
      front = 0;
      rear = -1;
      this.sc = sc;
      get_size();
      Queue = new int[size];
   }

   public void enqueue(int value)
   {
      if( rear==size-1 )
      {
        System.out.println("The queue is full !!   Rejected "+value+" !!");
        return;
      }
      Queue[++rear] = value;
   } 

   public void dequeue()
   {
     if( front==0 && rear==0 )
     {
        System.out.println("Queue is empty !!  Can't dequeue ");
        return;
     }
     System.out.println("Remmoved "+Queue[front++]+ " from Queue !!");
     if( rear<front )
     {
        System.out.println("Queue is Empty !!");
        rear = -1;
        front = 0;
     }
   }

   public void display()
   {
      if( front==0 && rear==0 )
      {
         System.out.println("Queue is empty !! ");
         return;
      }
      System.out.print("Queue elements : ");
      for( int i=front ; i<=rear ; i++ )
          System.out.print("  "+Queue[i]);
      System.out.println("               f="+front+" rear="+rear);
   }
}


public class queue
{
    public static void main( String[] args )
    {
         Scanner sc = new Scanner(System.in);
         queue_class Q_obj = new queue_class(sc);

         Q_obj.enqueue(30);
         Q_obj.display();

         Q_obj.enqueue(25);
         Q_obj.display();

         Q_obj.enqueue(35);
         Q_obj.display();

         Q_obj.enqueue(20);
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();

         Q_obj.enqueue(40);
         Q_obj.display();

         Q_obj.enqueue(50);
         Q_obj.display();

         Q_obj.enqueue(200);
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();

         Q_obj.enqueue(30);
         Q_obj.display();

         Q_obj.enqueue(25);
         Q_obj.display();

         Q_obj.enqueue(35);
         Q_obj.display();

         Q_obj.enqueue(20);
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();

         Q_obj.dequeue();
         Q_obj.display();
        }
}