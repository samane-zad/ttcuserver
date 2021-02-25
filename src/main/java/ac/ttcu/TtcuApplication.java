package ac.ttcu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TtcuApplication {

    @Value("${server.port}")
    private static String port;

    public static void main(String[] args) {

        SpringApplication.run(TtcuApplication.class, args);
    }

}
