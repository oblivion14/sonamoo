package thread.extend;

/**
 * Created by melvin on 2016. 4. 28..
 * NOTE: Thread를 상속하는 방법
 * NOTE: Thread 클래스를 상속하면 다른 클래스를 상속 불가
 * NOTE: THread 클래스를 상속한 클래스는 start() 메소드를 호출하여 스레드를 수행
 * NOTE: Thread 클래스를 상속해서 만든 run()메소드는 반환값이 없으며 예외전파가 되지 않음
 */
public class HelloWorldThread extends Thread {
    private int count;
    public HelloWorldThread(int count){
        super();
        this.count = count;
    }

    public void run(){
        for(int i=0; i<count; i++){
            System.out.println("Hello World Count = " + i);
        }
    }
}


