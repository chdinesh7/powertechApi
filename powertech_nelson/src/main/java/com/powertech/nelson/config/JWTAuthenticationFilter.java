package com.powertech.nelson.config;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.powertech.nelson.entity.EmployeeRegistration;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;


import static com.powertech.nelson.config.SecurityConstants.HEADER_STRING;
import static com.powertech.nelson.config.SecurityConstants.SECRET;
import static com.powertech.nelson.config.SecurityConstants.TOKEN_PREFIX;
import static com.powertech.nelson.config.SecurityConstants.EXPIRATION_TIME;
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {  
	private AuthenticationManager authenticationManager;
    public JWTAuthenticationFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }
    @Override
    public Authentication attemptAuthentication(HttpServletRequest req,
                                                HttpServletResponse res) throws AuthenticationException {
        try {
            EmployeeRegistration creds = new ObjectMapper()
                    .readValue(req.getInputStream(), EmployeeRegistration.class);
            return authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            creds.getUsername(),
                            creds.getPassword(),
                            new ArrayList<>())
            );
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        String token = Jwts.builder()
                .setSubject(((User) auth.getPrincipal()).getUsername())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        String bearerToken=TOKEN_PREFIX+"@@"+token;
        res.getWriter().write(bearerToken);
        res.addHeader(HEADER_STRING, TOKEN_PREFIX + token);
    }
}
