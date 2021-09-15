package ac.ttcu.common.aop;

import ac.ttcu.common.Message;
import ac.ttcu.common.enumerations.Constants;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;

@Aspect
public class ExceptionHandlerAspect {
    private Logger logger= LoggerFactory.getLogger(ExceptionHandlerAspect.class);
    private Environment env;

    public ExceptionHandlerAspect(Environment env) {
        this.env = env;
    }

    @Around( "execution(* ac.ttcu.controller.*.*(..))")
    private Object handleExcp(ProceedingJoinPoint proceedingJoinPoint)
    {
        logger.info("Entered {} with values {}",proceedingJoinPoint.getClass(),
                ToStringBuilder.reflectionToString(proceedingJoinPoint.getArgs(), ToStringStyle.JSON_STYLE));
        try {
           return proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("Operation failed due to error {}",throwable.getMessage());
            Message message=new Message(HttpStatus.INTERNAL_SERVER_ERROR,Constants.OPERATION_FAILED.name());
            return message;
        }

    }

}
