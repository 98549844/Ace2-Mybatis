package com.aspect;

import com.models.Users;
import com.util.TypeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @Classname: Crud
 * @Date: 2022/9/26 上午 10:50
 * @Author: kalam_au
 * @Description:
 */


@Aspect
@Component
public class ControllerAspect {
    //https://www.cnblogs.com/duoshou/articles/8033775.html
    private static final Logger log = LogManager.getLogger(ControllerAspect.class.getName());

//    @Aspect:          作用是把当前类标识为一个切面供容器读取
//    @Pointcut:        Pointcut是植入Advice的触发条件. 每个Pointcut的定义包括2部分,
//                      一是表达式, 二是方法签名. 方法签名必须是 public及void型.
//                      可以将Pointcut中的方法看作是一个被Advice引用的助记符,
//                      因为表达式不直观, 因此我们可以通过方法签名的方式为 此表达式命名.
//                      因此Pointcut中的方法只需要方法签名, 而不需要在方法体内编写实际代码.
//    @Around:          环绕增强, 相当于MethodInterceptor
//    @AfterReturning:  后置增强, 相当于AfterReturningAdvice, 方法正常退出时执行
//    @Before:          标识一个前置增强方法, 相当于BeforeAdvice的功能, 相似功能的还有
//    @AfterThrowing:   异常抛出增强, 相当于ThrowsAdvice
//    @After:           final增强, 不管是抛出异常或者正常退出都会执行

    //execution表达式
    //第一个*表示匹配任意的方法返回值,
    //第二个*表示所有controller包下的类,
    //第三个*表示所有方法, 第一个..表示任意参数个数
    @Pointcut("execution(public * com.controller.*.*(..))")
    public void controllerAspect() {
    }


    @Before("execution(* com.controller.*.*(..))")
    public void beforeUpdate() {
        System.out.println("com.controller => beforeUpdate ...");
    }


    @After("execution(* com.controller.*.*(..))")
    public void afterUpdate(JoinPoint jp) {
        System.out.println("com.controller => afterUpdate ..."/*+users.getUserAccount()*/);
    }

    @Around("execution(* com.controller.*.*(..))")
    public void aroundUpdate(ProceedingJoinPoint point) throws Throwable {
        Object[] args = point.getArgs();
        Object object = point.proceed(args);
        String type = TypeUtil.getType(object);
        System.out.println("aroundUpdate ..." + type);
        Users user = (Users) object;
        System.out.println("com.controller => aroundUpdate ..." + user.getUserAccount());
        System.out.println("com.controller => aroundUpdate ..." + user.getVersion());
        System.out.println("com.controller => aroundUpdate ..." + user.getLastUpdateDate());
    }
}

