package indocyber.DemoAbsensi.utility;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public class JwtToken {
    private String SECRET_KEY = "Mizzou water, fafifufefo dont know what is dat";
    private String audience = "Attendance";

    private Claims getClaims(String token){
        JwtParser parser = Jwts.parser().setSigningKey(SECRET_KEY);
        Jws<Claims> signatureAndClaims = parser.parseClaimsJws(token);
        Claims claims = signatureAndClaims.getBody();
        return claims;
    }

    public String getUsername(String token){
        Claims claims = getClaims(token);
        return claims.get("username", String.class);
    }

    public String generateToken(String subject, String username, String secretKey, String role, String audience){
        JwtBuilder builder = Jwts.builder();
        builder = builder.setSubject(subject)
                .claim("username", username)
                .claim("role", role)
                .setIssuer("http://localhost:7171")
                .setAudience(audience)
                .signWith(SignatureAlgorithm.HS256, secretKey);
        return builder.compact();
    }

    public Boolean validateToken(String token, UserDetails userDetails){
        Claims claims = getClaims(token);
        String user = claims.get("username", String.class);
        String audience = claims.getAudience();
        return (user.equals(userDetails.getUsername()) && audience.equals(audience));
    }
}
