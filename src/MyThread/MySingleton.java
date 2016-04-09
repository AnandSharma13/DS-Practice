package MyThread;

/**
 * Created by Anand on 4/3/2016.
 */
public class MySingleton {

    private static MySingleton instance;


    //method synchronization
    private static synchronized MySingleton getInstance() {
        if (instance == null)
            instance = new MySingleton();
        return instance;
    }

    //block synchronization
    private static MySingleton getInstanceBlock() {
        synchronized (instance) {
            if (instance == null)
                instance = new MySingleton();
            return instance;
        }
    }
}
