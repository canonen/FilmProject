package com.FilmProject.utility;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import com.FilmProject.model.KullaniciEntity;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

	private static final String SECRET_KEY = "secretKeyForJWTDeneme456788324112414124123123";
	public static final int EXPIRATION_SECONDS = 3600;
	public static final String JWT_COOKIE_KEY = "token";
	
	
	//imza anahtarını döndürür
	private Key getSigningKey() {
		byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
		return Keys.hmacShaKeyFor(keyBytes);
	}
	
	//JWT tokenini oluşturur ve döndürür.
	public String generateToken(KullaniciEntity user) {
		return Jwts.builder()
				.setSubject(user.getKullaniciAdi())
				.claim("rol", user.getRole().name())
				.claim("mail", user.getEmail())
				.setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(getSigningKey())
                .compact()
				;
				
				
	}
	
	public boolean isTokenValid(String token, KullaniciEntity user){
		String userName = extractUsername(token);
		return userName.equals(user.getKullaniciAdi()) && !isTokenExpired(token);
	}
	
	public boolean isTokenExpired(String token) {
		return extractAllClaims(token).getExpiration().before(new Date());
	}
	
	
	public String extractUsername(String token) {
		return extractAllClaims(token).getSubject();
	}
	
	public String extractRol(String token) {
		return (String) extractClaim(token, "rol", String.class);
	}
	
	public String extractMail(String token) {
		return (String) extractClaim(token, "mail", String.class);
	}
	
	private Object extractClaim(String token, String claimKey, Class claimValueClass) {
		Claims claims = extractAllClaims(token);
		return claims.get(claimKey, claimValueClass);
	}
	
	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder()
				.setSigningKey(getSigningKey())
				.build()
				.parseClaimsJws(token)
				.getBody()
				;
	}
}
