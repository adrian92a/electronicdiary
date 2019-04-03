package pl.javastart.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {


    @Qualifier("dataSource")
    @Autowired
    private DataSource dataSource;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/chechkmarksbyteacher").hasAnyAuthority("ROLE_TEACHER")
                .antMatchers("/insertmarks").hasAnyAuthority("ROLE_TEACHER")
                .antMatchers("/checkmarks").hasAnyAuthority("ROLE_PUPIL")
                .anyRequest().permitAll()
            .and()
                .csrf().disable()
                .headers().frameOptions().disable()
            .and()
                .formLogin()
                .loginPage("/loginBySpring")
                .usernameParameter("email")
                .passwordParameter("password")
                .failureUrl("/loginBySpring?status=error")
                .loginProcessingUrl("/user/loggedIn")
                .defaultSuccessUrl("/index")
                .and()
                .logout()
                .logoutUrl("/user/logout")
                .logoutSuccessUrl("/index")
                .invalidateHttpSession(true)
        ;

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("SELECT u.email, u.password_hash, 1 FROM user u WHERE u.email = ? ")
                .authoritiesByUsernameQuery("SELECT u.email, r.role_name " +
                        "FROM user u " +
                        "JOIN user_role ur ON u.user_id = ur.user_id " +
                        "JOIN role r ON ur.role_id = r.role_id " +
                        "WHERE u.email = ?")
                .passwordEncoder(passwordEncoder)
                ;
    }


}
