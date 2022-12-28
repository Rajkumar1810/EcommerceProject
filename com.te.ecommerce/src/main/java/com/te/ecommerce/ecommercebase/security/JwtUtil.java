package com.te.ecommerce.ecommercebase.security;


import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;


@Component
public class JwtUtil {

	
	private String  secret;
	
//	6.Validate user name in token and database, expDate
	public boolean validToken(String token ,String username) {
		String  tokenUserName= getUsername(token);
		return(username.equals(tokenUserName) &&  !isTokenExp(token));
	}
	
//	5.Validate Exp Date
	public boolean isTokenExp(String token) {
		Date date =getEXDate(token);
		return date.before(new Date(System.currentTimeMillis()));
	}
	
	//4.Read user name and subject
    public String getUsername(String token) {
    	return getClaims(token).getSubject();
    }
	
//	3.Exp Date
	public  Date getEXDate(String token) {
		
		return getClaims(token).getExpiration();
		
	}
	
//	2.Read Claims
	public Claims getClaims(String token) {
		return Jwts.parser()
				.setSigningKey(secret.getBytes())
				.parseClaimsJws(token)
				.getBody();
		
	}
	
	//1.Generate Token
	 public  String generateToke(String subject) {
		 return Jwts.builder()
				 .setSubject(subject)
				 .setIssuer("Raj")
				 .setIssuedAt(new Date(System.currentTimeMillis()))
				 .setExpiration(new Date(System.currentTimeMillis()+TimeUnit.MINUTES.toMillis(15)))
				 .signWith(SignatureAlgorithm.HS512, secret.getBytes() )
				 .compact();
	 }
}
