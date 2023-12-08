
class circular_link_list
{
    private Node head,tail;
    private int size;

    public circular_link_list()
    {
        this.size = 0 ;
        this.head = this.tail = null;
    }

    private class Node
    {
        private int value;
        private Node next;

        public Node(int value)
        {
            this.value = value;
            next = null;
        }
    }

    public void insert_front(int value)
    {
        Node new_node = new Node(value);
        if( head==null ) // tail==null
          { head = tail = new_node; }
        tail.next = new_node;
        new_node.next = head;
        head = new_node;
        size++;
        display();
    }

    public void insert_rear(int value)
    {
        Node new_node = new Node(value);
        if( head==null )
          { head = tail = new_node; }
        tail.next = new_node;
        new_node.next = head;
        tail = new_node;
        size++;
        display();
    }

    public void delete(int value)
    {
        Node trav = head,follow=tail;
        while( trav.value!=value )
        {
            follow = trav;
            trav = trav.next;
            if( trav==head )
            { System.out.println("The node with value="+value+" is not present in the List"); return; }
        }
        if( head==tail )
           { head = tail = null;  }
        else
        {
            follow.next = trav.next;
            if( trav==head )
            head = trav.next;
            if( trav==tail )
            tail = follow ;
            trav.next = trav = null;
        }
        size--;
        display();
    }

    public void display()
    {
        System.out.println("Linked List=>");
        if( head==null )
          System.out.println("List is Empty !!"); 
        else
        {
            Node trav = head;
            do{
                System.out.print(trav.value+"-->");
                trav = trav.next;
            }while( trav!=head );
        }
        System.out.println("END");
    }
}

public class main_clist 
{
    public static void main( String[] args )
    {
       circular_link_list o = new circular_link_list();
       o.insert_rear(10);
       o.insert_rear(20);
       o.insert_rear(30);
       o.insert_front(40);
       o.insert_front(50);
       o.delete(50);
       o.delete(30);
       o.delete(10);
       o.delete(20);
       o.delete(40);
       o.insert_rear(10);
       o.insert_rear(20);
       o.insert_rear(30);
       o.insert_front(40);
       o.delete(100);
    }
}
