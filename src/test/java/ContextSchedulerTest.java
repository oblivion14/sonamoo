import org.quartz.SchedulerException;
import so.dev.practice.context.model.Context;
import so.dev.practice.context.ContextRecognizer;

import java.util.ArrayList;

/**
 * Created by melvin on 2016. 5. 11..
 */
public class ContextSchedulerTest {


    public static void main(String[] args) throws SchedulerException {

        Context context1 = new Context();
        Context context2 = new Context();
        Context context3 = new Context();
        Context context4 = new Context();

        ArrayList<Context> contextArrayList = new ArrayList<>();

        context1.setId("CM-1-1-101");
        context1.setPeriod("0/3 * * * * ?");
        contextArrayList.add(context1);

        context2.setId("CM-1-1-102");
        context2.setPeriod("0/5 * * * * ?");
        contextArrayList.add(context2);

        context3.setId("CM-1-1-103");
        context3.setPeriod("0/7 * * * * ?");
        contextArrayList.add(context3);

        context4.setId("CM-1-1-104");
        context4.setPeriod("0/9 * * * * ?");
        contextArrayList.add(context4);

        ContextRecognizer recognizer = new ContextRecognizer();
        recognizer.executeContextRecognizer(contextArrayList);


    }
}
