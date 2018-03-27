package javaprac.singleton;

public class ThreadSafeSingleton {

    private static ThreadSafeSingleton instance;

    private ThreadSafeSingleton(){
        System.out.println("i am initialized");
    }
    public static ThreadSafeSingleton getInstance(){
        if(instance == null){
            instance = new ThreadSafeSingleton();
        }
        return instance;
    }

    public static void printMe(){
        System.out.println("its me threadsafe singleton");
    }

}
