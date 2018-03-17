package thread;

/**
 * class Multi3 implements Runnable{
 public void run(){
 System.out.println("thread is running...");
 }

 public static void main(String args[]){
 Multi3 m1=new Multi3();
 Thread t1 =new Thread(m1);
 t1.start();
 }

 */

public class SimpleTread extends Thread {
    public void run(){
       System.out.println("i am running");
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleTread t = new SimpleTread();
        t.start();
        System.out.println(t.isAlive());

        SimpleTread t1 = new SimpleTread();
        t.start();
    }
}
