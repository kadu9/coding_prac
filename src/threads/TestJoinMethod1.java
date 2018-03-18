package threads;
class TestJoinMethod1 extends Thread{
    public void run(){
        for(int i=1;i<=5;i++){
            try{
                Thread.sleep(500);
            }catch(Exception e){System.out.println(e);}
            System.out.println(currentThread().getName()+":"+i);
        }
    }
    public static void main(String args[]){
        TestJoinMethod1 t1=new TestJoinMethod1();
        TestJoinMethod1 t2=new TestJoinMethod1();
        TestJoinMethod1 t3=new TestJoinMethod1();
        t1.start();
        t1.setName("thread-1");
        t2.setName("thread-2");
        t3.setName("thread-3");
        t2.start();
        try{
            t2.join();
        }catch(Exception e){System.out.println(e);}


        t3.start();
    }
}