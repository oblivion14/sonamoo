package so.dev.practice.ref.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by melvin on 2016. 5. 9..
 */
public class CronTriggerExample extends Thread{

    public static void main(String[] args) {


        System.out.println("dddd");
        JobDetail job = JobBuilder.newJob(HelloJob.class)
                .withIdentity("DummyTriggerName").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("DummyTriggerName")
                .withSchedule(
                        CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
                .build();

        Scheduler scheduler = null;
        try {
            scheduler = new StdSchedulerFactory().getScheduler();
            scheduler.start();
            scheduler.scheduleJob(job, trigger);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }
}
