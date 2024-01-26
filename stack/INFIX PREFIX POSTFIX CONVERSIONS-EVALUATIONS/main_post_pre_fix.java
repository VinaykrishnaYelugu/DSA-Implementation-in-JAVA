import java.util.Scanner;

class prefix_postfix
{
    private String postfix,prefix;
    private char[] stack_s;
    private double[] evaluation_stk;
    private char c;
    private int x,x1;

    public int precedence( char c )
    {
        switch ( c )
        {
            case '+' : 
            case '-' : return 1;
            case '*' : 
            case '/' : return 2;
            case '^' : return 3;
            default : return -1;
        }
    }

    public char pop()
    {
        char c = stack_s[x];
        x--;
        return c;
    }

    public void push( char c )
    {
        x++;
        stack_s[x] = c;
    }

    public char peek()
    { return stack_s[x]; }

    public String postfix_func( String infix )
    {
        int l = infix.length();
        stack_s = new char[ l ];
        postfix = "";
        x = -1;
        for( int i=0 ; i<l ; i++ )
        {
            c = infix.charAt(i);
            if( ('A'<=c && c<='Z') || ( 'a'<=c && c<='z') || ( 48<=c && c<=57 ) )
                postfix += c;
            else
            {
               if( c=='(' )
                push(c);
               else if( c==')' )
               {
                  while( peek()!='(' )
                  { postfix += pop(); }
                  pop();
               }
               else
               {
                  if( x==-1 )
                  {
                    push((char)c);
                    continue;
                  }
                  else if( precedence( c )>precedence( peek())  )
                    push(c); 
                  else
                  {
                    while( x!=-1 && (peek()!='(') && (precedence( c )<=precedence( peek())) )
                    { postfix += pop(); }
                    push((char)c);
                  }
               }
            }
        }
        while( x>=0 )
        {  postfix += pop();  }
        return postfix;
    }

    public String prefix_func( String infix )
    {
        int l = infix.length();
        stack_s = new char[ l ];
        prefix = "";
        x = -1;
        for( int i=l-1 ; i>=0 ; i-- )
        {
            c = infix.charAt(i);
            if( ('A'<=c && c<='Z') || ( 'a'<=c && c<='z') || ( 48<=c && c<=57 ) )
                prefix += c;
            else
            {
               if( c==')' )
                push(c);
               else if( c=='(' )
               {
                  while( peek()!=')' )
                  { prefix += pop(); }
                  pop();
               }
               else
               {
                  if( x==-1 )
                  {
                    push((char)c);
                     continue;
                  }
                  else if( precedence( c )>=precedence( peek() )  )
                    push(c); 
                  else
                  {
                    while( x!=-1 && (peek()!='(') && (precedence( c )<precedence( peek() )) )
                    { prefix += pop(); }
                    push((char)c);
                  }
               }
            }
        }
        while( x>=0 )
       { prefix += pop(); }

        //reversing string
        String prefix0="";
        int pl=prefix.length();
        for( int i=0 ; i<pl ; i++ )
            prefix0 += prefix.charAt(pl-1-i);
        return prefix0;
    }

    public void evaluate( double v1, double v2,char character )
    {
        double solved=0;
        switch( character )
        {
            case '+' :  solved = ( v1+v2 );  evaluation_stk[++x1] = solved; break;
            case '-' :  solved = ( v1-v2 );  evaluation_stk[++x1] = solved; break;
            case '*' :  solved = ( v1*v2 );  evaluation_stk[++x1] = solved; break;
            case '/' :  solved = ( v1/v2 );  evaluation_stk[++x1] = solved; break;
            case '^' :  solved = Math.pow( v1 , v2 );  evaluation_stk[++x1] = solved; break;
        }
    }

    public void evaluate_prefix( String exp )
    {
        int el = exp.length();
        char c;
        double v1=-1,v2=-1;
        evaluation_stk = new double[el];
        x1 = -1;
        for( int i=el-1 ; i>=0 ; i-- )
        {
            c = exp.charAt(i);
            if( '0'<=c && c<='9' )
            {   evaluation_stk[++x1] = (int)c-48;  }
            else
            {
                v1 = (int)evaluation_stk[x1--];
                v2 = (int)evaluation_stk[x1--];   
                evaluate( v1, v2, c );
            }
        }
        System.out.println("POSTFIX EVALUATION DONE\nVALUE = "+evaluation_stk[0]);
    }

    public void evaluate_postfix( String exp )
    {
        int el = exp.length();
        char c;
        double v1=-1,v2=-1;
        evaluation_stk = new double[el];
        x1 = -1;
        for( int i=0 ; i<el ; i++ )
        {
            c = exp.charAt(i);
            if( '0'<=c && c<='9' )
            {   evaluation_stk[++x1] = (int)c-48;  }
            else
            {
                v2 = (int)evaluation_stk[x1--];
                v1 = (int)evaluation_stk[x1--];
            }
            evaluate( v1, v2, c );
        }
        System.out.println("PREFIX EVALUATION DONE\nVALUE = "+evaluation_stk[0]);
    }
}

public class main_post_pre_fix
{
    public static void main( String[] args)
    {
       Scanner sc = new Scanner(System.in);
       prefix_postfix o = new prefix_postfix();
       String infix,exp;
       int ch;
       while ( true )
       {
          System.out.println("Enter choice\n1.COVERT INFIX INTO POSTFIX, PREFIX\n2.EVALUATE POSTFIX EXPRESSION\n3.EVALUATE PREFIX EXPRESSION\n4.EXIT\n");
          ch = sc.nextInt();
          /*
            + => adition
            - => substraction
            * => multiplication
            / => division
            ^ => power
           */
          switch( ch )
          {
            case 1 : System.out.println("Enter the INFIX expression\n"); infix = sc.next(); System.out.println("POSTFIX EXPRESSION : "+o.postfix_func(infix));  System.out.println("PREFIX EXPRESSION : "+o.prefix_func(infix));  break;
            case 2 : System.out.println("Enter the POSTFIX expression\n"); exp = sc.next(); o.evaluate_postfix(exp); break;
            case 3 : System.out.println("Enter the PREFIX expression\n"); exp = sc.next(); o.evaluate_prefix(exp); break;
            case 4 : System.out.println("\nExit from program"); sc.close(); return;
          }
       }
    }
}