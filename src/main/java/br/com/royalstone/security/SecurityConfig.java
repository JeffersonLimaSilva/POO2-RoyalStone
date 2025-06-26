package br.com.royalstone.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity; // <--- Importe e adicione esta anotação
import org.springframework.security.core.userdetails.UserDetailsService; // <--- Importe UserDetailsService
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // <--- ADICIONE ESTA ANOTAÇÃO AQUI
public class SecurityConfig {

    // Injetar o seu UserDetailService
    private final UserDetailService userDetailService; // <--- ADICIONE ESTE CAMPO

    public SecurityConfig(UserDetailService userDetailService) { // <--- ADICIONE ESTE CONSTRUTOR
        this.userDetailService = userDetailService;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .userDetailsService(userDetailService) // <--- ADICIONE ESTA LINHA: Diz ao Spring Security para usar seu UserDetailService
            .authorizeHttpRequests(auth -> auth
                // 1. RECURSOS ESTÁTICOS E PÁGINAS PÚBLICAS
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/", "/home", "/login", "/cadastro-cliente", "/processar-cadastro-cliente").permitAll()

                // 2. URLs PROTEGIDAS POR PAPEL (ROLE)
                .requestMatchers("/admin/**").hasRole("ADMIN")
                .requestMatchers("/cliente/**").hasRole("CLIENTE")

                // 3. QUALQUER OUTRA REQUISIÇÃO
                .anyRequest().authenticated()
            )
            .formLogin(form -> form
                .loginPage("/login")
                .defaultSuccessUrl("/admin/minerais", true) // Ou para uma outra página pós-login
                .failureUrl("/login?error=true") // Adicione um parâmetro para indicar erro no login
                .permitAll()
            )
            .logout(logout -> logout
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/login?logout")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll()
            );
            // Recomenda-se manter o CSRF habilitado para segurança em produção
            // .csrf(csrf -> csrf.disable());

        return http.build();
    }
}