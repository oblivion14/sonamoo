package thread.runnable;

/**
 * Created by melvin on 2016. 4. 27..
 NOTE : Runnable 인터페이스를 구현한 클래스에서 run() 메소드를 호출하더라도 스레드는 생성되지 않음
 NOTE : 스레드 기능을 사용하려면 명시적으로 태스크(Task)를 스레디으 올리는 작업이 필요
 NOTE : Runnable 인터페이스를 구현한 클래스는 Thread 클래스의 start() 메소드 호출하여 스레드를 수행
 NOTE : Runnable 인터페이스의 run() 메소드는 반환값이 없으며 예외전파가 되지 않음
 */
public class RunnableHelloWorld implements Runnable{

    private int count = 0;

    public RunnableHelloWorld(int count){
        super();
        this.count = count;
    }

    public void run() {
        for( int i=0; i< count; i++){
            System.out.println("Hello World Count = " + i);
        }

    }
}
