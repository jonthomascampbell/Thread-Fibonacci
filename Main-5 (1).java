package cop2805;

import java.lang.*;

class recursive extends Thread { //The first solution uses recursion

    public static int fibonacci(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);

    }
    @Override
    public void run() // run() function execute algorithm and time how long it takes to get answer
    {
        long y = System.currentTimeMillis(); //To find milliseconds call
        int x = fibonacci(40);

        y = System.currentTimeMillis() - y;

        System.out.println("\nRecursion Thread found the answer: " +x+" in "+y+"ms" );
    }
}


class dynamic extends Thread { //Second method: uses dynamic programming to store the previous calculations rather than re-calculating them. This one looks like:

    public static int fibonacci(int n)
    { //algorithm as given - dynamic programming
        int v1 = 0, v2 = 1, v3 = 0;
        for(int i = 2; i <= n; i++){
            v3 = v1 + v2;
            v1 = v2;
            v2 = v3;
        }
        return v3;
    }


    @Override
    public void run()
    {
        int x = fibonacci(40);
        long y = System.currentTimeMillis();
        y = System.currentTimeMillis() - y;
        System.out.println("\nDynamic Thread found the answer: " +x+" in "+y+"ms" );
    }
}
public class Main
{
    public static void main(String[] args)
    {

        dynamic d = new dynamic();
        d.start();

        recursive r = new recursive();
        r.start();

    }
}



//Jon Campbell COP 2805C - Homework 8