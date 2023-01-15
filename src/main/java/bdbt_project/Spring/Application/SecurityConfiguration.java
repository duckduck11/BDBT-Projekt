package bdbt_project.Spring.Application;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("user")
                .password("user")
                .roles("USER")
                .and()
                .withUser("admin")
                .password("admin")
                .roles("ADMIN");
    }
    @Bean
    public PasswordEncoder getPasswordEncoder() { return NoOpPasswordEncoder.getInstance();
    }
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/", "/index").permitAll()
                .antMatchers("/resources/static/**").permitAll()
                .antMatchers("/main").authenticated()
                .antMatchers("/main_admin").access("hasRole('ADMIN')")
                .antMatchers("/main_user").access("hasRole('USER')")
                .antMatchers("/user/ogrody_botaniczne").access("hasRole('USER')")
                .antMatchers("/admin/ogrody_botaniczne").access("hasRole('ADMIN')")
                .antMatchers("/edit_ogrody_botaniczne/*").access("hasRole('ADMIN') or hasRole('USER')")
                .antMatchers("/new_ogrody_botaniczne").access("hasRole('ADMIN')")
                .antMatchers("/update_ogrody_botaniczne").access("hasRole('ADMIN') or hasRole('USER')")
                .antMatchers("/delete_ogrody_botaniczne/*").access("hasRole('ADMIN')")
                .antMatchers("/save_ogrody_botaniczne").access("hasRole('ADMIN')")
                .antMatchers("/user/ogrody").access("hasRole('USER')")
                .antMatchers("/admin/ogrody").access("hasRole('ADMIN')")
                .antMatchers("/edit_ogrody/*").access("hasRole('ADMIN') or hasRole('USER')")
                .antMatchers("/new_ogrody").access("hasRole('ADMIN')")
                .antMatchers("/update_ogrody").access("hasRole('ADMIN') or hasRole('USER')")
                .antMatchers("/delete_ogrody/*").access("hasRole('ADMIN')")
                .antMatchers("/save_ogrody").access("hasRole('ADMIN')")
                .antMatchers("/admin/pracownicy").access("hasRole('ADMIN')")
                .antMatchers("/edit_pracownicy").access("hasRole('ADMIN')")
                .antMatchers("/new_pracownicy").access("hasRole('ADMIN')")
                .and()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/main")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/index")
                .logoutSuccessUrl("/index")
                .permitAll();
    }
}