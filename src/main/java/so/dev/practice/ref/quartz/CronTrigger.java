package so.dev.practice.ref.quartz;

import org.quartz.CronScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

/**
 * Created by melvin on 2016. 5. 9..
 */
public class CronTrigger {
    Trigger trigger = TriggerBuilder
            .newTrigger()
            .withIdentity("DummyTriggerName" , "Group1")
            .withSchedule(
                    CronScheduleBuilder.cronSchedule("0/5 * * * * ?"))
            .build();
}
