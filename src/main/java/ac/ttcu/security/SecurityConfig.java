package ac.ttcu.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    private DataSource dataSource;

    @Autowired
    SecurityConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/auth/login").permitAll()
                .antMatchers("/auth/signUp").hasAnyAuthority("ADMIN")
                .antMatchers("/api/common").hasAnyAuthority("STUDENT", "TEACHER")
                .antMatchers("/api/student").hasAnyAuthority("STUDENT")
                .antMatchers("/api/teacher").hasAnyAuthority("TEACHER")
                .anyRequest().authenticated()
                .and()
                .formLogin().loginPage("/auth/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("TTCU_MASTER")
                .password("123")
                .roles("MASTER");
        auth.jdbcAuthentication().dataSource(this.dataSource)
                .usersByUsernameQuery("select * from users where username= ? and password=?")
                .authoritiesByUsernameQuery("select * from authorities where username= ?");

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }
}
