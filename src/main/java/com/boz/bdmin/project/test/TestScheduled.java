package com.boz.bdmin.project.test;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 定时执行（定时器）
 * 比Timer精准
 * @author boz
 * @date 2019/6/5
 */
public class TestScheduled {
    public static void main(String[] args) {
        /**
         *
         */
        ScheduledThreadPoolExecutor scheduled = new ScheduledThreadPoolExecutor(2);
        scheduled.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println("-------");
            }
        }, 0, 40, TimeUnit.MILLISECONDS);//0表示首次执行任务的延迟时间，40表示每次执行任务的间隔时间，TimeUnit.MILLISECONDS执行的时间间隔数值单位
    }
}
