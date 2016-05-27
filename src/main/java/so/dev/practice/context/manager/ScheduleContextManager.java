package so.dev.practice.context.manager;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import so.dev.practice.context.model.Context;

import java.sql.Date;
import java.text.SimpleDateFormat;

/**
 * Created by melvin on 2016. 5. 10..
 */
public class ScheduleContextManager implements Job {

    public void execute(JobExecutionContext context) throws JobExecutionException {

        String address = ContextAddressManager.getINSTANCE().getAddress()
                + context.getJobDetail().getKey().getName();

        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = dayTime.format(new Date(time));

        System.out.println("Test : " + address + "    time : " + str);
    }
}
