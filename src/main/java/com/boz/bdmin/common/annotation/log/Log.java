package com.boz.bdmin.common.annotation.log;

import com.boz.bdmin.common.constant.enums.BusinessType;
import com.boz.bdmin.common.constant.enums.OperatorType;

import java.lang.annotation.*;

/**
 * 自定义操作日志记录注解
 * @author boz
 * @date 2019/6/5
 */

@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Log {
    /** 模块 */
    String title() default "";

    /** 功能 */
    BusinessType businessType() default BusinessType.OTHER;

    /** 操作人类别 */
    OperatorType operatorType() default OperatorType.MANAGE;

    /** 是否保存请求的参数 */
    boolean isSaveRequestData() default true;
}
