package ac.ttcu.aop;

import ac.ttcu.common.Message;
import ac.ttcu.common.enumerations.Constants;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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

    @AfterThrowing(pointcut = "execution(* ac.ttcu.controller.*.*(..))",throwing = "err")
    private Message handleExcp(JoinPoint joinPoint,Throwable err)
    {
        Message message;
        switch (err.getMessage())
        {
            case "SIGN_UP_FAILED":
                message = new Message(HttpStatus.BAD_REQUEST, Constants.SIGN_UP_FAILED.name());
                break;
            default:
                message = new Message(HttpStatus.INTERNAL_SERVER_ERROR, Constants.OPERATION_FAILED.name());
        }
        return message;
    }

}
