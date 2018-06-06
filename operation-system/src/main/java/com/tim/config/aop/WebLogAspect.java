package com.tim.config.aop;

import com.alibaba.fastjson.JSON;
import com.tim.syslog.SysControllerLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;

/**
 * @description: AOP统一处理WEB请求日志
 * @author: lizhiming
 * @date: 2018/6/6 16:52
 */
@Aspect
@Component
@Slf4j
public class WebLogAspect {
    /**
     * Controller层切点
     */
    @Pointcut("@annotation(com.tim.syslog.SysControllerLog)")
    public void controllerAspect(){
    }

    /**
     * 前置通知 用于拦截Controller层记录用户的操作
     * @param point
     */
    @Before("controllerAspect()")
    public void doBefore(JoinPoint point) {

        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();

        long beginTime = System.currentTimeMillis();

        MethodSignature signature = (MethodSignature) point.getSignature();
        //获取被拦截的方法
        Method method = signature.getMethod();
        //获取被拦截的方法名
        String methodName = method.getName();
        //获取请求ip
        String ip = request.getRemoteAddr();

        //获取用户请求方法的参数并序列化为JSON格式字符串
        String params = "";
        if (point.getArgs() != null && point.getArgs().length > 0) {
            for (int i = 0; i < point.getArgs().length; i++) {
                params += JSON.toJSONString(point.getArgs()[i]) + ";";
            }
        }
        System.out.println("异常方法:" + (point.getTarget().getClass().getName() + "." + point.getSignature().getName() + "()"));
        System.out.println("请求人: + user.getName()");
        System.out.println("请求IP:" + ip);
        System.out.println("请求参数:" + params);
        try {
            System.out.println("方法描述:" + getControllerMethodDescription(point));
        } catch (Exception ex){
            log.info("【WEB请求日志】获取请求方法描述异常：" + ex.getMessage());
        }
        /*List<User> users = userService.getAllUser();
        System.out.println("users:" + JSON.toJSONString(users));*/
        long costMs = System.currentTimeMillis() - beginTime;
        log.info("【WEB请求日志】切入点请求方法名称：{}  耗时：{}ms", methodName, costMs);
        log.info("【WEB请求日志】请求方法参数：" + JSON.toJSONString(params));
    }

    /**
     * 获取注解中对方法的描述信息 用于Controller层注解
     *
     * @param joinPoint 切点
     * @return 方法描述
     * @throws Exception
     */
    public static String getControllerMethodDescription(JoinPoint joinPoint) throws Exception {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String description = "";
        for (Method method : methods) {
            if (method.getName().equals(methodName)) {
                Class[] clazzs = method.getParameterTypes();
                if (clazzs.length == arguments.length) {
                    description = method.getAnnotation(SysControllerLog.class).desc();
                    break;
                }
            }
        }
        return description;
    }
}
