package so.dev.practice.context;

import org.quartz.SchedulerException;
import so.dev.practice.context.model.Context;
import so.dev.practice.context.scheduler.ContextScheduler;

import java.util.ArrayList;

/**
 * Created by melvin on 2016. 5. 9..
 */
public class ContextRecognizer {

    public void executeContextRecognizer(ArrayList<Context> contextArrayList) throws SchedulerException {

        ContextScheduler scheduler = new ContextScheduler();
        scheduler.executeScheduler(contextArrayList);

    }
}
