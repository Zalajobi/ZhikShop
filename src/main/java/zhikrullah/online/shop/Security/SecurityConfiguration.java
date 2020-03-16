package zhikrullah.online.shop.Security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    private String[] PUBLIC_MATCHERS = {
        "/css/**",
            "/css/bootstrap/css/**",
            "/css/font/**",
            "/css/index/**",
            "/css/plugins/**",
            "/css/signup/**",
            "/fonts/Linearicons-Free-v1.0.0/**",
            "/js/**",
            "/login",
            "/register",
            "/zhik.ng",
            "/aboutus",
            "/contactus",
            "/addproduct",
            "/shippingaddress",
            "/js/bootstrap/js/**",
            "/js/plugin/**",
            "/Media/Image/Header/**",
            "/Media/Image/Home/**",
            "/Media/Image/Logo/**"
    };

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests().antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();
//        httpSecurity.csrf().disable().cors().disable()
        httpSecurity
                .formLogin().loginPage("/login").permitAll().defaultSuccessUrl("/zhik.ng").permitAll().and()
                .logout().logoutSuccessUrl("/login").deleteCookies("remember-me").permitAll().and().rememberMe().and().csrf().disable().cors().disable();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception
    {
        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select email as principal, password as credentials, true from user where email=?")
                .authoritiesByUsernameQuery("select user_email as principal, user_role as role from user_roles where user_email =?")
                .passwordEncoder(passwordEncoder()).rolePrefix("ROLE_");
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}