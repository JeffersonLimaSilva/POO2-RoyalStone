// br.com.royalstone.security.SecurityConfig.java
package br.com.royalstone.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    private final UserDetailService userDetailService;
    private final CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler;

    public SecurityConfig(UserDetailService userDetailService, CustomAuthenticationSuccessHandler customAuthenticationSuccessHandler) {
        this.userDetailService = userDetailService;
        this.customAuthenticationSuccessHandler = customAuthenticationSuccessHandler;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable()) // Reconsidere habilitar CSRF em produção
            .authorizeHttpRequests(auth -> auth
                // Permite acesso a recursos estáticos e páginas públicas
                .requestMatchers("/css/**", "/js/**", "/images/**", "/", "/home", "/login", "/cadastro-cliente", "/processar-cadastro-cliente").permitAll()

                // Regras de acesso por role
                .requestMatchers("/admin/**").hasRole("ADMIN") // Todas as URLs que começam com /admin/ exigem a role ADMIN
                .requestMatchers("/cliente/**").hasRole("CLIENTE") // Exemplo: URLs para clientes normais

                // Qualquer outra requisição deve estar autenticada
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .successHandler(customAuthenticationSuccessHandler) // Usa o handler personalizado
                .failureUrl("/login?error=true")
                .permitAll()
            )
            .logout(logout -> logout
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout=true")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            )
            .userDetailsService(userDetailService);

        return http.build();
    }
}