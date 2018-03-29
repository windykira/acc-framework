package com.acc.schedule;

import org.junit.Test;

/**
 * Created by windy on 2018/3/29.
 */
public class ScheduleManagerTest {

    @Test
    public void test(){

        ScheduleManager.addJob("triggerName","triggerGroupName",MyJob.class,"0 33 15 * * ?");
    }

    public static void main(String[] args) throws InterruptedException {

        ScheduleManager.addJob("triggerName","triggerGroupName",MyJob.class,"0 51 15 * * ?");
        Thread.sleep(2000);
        ScheduleManager.modifyJobTime("","","triggerName","triggerGroupName","0 52 15 * * ?");
    }
}
