package ac.ttcu.common.aspects;

import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    Logger logger = LoggerFactory.getLogger(LoggerAspect.class);
    private final Environment env;

    public LoggerAspect(Environment env) {
        this.env = env;
    }

//
//    @Pointcut("execution( * ac.ttcu.controller.*.*(..)) || execution(* ac.ttcu.model.*.*.*(..))")
//    public void applicationPackagePointcut() {
//        // Method is empty as this is just a Pointcut, the implementations are in the advices.
//    }
//
////    @Pointcut("execution( * ac.ttcu.controller.*(..))")
////    public void  applicationRestPointcut() {
////        // Method is empty as this is just a Pointcut, the implementations are in the advices.
////    }
//
//    @AfterThrowing(pointcut = "applicationPackagePointcut()", throwing = "e")
//    public void logAfterThrowing(JoinPoint joinPoint, Throwable e) {
//
//            logger.error("Exception in {}.{}() with cause = \'{}\' and exception = \'{}\'", joinPoint.getSignature().getDeclaringTypeName(),
//                    joinPoint.getSignature().getName(), e.getCause() != null ? e.getCause() : "NULL", e.getMessage(), e);
//    }
//
//
//    @Around("applicationPackagePointcut()")
//    public Object logBeforePointCut(ProceedingJoinPoint joinPoint) throws Throwable {
//        logger.debug("Enter: {}.{}() with argument[s] = {}\n", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName(), Arrays.toString(joinPoint.getArgs()));
//
//        Object pointCutResult=joinPoint.proceed();
//
//        logger.debug("Exit: {}.{}() with result = {}\n", joinPoint.getSignature().getDeclaringTypeName(),
//                joinPoint.getSignature().getName(), pointCutResult);
//        return pointCutResult;
//    }
}
