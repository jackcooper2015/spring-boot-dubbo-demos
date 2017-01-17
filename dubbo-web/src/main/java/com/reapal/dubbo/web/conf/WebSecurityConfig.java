package com.reapal.dubbo.web.conf;

import com.reapal.dubbo.web.interceptor.LoginSuccessHandler;
import com.reapal.dubbo.web.service.MyAuthenticationProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by jack-cooper on 2017/1/15.
 */
@Configurable
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)//允许进入页面方法前检验
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private MyAuthenticationProvider provider;//自定义验证
    @Autowired
    private LoginSuccessHandler loginSuccessHandler;
    @Autowired
    public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception{
    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //允许所有用户访问”/”和”/demo”和静态资源
//        http.authorizeRequests()
//                .antMatchers("/**", "/demo", "/login", "/**/*.css", "/**/*.js", "/image/**", "/admin/**").permitAll()
        //其他地址的访问均需验证权限
//                .anyRequest().authenticated()
//                .and().formLogin()
        //指定登录页是”/login”
//                .loginPage("/admin/login.html")
//                .failureUrl("/login?error")
//                .usernameParameter("username").passwordParameter("password")
//                .permitAll()
        //登录成功后可使用loginSuccessHandler()存储用户信息，可选。
//              .successHandler(loginSuccessHandler())
//                .and().logout()
        //退出登录后的默认网址是"/"
//                .logoutSuccessUrl("/").permitAll()
//                .invalidateHttpSession(true)
//                .and().csrf().disable();
//                .and()
////        登录后记住用户，下次自动登录
////        数据库中必须存在名为persistent_logins的表
//        .rememberMe().tokenValiditySeconds(1209600)
////        指定记住登录信息所使用的数据源
//        .tokenRepository(tokenRepository());

        loginSuccessHandler.setDefaultTargetUrl("/index");
            http
                .authorizeRequests()
                .antMatchers("/static/**","/register").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and()
                    .formLogin().loginPage("/login").defaultSuccessUrl("/index")
                    .successHandler(loginSuccessHandler)
                    .failureUrl("/login?error").permitAll()
                .and()
                    .logout().logoutSuccessUrl("/").permitAll()
                    .invalidateHttpSession(true)
                    .deleteCookies()
                .and()
                    .csrf().disable();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(provider);
    }
}
