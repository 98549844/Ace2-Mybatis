package com.aspect;

import com.models.Users;
import com.util.RandomUtil;
import com.util.TypeUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @Classname: MapperAspect
 * @Date: 2022/9/26 下午 12:06
 * @Author: kalam_au
 * @Description:
 */

@Aspect
@Component
public class MapperAspect {
    private static final Logger log = LogManager.getLogger(MapperAspect.class.getName());

    @Pointcut("@annotation(org.apache.ibatis.annotations.Mapper)")
    public void mapperAspect() {
    }



    @Before(value = "execution(* com.mapper.*.*(..))&&args(record)", argNames = "record")
    public void beforeUpdate(Users record) {
        String type = TypeUtil.getType(record);
        String mobile = RandomUtil.getRangeInt(1, 9999).toString();
        record.setMobile(mobile);
        System.out.println("com.mapper => beforeUpdate ... mobile: " + mobile);
        System.out.println("com.mapper => beforeUpdate ..." + type);
        System.out.println("com.mapper => beforeUpdate ..." + record.getUserAccount());
        System.out.println("com.mapper => beforeUpdate ..." + record.getVersion());
        System.out.println("com.mapper => beforeUpdate ..." + record.getLastUpdateDate());
        System.out.println("com.mapper => beforeUpdate ..." + record.getLastUpdatedBy());
    }


    @After("execution(* com.mapper.*.*(..))")
    public void afterUpdate() {
        System.out.println("com.mapper => afterUpdate ...");
    }


}

