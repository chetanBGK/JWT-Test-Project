package com.firstSpring.Security;

import com.firstSpring.Entity.User;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class JWTService {

    private  String secretKey="7p8Dp3WbBdrJeG8rXCP5LcVgG17ieijdUi6JXY3K3Cz0=";
    public String generateTocken(User user) {

        Map<String, Object> claims1 = new HashMap<>();

        return Jwts
                .builder()
                .setClaims(claims1) // Set custom claims
                .setSubject(user.getUserName()) // Set the subject (username)
                .setIssuer("DCB") // Set the issuer
                .setIssuedAt(new Date(System.currentTimeMillis())) // Set the issue date
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 15)) // 15 minutes expiration
                .signWith(generateKey()) // Sign the JWT
                .compact(); // Generate the token

    }

    private SecretKey generateKey() {
        byte[] decode = Decoders.BASE64.decode(secretKey);

        return Keys.hmacShaKeyFor(decode);

    }
}
