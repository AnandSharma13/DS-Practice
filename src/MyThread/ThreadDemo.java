package MyThread;

/**
 * Created by Anand on 3/12/2016.
 */
class MyThreadDemo extends Thread {


    public synchronized void run (){
        for(int i=0;i<10;i++){
            System.out.println(i);
        }
    }

}


public class ThreadDemo{

    public static void main(String [] args){

        MyThreadDemo t = new MyThreadDemo();
        Thread myt = new Thread(t);
        Thread myt2 = new Thread(t);
        myt2.start();
        myt.start();

    }


}