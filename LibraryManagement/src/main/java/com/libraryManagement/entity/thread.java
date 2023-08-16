package com.libraryManagement.entity;


//shared resource
class Factorial
{

    synchronized void fact(int n)
    {
        int f=1;
        for(int i=1;i<=n;i++)
        {
            f=f*i;

            try {
                Thread.sleep(400);

            }catch (Exception e) {
                System.out.println(e.getMessage());
            }

            System.out.println(Thread.currentThread().getName()+" :Factorial of given number:"+n+" is:"+ f);
        }
    }

}

