package com.ijse.pos.security.jwt;

import java.security.Key;
import java.util.Date;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.UnsupportedJwtException;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class jwtUtils {
    @Value("${app.secret}")
    private String secret;
    
    @Value("${app.jwtExpiration}")
    private int jwtExpiration;

    private Key key(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(secret));
    }

    public String genetateJwtToken(Authentication authentication){
        UserDetails userDetails=(UserDetails)authentication.getPrincipal();
        return Jwts.builder()
        .setSubject(userDetails.getUsername())
        .setIssuedAt(new Date())
            .setExpiration(new Date(new Date().getTime() + jwtExpiration))
            .signWith(key(), SignatureAlgorithm.HS256)
            .compact();
        
    }

    public boolean validateJwtToken(String jwtToken){
        try {
            Jwts.parserBuilder().setSigningKey(key()).build().parse(jwtToken);
            return true;
        } catch (MalformedJwtException e) {
            System.out.println("Invalid token");
        }catch(ExpiredJwtException e){

 System.out.println("expired token");
        }catch(UnsupportedJwtException e){
            System.out.println("Unsupported token"); 

        }catch(IllegalArgumentException e){
             System.out.println("Blank token");

        }return false;

    }
    public String getUsernameFromJwtToken(String jwtToken){
        return Jwts.parserBuilder().setSigningKey(key()).build().parseClaimsJws(jwtToken).getBody().getSubject();
    }
    
    
}
