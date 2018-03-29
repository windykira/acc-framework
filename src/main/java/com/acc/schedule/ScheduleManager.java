package com.acc.schedule;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

/**
 * 定时任务操作。
 * @author maxl。
 */
public class ScheduleManager {

    private static SchedulerFactory schedulerFactory = new StdSchedulerFactory();
    private static String JOB_GROUP_NAME = "DEFAULT_JOBGROUP_NAME";//默认任务名
    private static String TRIGGER_GROUP_NAME = "DEFAULT_TRIGGERGROUP_NAME";//默认触发器名

    @SuppressWarnings({"unchecked", "rawtypes"})
    public static void addJob(String jobName, String jobGroupName,
                              String triggerName, String triggerGroupName, Class jobClass, String cronTime) {
        try {
            Scheduler scheduler = schedulerFactory.getScheduler();
            // 任务名，任务组，任务执行类
            JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();
            // 触发器
            TriggerBuilder<Trigger> triggerBuilder = TriggerBuilder.newTrigger();
            // 触发器名,触发器组
            triggerBuilder.withIdentity(triggerName, triggerGroupName);
            triggerBuilder.startNow();
            // 触发器时间设定
            triggerBuilder.withSchedule(CronScheduleBuilder.cronSchedule(cronTime));
            // 创建Trigger对象
            CronTrigger trigger = (CronTrigger) triggerBuilder.build();
            // 调度容器设置JobDetail和Trigger
            scheduler.scheduleJob(jobDetail, trigger);
            // 启动
            if (!scheduler.isShutdown()) {
                scheduler.start();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
