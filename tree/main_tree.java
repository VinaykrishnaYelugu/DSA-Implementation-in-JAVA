import java.util.Scanner;

class tree_class
{
    NODE root = null;

    private class NODE 
    {
        private NODE ll,rl;
        private int info;

        public NODE(int value)
        {
           this.ll = this.rl = null;
           this.info = value;
        }
    }

    public void insert(int value)
    {
        NODE node = new NODE(value);
        if( root==null )
        {
            root = node;
            return;
        }
        NODE trav = root,follow=null;
        while( trav!=null )
        {
            if( value<trav.info )
                  { follow=trav; trav = trav.ll; }
            else //if( value>=trav.info )
                  { follow=trav; trav = trav.rl; }
        }
        if( value<follow.info )
            follow.ll = node;
        else
            follow.rl = node;
    }

    public void display(int choice,NODE node)
    {
       if( node==null )
          return;
       switch(choice)
       {
         case 1 : display(1,node.ll); 
                  display(1,node.rl); 
                  System.out.print(" "+node.info+" "); 
                  break;
         case 2 : System.out.print(" "+node.info+" "); 
                  display(2,node.ll); 
                  display(2,node.rl); 
                  break;
         case 3 : display(3,node.ll); 
                  System.out.print(" "+node.info+" "); 
                  display(3,node.rl); 
                  break;
        }
    }

    public void display_prefix()
    {
        System.out.println("Prefix :  ");
        display(1,root);
        System.out.println("\n");
    }

    public void display_postfix()
    {
        System.out.println("Postfix :  ");
        display(2,root);
        System.out.println("\n");
    }

    public void display_infix()
    {
        System.out.println("Infix :  ");
        display(3,root);
        System.out.println("\n");
    }

    public NODE traversal( NODE trav, int value )
    {
        if( trav==null )
           return null;
        if( value==trav.ll.info || value==trav.rl.info )
           return trav;
        else if( value<trav.info )
           return ( traversal(trav.ll,value) );
        else
           return( traversal(trav.rl,value) );
        
    }

    public void delete(int value)
    {
        if( root==null )
          {
            System.out.println("Tree empty !!");
            return;
          }
          
        NODE trav = root,follow = null;
        while( trav!=null )
        {
            if( trav.info==value )
               break;
            follow = trav;
            if( value<trav.info )
                trav = trav.ll;
            else
                trav = trav.rl;
        }

        if( trav==null )
        {
            System.out.println("Element "+value+" not found !!");
            return;
        }

        // if deletion node s a leaf node ( left and right child won't be there )
        if( trav.ll==null && trav.rl==null )
        {
            if( trav==root )
              {
                root=null;
                return;
              }
            if( follow.ll!=null && value==follow.ll.info )
               follow.ll = null;
            else
               follow.rl = null;
            return;
        }

        // if deletion node is not leaf node and has only one child
        if( trav.ll==null || trav.rl==null )
        {
            if( trav.ll==null )
              {  trav = trav.rl;  } 
            else if( trav.rl==null )
              { trav = trav.ll;  }
            if( root.info==value )
            {
                root = trav;
                return;
            }

            if( follow.ll!=null && follow.ll.info==value )
               follow.ll = trav;
            else
               follow.rl = trav;
            return;
        }
        
        // if the deletion node is having 2 children
        if( trav.ll!=null && trav.rl!=null )
        {
            NODE succ = trav.rl,fsucc=null;
            while( succ.ll!=null )
            {  
                fsucc = succ;
                succ = succ.ll;  
            }
            if( fsucc!=null )
               fsucc.ll = succ.rl;
            else
               trav.rl = succ.rl;
            
            succ.ll = trav.ll;
            succ.rl = trav.rl;

            if( trav==root )
            {
                root = succ;
                return;
            }

            if( follow.rl==trav )
               follow.rl = succ;
            else
               follow.ll = succ;
            return;
        }
    }
}

public class main_tree
{
    public static void main( String[] args )
    {
        tree_class t = new tree_class();
        int choice,value;
        Scanner sc = new Scanner(System.in);
        while( true )
        {
            System.out.println("Enter the choice\n");
            System.out.println("  0.Exit\n  1.Insert\n  2.delete\n  3.Display_Prefix\n  4.Display_POSTFIX\n  5.Display_infix\n");
            choice = sc.nextInt();
            switch(choice)
            {
                case 0 : return;
                case 1 : System.out.print("Enter new value :  "); 
                         value = sc.nextInt();
                         t.insert(value);
                         t.display_prefix();  t.display_postfix();  t.display_infix();
                         break;
                case 2 : System.out.println("Enter value to be deleted :  ");
                         value = sc.nextInt();
                         t.delete(value);
                         t.display_prefix();  t.display_postfix();  t.display_infix();
                         break;

            }
        }
    }
}
