package dbernat.it.springmvc.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Aspect
public class ControllerAuditor
{
    @Around("execution(* dbernat.it.springmvc.controller.*.*(..))")
    public Object audit(ProceedingJoinPoint jp) throws Throwable
    {
        String methodName = jp.getSignature().toShortString();
        log.info("Call to {}", methodName);
        Object obj = jp.proceed();
        log.info("Method called successfully: {} ", methodName);
        return obj;
    }
}
