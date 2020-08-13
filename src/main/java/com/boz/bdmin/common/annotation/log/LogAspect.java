package com.boz.bdmin.common.annotation.log;

import com.alibaba.fastjson.JSONObject;
import com.boz.bdmin.common.utils.ServletUtils;
import com.boz.bdmin.common.utils.StringUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;

/**
 * 操作日志记录处理
 * @author boz
 * @date 2019/6/5
 */
@Aspect
@Component
public class LogAspect {
    public static final Logger logger = LoggerFactory.getLogger(LogAspect.class);


    // 配置织入点
    @Pointcut("@annotation(com.boz.bdmin.common.annotation.log.Log)")
    public void logPointCut()
    {
    }


    /**
     * 前置通知 用于拦截操作
     *
     * @param joinPoint 切点
     */
    @AfterReturning(pointcut = "logPointCut()")
    public void doBefore(JoinPoint joinPoint)
    {
        handleLog(joinPoint, null);
    }


    /**
     * 拦截异常操作
     *
     * @param joinPoint
     * @param e
     */
    @AfterThrowing(value = "logPointCut()", throwing = "e")
    public void doAfter(JoinPoint joinPoint, Exception e)
    {
        handleLog(joinPoint, e);
    }



    protected void handleLog(final JoinPoint joinPoint, final Exception e)
    {
        try{
            // 获得注解
            Log controllerLog = getAnnotationLog(joinPoint);
            if (controllerLog == null)
            {
                return;
            }
            System.out.println(controllerLog);
            System.out.println(controllerLog.title());//获取log的title
            System.out.println(controllerLog.businessType().ordinal());//获取log的业务类型
            System.out.println(ServletUtils.getRequest().getRequestURI());//获取log的请求url
            // 设置方法名称
            String className = joinPoint.getTarget().getClass().getName();
            String methodName = joinPoint.getSignature().getName();
            System.out.println(className + "|" + methodName + "()"); //请求的类和方法

            Map<String, String[]> map = ServletUtils.getRequest().getParameterMap();
            String params = JSONObject.toJSONString(map);
            System.out.println(params);//请求的参数
            /**
             * 获取当前用户逻辑(自定义)
             */

            //记录请求成功
            if(e != null){
                //记录请求失败
                //错误日志
                String errorMsg = StringUtils.substring(e.getMessage(), 0, 2000);

            }

        }catch (Exception exp){
            exp.printStackTrace();
        }
        if(e != null){
            System.out.println("写异常日志");
        }else{
            System.out.println("写日志");
        }

    }


    /**
     * 是否存在注解，如果存在就获取
     */
    private Log getAnnotationLog(JoinPoint joinPoint) throws Exception
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            return method.getAnnotation(Log.class);
        }
        return null;
    }




}

