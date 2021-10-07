package pl.danielkolban.musicweb.security.config;


import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.danielkolban.musicweb.user.UserService;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter  {

    private final UserService userService;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http
       .authorizeRequests()
                .antMatchers("/artists/new").hasAnyAuthority("ADMIN")
                .antMatchers("/artists/save").hasAnyAuthority("ADMIN")
                .antMatchers("/albums/new").hasAnyAuthority("ADMIN")
                .antMatchers("/albums/save").hasAnyAuthority("ADMIN")
                .antMatchers("/", "/**").permitAll()
                .anyRequest()
                .authenticated().and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userService)
                .passwordEncoder(bCryptPasswordEncoder);
    }


}

/*authorizeRequests()
               .antMatchers("/artists/new").hasAnyAuthority("ADMIN")
               .antMatchers("/artists/save").hasAnyAuthority("ADMIN")
               .antMatchers("/albums/new").hasAnyAuthority("ADMIN")
               .antMatchers("/albums/save").hasAnyAuthority("ADMIN")
               .antMatchers("/", "/**").permitAll()
               .and()
               .formLogin();*/