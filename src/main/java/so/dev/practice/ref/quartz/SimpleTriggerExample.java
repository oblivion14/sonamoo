package so.dev.practice.ref.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * Created by melvin on 2016. 5. 9..
 */
public class SimpleTriggerExample {
    public static void main(String[] args) throws SchedulerException {
        JobDetail jobDetail = JobBuilder.newJob(HelloJob.class)
                .withIdentity("DummyTriggerName" , "Group1").build();

        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("DummyTriggerName" , "Group1")
                .withSchedule(
                        SimpleScheduleBuilder.simpleSchedule()
                                .withIntervalInSeconds(5).repeatForever())
                .build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
