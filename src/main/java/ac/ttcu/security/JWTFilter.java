package ac.ttcu.security;

import ac.ttcu.model.entity.table.User;
import ac.ttcu.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@Component
public class JWTFilter extends OncePerRequestFilter {

    private final JWTUtils jwtUtils;
    private final UserService userService;

    public JWTFilter(JWTUtils jwtUtils, UserService userService) {
        this.jwtUtils = jwtUtils;
        this.userService = userService;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
        String token=httpServletRequest.getHeader("Authorization");
        if (!Objects.isNull(token))
        {
            String username=jwtUtils.getUsername(token);
            if (!Objects.isNull(username) && SecurityContextHolder.getContext().getAuthentication()==null)
            {
                User user= (User) userService.loadUserByUsername(username);
                UsernamePasswordAuthenticationToken userPassToken=new UsernamePasswordAuthenticationToken(user,null,user.getAuthorities());
                SecurityContextHolder.getContext().setAuthentication(userPassToken);
            }
        }
        filterChain.doFilter(httpServletRequest,httpServletResponse);
    }
}
