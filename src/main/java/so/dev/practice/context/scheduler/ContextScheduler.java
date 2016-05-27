package so.dev.practice.context.scheduler;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import so.dev.practice.context.model.Context;
import so.dev.practice.context.manager.ScheduleContextManager;

import java.util.ArrayList;

/**
 * Created by melvin on 2016. 5. 9..
 * Note: 컨텍스트 별로 저장된 주기값을 참조하여 스케줄러를 구동시켜준다
 * NOTE : 1. 프로그램 구동시 존재하는 컨텍스트 리스트를 읽어 들여 컨텍스트의 스케쥴로 스케쥴러를 가동시킨다
 * NOTE : 2. 프로그램에 컨텍스트 추가시 기존에 돌고 있는 컨텍스트외에 추가로 가동시킨다.
   TOdo: DB에 있는 컨텍스트를 시간에 따라 조회하는것이 맞을지..
    Todo: 컨텍스트 내용을 다 가지고 있는것이 맞을지..
 */
public class ContextScheduler {

    String groupName = "Group1";

    public void executeScheduler(ArrayList<Context> contextArrayList) throws SchedulerException {

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();

        if(contextArrayList != null) {
            for (Context context : contextArrayList) {

                JobDetail job = JobBuilder.newJob(ScheduleContextManager.class)
                        .withIdentity(context.getId(),groupName)
                        .build();

               Trigger trigger = TriggerBuilder
                        .newTrigger()
                        .withIdentity(context.getId(),groupName)
                        .withSchedule(
                                CronScheduleBuilder.cronSchedule(context.getPeriod()))
                        .build();

                scheduler.scheduleJob(job, trigger);

            }
        }
    }
}







