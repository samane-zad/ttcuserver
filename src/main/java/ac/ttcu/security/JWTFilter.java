package ac.ttcu.security;

import ac.ttcu.model.entity.table.User;
import ac.ttcu.model.service.dao.UserService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JWTFilter extends OncePerRequestFilter implements Filter {

    private final JWTUtils jwtUtils;
    private final UserService userService;

    public JWTFilter(JWTUtils jwtUtils, UserService userService) {
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token=httpServletRequest.getHeader("Authorization");

        if (!Objects.isNull(token)) {
            String username = jwtUtils.getUsername(token.trim());
            if (!Objects.isNull(username) && SecurityContextHolder.getContext().getAuthentication() == null) {
                User user = (User) userService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken userPassToken = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(userPassToken);
            }
        }
        httpServletResponse.setHeader("Access-Control-Allow-Origin", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Methods", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Headers", "*");
        httpServletResponse.setHeader("Access-Control-Allow-Credentials", "true");
        filterChain.doFilter(httpServletRequest, httpServletResponse);
    }
}
