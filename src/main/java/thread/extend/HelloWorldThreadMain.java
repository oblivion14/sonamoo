package thread.extend;

/**
 * Created by melvin on 2016. 4. 28..
 */
public class HelloWorldThreadMain {
    public static void main(String[] args) {
        int count = 5;
        Thread helloWorldThread =
                new HelloWorldThread(count);
        helloWorldThread.start();
    }
}
