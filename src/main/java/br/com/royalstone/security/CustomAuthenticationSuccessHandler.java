package br.com.royalstone.security; // Ou br.com.royalstone.handler;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.Collection;

@Component
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
                                        Authentication authentication) throws IOException, ServletException {

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        boolean isAdmin = authorities.stream()
                                     .anyMatch(a -> a.getAuthority().equals("ROLE_ADMIN"));

        // Assumindo que você também terá uma role para usuários normais, por exemplo "CLIENTE"
        boolean isClient = authorities.stream()
                                      .anyMatch(a -> a.getAuthority().equals("ROLE_CLIENTE"));

        if (isAdmin) {
            // REDIRECIONAR PARA A LISTA DE MINERAIS DO ADMIN
            response.sendRedirect("/admin/minerais"); // <--- ALTERADO AQUI!
        } else if (isClient) { // Se você tiver a role "CLIENTE" para usuários normais
            response.sendRedirect("/home"); // <--- Para a página inicial do cliente
        } else {
            // Fallback para outras roles ou roles desconhecidas
            response.sendRedirect("/default-dashboard");
        }
    }
}