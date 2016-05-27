package so.dev.practice.ref.quartz;

import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;

/**
 * Created by melvin on 2016. 5. 9..
 */
public class SimpleTrigger {
    Trigger trigger = TriggerBuilder
            .newTrigger()
            .withIdentity("DummyTriggerName" , "Group1")
            .withSchedule(
                    SimpleScheduleBuilder.simpleSchedule()
                    .withIntervalInSeconds(5).repeatForever())
            .build();


}
