package question;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Description: TODO
 *
 * @author wangyang
 * @since 2019/2/13
 */

public class Test
{


    public static void main(String[] args) throws InterruptedException
    {
        int n = 1;
        class Nu implements Runnable{

            @Override
            public void run() {
                System.out.println(n);
            }
        }
        PrintNumber printNumber = new PrintNumber();
        Thread t1 = new Thread(()->{
            printNumber.print1();
        });
        Thread t2 = new Thread(()->{
            printNumber.print2();
        });
        Thread t3 = new Thread(()->{
            printNumber.print3();
        });
        t1.start();
        t2.start();
        t3.start();
    }
}

class Producer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Producer : Produced Item " + i);
            Thread.yield();
        }
    }
}

class Consumer extends Thread
{
    public void run()
    {
        for (int i = 0; i < 5; i++)
        {
            System.out.println("I am Consumer : Consumed Item " + i);
            Thread.yield();
        }
    }
}

class PrintNumber implements Runnable{

    private  int n = 1;

    private Lock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();
    @Override
    public  void run() {
        try {
            lock.lock();
            while (n<=100){

                System.out.println(Thread.currentThread().toString()+":"+n);
                n++;
                condition.signalAll();
                condition.await();
            }
            condition.signalAll();
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }

    public synchronized void print1(){
        while (n<=100){
            while (n % 3 != 1){
                try {
                    this.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().toString()+":"+n);
            n++;
            this.notifyAll();
        }
    }

    public synchronized void  print2() {
        while (n<=100){
            while (n % 3 != 2){
                try {
                    this.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
            System.out.println(Thread.currentThread().toString()+":"+n);
            n++;
            this.notifyAll();
        }
    }

    public synchronized void print3() {
        while (n<=100){
            while (n % 3 != 0){
                try {
                    this.wait();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().toString()+":"+n);
            n++;
            this.notifyAll();
        }
    }
}