package com.boz.bdmin.project.test;

import com.boz.bdmin.common.manager.AsyncManager;
import com.boz.bdmin.common.manager.factory.AsyncFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author boz
 * @date 2019/6/5
 */
public class Test {
    public static void main(String[] args) {
        // 1:存放日志的队列

        // 2:线程异步消费队列

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss SSS");
        System.out.println("1"+sdf.format(new Date()));

        AsyncManager.me().execute(AsyncFactory.recordLog());

        System.out.println("------------------------");
    }
}
