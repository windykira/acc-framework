package com.acc.schedule;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * Created by windy on 2018/3/29.
 */
public class MyJob implements Job{

    public void execute(JobExecutionContext context) throws JobExecutionException {
        System.out.println("定时任务执行了。。。。");
    }
}
