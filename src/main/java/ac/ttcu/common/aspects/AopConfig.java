package ac.ttcu.common.aspects;

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
    public LoggerAspect loggingAspect(Environment env) {
        return new LoggerAspect(env);
    }
}
