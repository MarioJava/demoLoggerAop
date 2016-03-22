package com.marioaliaga.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Created by maliaga on 3/14/16.
 */

@Component
@Aspect
public class LoggerAOP {

   // @Before("execution(* com.marioaliaga.service.impl.PNRCheckInServiceImpl..*(..))")
    public void beforeGetByRecordAndLastName(JoinPoint joinPoint){
        System.out.println("**************** ADVISE AFTER *************************");
        System.out.println("metodo logAfter() esta corriendo!");
        System.out.println("metodo interceptado : " + joinPoint.getSignature().getName());
        System.out.println("joinPoint.getArgs() : " + Arrays.toString(joinPoint.getArgs()));
        System.out.println("****************** FIN ADVISE AFTER *********************");
    }

    @AfterReturning(
            pointcut = "execution(* com.marioaliaga.service.impl.PNRCheckInServiceImpl..*(..))",
            returning= "result")
    public void logAfterReturningGetByRecordAndLastName(JoinPoint joinPoint, Object result) {
        System.out.println("****************ADVISE AFTERRETURN********************");
        System.out.println("metodo logAfterReturning() esta corriendo!");
        System.out.println("metodo interceptado : " + joinPoint.getSignature().getName());
        System.out.println("El metodo retorna el valor : " + result);
        System.out.println("******************************************************");

    }

    @AfterThrowing(pointcut = "execution(* com.marioaliaga.service.impl.PNRCheckInServiceImpl..*(..))", throwing= "error")
    public void afterThrowingGetByRecordAndLastName(JoinPoint joinPoint, Throwable error){
            System.out.println("**************** ADVISE AfterThrowing ********************");
            System.out.println("metodo logAfterThrowing() esta corriendo!");
            System.out.println("metodo interceptado : " + joinPoint.getSignature().getName());
            System.out.println("joinPoint.getArgs() : " + Arrays.toString(joinPoint.getArgs()));
            System.out.println("Exception : " + error);
            System.out.println("Exception Get Message: " + error.getMessage());
            System.out.println("Exception Get Cause: " + error.getCause());
            System.out.println("***************** FIN ADVISE AfterThrowing *******************");
    }

}
