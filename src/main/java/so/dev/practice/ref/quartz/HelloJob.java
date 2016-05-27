package so.dev.practice.ref.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.sql.Date;
import java.sql.Time;
import java.text.SimpleDateFormat;

/**
 * Created by melvin on 2016. 5. 9..
 */
public class HelloJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {

        String name = context.getJobDetail().getKey().getName();
        long time = System.currentTimeMillis();
        SimpleDateFormat dayTime = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String str = dayTime.format(new Date(time));

        System.out.println(name);
        System.out.println("Hello Quartz!");
        System.out.println(str);
    }
}
