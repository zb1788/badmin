package com.boz.bdmin.common.i18n;

import com.boz.bdmin.common.i18n.utils.LocalMessage;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 默认读取当前区域的配置文件,比如中文回去找messages_zh_CN.properties，如果找不到再找messages.properties
 * @author boz
 * @date 2019/6/4
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class I18nTest {

    @Autowired
    LocalMessage localMessage;


    @Test
    public void testI18n(){
        String msg = localMessage.getMessage("user.not.exists");
        System.out.println(msg);
    }
}
