package ac.ttcu.common.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;

@Configuration
@EnableAspectJAutoProxy
public class AopConfig {

    @Bean
    @Profile({"application"})
    public ExceptionHandlerAspect exceptionHandlerAspect(Environment env){return new ExceptionHandlerAspect(env);}
}
