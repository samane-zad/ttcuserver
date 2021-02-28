package ac.ttcu;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import java.net.InetAddress;


@SpringBootApplication
public class TtcuApplication implements InitializingBean {
    private static Logger logger = LoggerFactory.getLogger(TtcuApplication.class);

    private static String port;


    public static void main(String[] args)throws Exception {
        String ip=InetAddress.getLocalHost().getHostAddress().toString();
        SpringApplication ttcu=new SpringApplication(TtcuApplication.class);
        Environment env=ttcu.run(args).getEnvironment();
        port=env.getProperty("server.port");
        logger.info("\n----------------------------------------------------------\n\t" +
                        "Application TEHRAN TECHNICAL COLLEGES UNITY is running! Access URLs:\n\t" +
                        "Local: \t\thttp://localhost:{}\n\t" +
                        "External: \thttp://{}:{}\n\t" +
                        "Profile(s): \tapplication\n----------------------------------------------------------",port,ip,port);


    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
