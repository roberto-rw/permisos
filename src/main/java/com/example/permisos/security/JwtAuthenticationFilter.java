package com.example.permisos.security;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter{
    @Autowired
    private JWTUtils jwtUtil;
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authorizationHeader = request.getHeader("Authorization");

        String jwt = null;

        if (StringUtils.hasText(authorizationHeader) && authorizationHeader.startsWith("Bearer ")) {
            jwt = authorizationHeader.substring(7);
        }

        System.out.println("Token: " + jwt);

        if (!jwtUtil.validateToken(jwt)) {
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
            System.out.println("ERROR: Token invalido");
            return;
        }

        String role = jwtUtil.extractParameterFromToken(jwt, "rol");

        if(!(role.equals("PACIENTE"))){
            System.out.println("ERROR: La peticion no es de un paciente");
            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
            return;
        }
        String nssToken = jwtUtil.extractParameterFromToken(jwt, "nss");
        String nssFromBody = null;

        // Parsea el JSON del cuerpo de la solicitud y obtén el NSS
        //JsonObject requestBody = JsonParser.parseReader(request.getReader()).getAsJsonObject();


//        if (requestBody.has("nss")) {
//            nssFromBody = requestBody.get("nss").getAsString();
//        }
//
//        System.out.println("NSS del body: " + nssFromBody);
//        System.out.printf("NSS del token: " + nssToken);
//
//        if (nssFromBody == null || !nssFromBody.equals(nssToken)) {
//            System.out.println("ERROR: El NSS en el token no coincide con el enviado en el cuerpo de la solicitud");
//            response.sendError(HttpServletResponse.SC_FORBIDDEN, "Forbidden");
//            return;
//        }
        filterChain.doFilter(request, response);
    }
}
