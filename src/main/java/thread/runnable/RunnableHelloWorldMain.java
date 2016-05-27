package thread.runnable;

/**
 * Created by melvin on 2016. 4. 27..
 */
public class RunnableHelloWorldMain {
    public static void main(String[] args) {
        int count = 5;
        Thread helloWorldThread =
                new Thread(new RunnableHelloWorld(count));
        helloWorldThread.start();
    }
}
