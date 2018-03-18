package threads;

public class ThreadCreationExtendThreadClass extends Thread {

    public void run(){
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
        }
    }

    public static void main(String[] args){
        ThreadCreationExtendThreadClass t= new ThreadCreationExtendThreadClass();
        ThreadCreationExtendThreadClass t1= new ThreadCreationExtendThreadClass();

        t.start();
        t1.start();

    }
}
