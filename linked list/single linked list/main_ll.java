

class Linked_list
{
   private Node head;
   private Node tail;
   private int size;

   public Linked_list()
   { this.size=0; }

   private class Node
   {
       private int value;
       private Node next;
       
       public Node(int value)
       {
         this.value = value;
       }

    //    public Node(int value,Node next)
    //    { 
    //      this.value = value;
    //      this.next = next;
    //    }
   }

   public void insert_front(int value)
   {
      Node new_node = new Node(value);
      new_node.next = head;

      if( head==null && tail==null )
          head = tail = new_node ;
      head = new_node; 
      size++;
   }

   public void insert_rear(int value)
   {
     Node new_node = new Node(value);
     if( head==null && tail==null )
          insert_front(value);
     else
     {
        tail.next = new_node;
        tail = new_node;
        size++;
     }
   }

   public void insert_position(int value,int position)
   {
      if( position<1 || position>size+1 )
       { System.out.println("Inavlid !! Insertion at position "+position+" is not poaaible !!");  return; }
      Node new_node = new Node(value);
      int temp_position=1;
      Node trav=head,follow=head;

      if( position==1 )
         insert_front(value);
      else if( position==size+1 )
         insert_rear(value);
      else
      {
        while( temp_position!=position )
        {
            follow = trav;
            trav = trav.next;
            temp_position++;
        }
        follow.next = new_node;
        new_node.next = trav;
        size++;
      }
   }

   public void delete_front()
   {
      if( head==null && tail==null )
        { display(); return; }
      Node delete = head;
      head = head.next;  delete.next = null;   delete = null;
      if( head==null )
         tail = null;
      size--;
   }

   public void delete_rear()
   {
     if( head==null && tail==null )
        display();  
     else if( head==tail )
        delete_front();
     else
     {
        Node new_tail = get_ref_node(size-1);
        new_tail.next = null; 
        tail = new_tail;
        size--;
     }     
   }

   public void delete_position(int position)
   {
       if( position<1 || position>size )
         { System.out.println("No node at position="+position); return; }
       if( position==1 )
          delete_front();
       else if( position==size )
          delete_rear();
       else
       {
          Node prev = get_ref_node(position-1);
          Node delete = prev.next;
          prev.next = delete.next;
          delete.next = delete = null;          
       }

   }

   public Node get_ref_node(int position)
   {
      if( position<1 || position>size )
         { System.out.println("Invalid position !!"); return null; }
      else if( position==1 )
         return head;
      else if( position==size )
         return tail;
      else
      {
         Node trav = head;
         int temp_position=1;
         while( temp_position!=position )
         { trav = trav.next; temp_position++; }
         return trav;
      }
   }

   public void display()
   {
      Node trav=head;
      if( head==null && tail==null )
       { System.out.println("List is Empty !!"); }
      System.out.println("Linked List");
      while( trav!=null )
      {
         System.out.print(trav.value+"-->");
         trav = trav.next;
      }
      System.out.println("END");
   }
}

public class main_ll
{
    public static void main(String[] args)
    {
        Linked_list list = new Linked_list();
        list.delete_position(1);
        list.insert_rear(10);
        list.display();
        list.delete_position(1);
        list.display();
        list.insert_front(20);
        list.insert_rear(30);
        list.insert_front(40);
        list.display();
        list.delete_position(3);
        list.display();
        list.insert_rear(50);
        list.insert_rear(60);
        list.insert_front(70);
        list.display();
        list.delete_position(3);
        list.display();
        list.insert_position(80,1);
        list.insert_position(90,8);
        list.insert_position(100,10);
        list.insert_position(150,5);
        list.display();
        list.delete_position(6);
        list.display();
    }
}