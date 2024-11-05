//package com.secondproject.tasks.TodoTasks.securityConfig;
//
//
//import java.util.Date;
//import java.util.function.Function;
//
//import javax.crypto.KeyGenerator;
//import javax.crypto.SecretKey;
//import java.util.*;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.io.Decoders;
//import io.jsonwebtoken.security.Keys;
//
//@Component
//public class JwtTokenGenerate {
//	
//	private String sKey = "";
//
//	public JwtTokenGenerate() {
//		try {
//			KeyGenerator KeyGen = KeyGenerator.getInstance("HmacSHA256");
//			SecretKey sk =  KeyGen.generateKey();
//			sKey = Base64.getEncoder().encodeToString(sk.getEncoded());
//			
//			
//		}catch(Exception e) {
//			throw new RuntimeException(e);
//		}
//	}
//	
//	public String getToken(Authentication authentication) {
//		
//		Map<String, Object>  claims = new HashMap<>();
//		
//		return Jwts.builder()
//				.claims()
//				.add(claims)
//				.subject(authentication.getName())
//				.issuedAt(new Date(System.currentTimeMillis()))
//				.expiration(new Date(System.currentTimeMillis() + 60*60*12))
//				.and()
//				.signWith(getKey())
//				.compact();
//		
//	}
//
//	private SecretKey getKey() {
//		byte[] keys = Decoders.BASE64.decode(sKey);
//		return Keys.hmacShaKeyFor(keys);
//	}
//
//	public String extractEmail(String email) {
//		return extractClaims(email, Claims::getSubject);
//	}
//	
//	private <T> T extractClaims(String token,Function<Claims,T> claimResolver) {
//		final Claims claims = extratAll	(token);
//		return claimResolver.apply(claims);
//	}
//	
//	private Claims extratAll(String token) {
//		return Jwts.parser()
//               .verifyWith(getKey())
//               .build().parseSignedClaims(token).getPayload();
//		}
//
//	public boolean validToken(String email, UserDetails user) {
//		final String userName = extractEmail(email);
//		return userName.equals(user.getUsername()) && !isTokenExpire(email);
//	}
//
//	public boolean isTokenExpire(String token) {
//		return extractExpireToken(token).before(new Date());
//	}
//
//	private Date extractExpireToken(String token) {
//		return extractClaims(token,Claims::getExpiration);
//	}
//}
