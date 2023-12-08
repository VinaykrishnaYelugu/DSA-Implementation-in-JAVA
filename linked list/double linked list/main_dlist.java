

class Double_link_list
{
    private Node head;
    private Node tail;
    private int size;

    public Double_link_list()
    { this.size = 0; }

    private class Node
    {
        private int value;
        private Node next;
        private Node prev;

        public Node(int value)
        {
            this.value = value;
            this.next = this.prev = null;
        }
    }

    public void insert_front(int value)
    {
        Node new_node = new Node(value);
        new_node.next = head;
        if( head==null && tail==null )
           { head = tail = new_node; }
        else
        {
            head.prev = new_node;
            head = new_node;
        }
        size++;
        display_H_T();
    }

    public void insert_rear(int value)
    {
        if( head==null && tail==null )
           insert_front(value);  
        else
        {
            Node new_node = new Node(value);
            tail.next = new_node;
            new_node.prev = tail;
            tail = new_node;
            size++;
            display_H_T();
        }
    }

    public void insert_position(int value,int position)
    {
       if( position<1 || position>size+1 )
         {  System.out.println("Insertion at position="+position+" is not possible !!");  return; }
       else if( position==1 )
          insert_front(value);
       else if( position==size+1 )
          insert_rear(value);
       else
       {
          Node trav = get_node_ref(position);
          Node new_node = new Node(value);
          trav = trav.prev;
          new_node.next = trav.next;
          trav.next.prev = new_node;
          trav.next = new_node;
          new_node.prev = trav;
          size++;
          display_H_T();
       }
    }

    public Node get_node_ref(int position)
    {
       if( position<1 || position>size )
         {  System.out.println("Insertion at position="+position+" is not possible !!");  return null; }
       else if( position==1 )
           return head;
       else if( position==size )
            return tail;
       else
       {
          Node trav = head;
          int temp_position=1;
          while( temp_position!=position )
             { temp_position++; trav = trav.next; }
          return trav;
       }
    }

    public void display_H_T()
    {
        System.out.print("Linked List => \n");
        Node trav = head;
        while( trav!=null )
        {
            System.out.print(trav.value+"-->");
            trav = trav.next;
        }
        System.out.println("END");
    }

    public void display_T_H()
    {
        System.out.print("Reverse of Linked List => \n");
        Node trav = tail;
        while( trav!=null )
        {
            System.out.print(trav.value+"-->");
            trav = trav.prev;
        }
        System.out.println("START");
    }
}

public class main_dlist
{
    public static void main( String[] args )
    {
        Double_link_list o = new Double_link_list();

        o.insert_position(10,1);
        o.insert_position(20,1);
        o.insert_position(30,2);
        o.insert_position(40,4);
        o.insert_front(50);
        o.insert_rear(60);
        o.insert_position(70,6);
        o.display_H_T();
        o.display_T_H();
         
    }
}
