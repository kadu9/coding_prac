package threads;

public class ThreadUsingRunnableInterface implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        ThreadUsingRunnableInterface t= new ThreadUsingRunnableInterface();
        Thread t1= new Thread(t);
        t1.start();
    }
}
