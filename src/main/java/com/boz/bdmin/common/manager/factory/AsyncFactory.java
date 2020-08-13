package com.boz.bdmin.common.manager.factory;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;

/**
 * 异步工厂（产生任务用）
 * @author boz
 * @date 2019/6/5
 */
public class AsyncFactory {

    // 1:日志队列

    public static TimerTask recordLog(){
        return new TimerTask() {
            @Override
            public void run() {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
                System.out.println(sdf.format(new Date()));
            }
        };
    }
}
