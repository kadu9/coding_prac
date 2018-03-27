package javaprac.singleton;

public class SingletonOperations {

    public static void main(String[] args){
        ThreadSafeSingleton threadSafeSingleton=ThreadSafeSingleton.getInstance();
        threadSafeSingleton.printMe();

    }
}
