package uz.ulugbek.jwtdemo.config;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Serializable;

/**
 * Author: Ulug'bek Ro'zimboyev  <ulugbekrozimboyev@gmail.com>
 * Date: 03.06.2020 11:15
 */
@Component
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, Serializable {

    private static final long serialVersionUID = -7858869558953243875L;

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException e) throws IOException {
        response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized");
    }

}
