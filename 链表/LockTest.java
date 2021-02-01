package 链表;

import java.util.Date;

public class LockTest {
    private static String obj1 = "资源1";
    private static String obj2 = "资源2";

    public static void main(String[] args) {
        LockTest lockTest = new LockTest();
        Lock1 lock1 = lockTest.new Lock1();
        Lock2 lock2 = lockTest.new Lock2();
        new Thread(lock1).start();
        new Thread(lock2).start();
    }

    class Lock1 implements Runnable{

        @Override
        public void run() {
            while(true){
                synchronized (LockTest.obj1){
                    System.out.println(new Date().toString() + " LockA 锁住 obj1");
                    try {
                        Thread.sleep(3000); // 此处等待是给B能锁住机会
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (LockTest.obj2){
                        System.out.println(new Date().toString() + " LockA 锁住 obj2");
                    }
                }
            }
        }
    }

    class Lock2 implements Runnable{

        @Override
        public void run() {
            while(true){
                synchronized (LockTest.obj2){
                    System.out.println(new Date().toString() + " LockB 锁住 obj2");
                    try {
                        Thread.sleep(3000); // 此处等待是给B能锁住机会
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (LockTest.obj1){
                        System.out.println(new Date().toString() + " LockB 锁住 obj1");
                    }
                }
            }
        }
    }
}
