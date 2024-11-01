package com.ecommerce_backend.config;

import java.util.Date;
import javax.crypto.SecretKey;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtProvider {
	
    // You should ensure the SECRET_KEY is at least 256 bits.
    private static final String SECRET_KEY = "your-very-secure-and-very-long-secret-key-here"; // Replace with your secure key
    private final SecretKey key;

    public JwtProvider() {
        // Use the key securely with HMAC-SHA256
        this.key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes()); 
    }
	
    public String generateToken(Authentication auth) {
        return Jwts.builder()
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + 846000000)) // Set expiration time
                .claim("email", auth.getName())
                .signWith(key)
                .compact();
    }
	
    public String getEmailFromToken(String jwt) {
        // Ensure jwt is in the correct format
        if (jwt.startsWith("Bearer ")) {
            jwt = jwt.substring(7); // Remove "Bearer " prefix
        }

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
		
        return claims.get("email", String.class); // Using type-safe method to get email
    }
}
