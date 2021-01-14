package com.example.demo.config;




import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;




@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private UserDetailsService userDetailsService;


    @Bean
    public PasswordEncoder passwordEncoder() {
    	
        return new BCryptPasswordEncoder();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }
    
    
    
//  @Bean
//  public PasswordEncoder passwordEncoder() {
//  	
//      return new BCryptPasswordEncoder();
//  }
//
//  @Autowired
//  public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
//      auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//  }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//tat xac thuc token ở PostMapping
    	 http.csrf().disable();
    	 
    	 // Các trang không yêu cầu login
         http.authorizeRequests().antMatchers("/", "/login", "/logout").permitAll();
  
         // Trang /userInfo yêu cầu phải login với vai trò ROLE_USER hoặc ROLE_ADMIN.
         // Nếu chưa login, nó sẽ redirect tới trang /login.
         http.authorizeRequests().antMatchers("/users").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN','ROLE_MANAGER')");
  
         // Trang chỉ dành cho ADMIN
         http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");
         
  
         // Khi người dùng đã login, với vai trò XX.
         // Nhưng truy cập vào trang yêu cầu vai trò YY,
         // Ngoại lệ AccessDeniedException sẽ ném ra.
         http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
    	 
    	 
        http
//            .authorizeRequests()
//                  .antMatchers("/").permitAll()
//              //    .antMatchers("/**").permitAll()      
//                 
//                  //.antMatchers(HttpMethod.GET,"/").permitAll()
//                //.antMatchers(HttpMethod.POST,"/").permitAll()
//               
//             // .anyRequest().authenticated() 
//              
//              .antMatchers("/admin/**").hasRole("ADMIN")
//               .antMatchers("/admin/products").hasRole("ADMIN")
//             .antMatchers(HttpMethod.GET,"/admin").hasRole("ADMIN")
//             .antMatchers("/admin").access("hasRole('ADMIN')")
//             //  .anyRequest().authenticated()
//                .and()
            .formLogin()
                .loginPage("/signin")
                .usernameParameter("emailSignIn")
                .passwordParameter("passwordSignIn")
                .defaultSuccessUrl("/")
                .failureUrl("/signin?error")
                .and()
            .logout()                                                                
                .logoutUrl("/logout")                                                 
                .logoutSuccessUrl("/signin")                                                                             
                .invalidateHttpSession(true)                                                                                                
                .deleteCookies("")                                       
                .and()           
            .exceptionHandling()
                .accessDeniedPage("/403");
    }

}