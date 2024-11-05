//package com.secondproject.tasks.TodoTasks.securityConfig;
//
//import java.io.IOException;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import com.secondproject.tasks.TodoTasks.ServiceImp.EmployeeLoginCheck;
//
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//
//@Component
//public class JwtFilter extends OncePerRequestFilter {
//	
//	@Autowired
//	private JwtTokenGenerate jwtToken;
//	
//	@Autowired
//	private EmployeeLoginCheck empCheck;
//	
//	  @Autowired
//	 Authentication authentication;
//	
//	@Override
//	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
//			throws ServletException, IOException {
//	       
//		  String authHeader =  request.getHeader("Authorization");
//		  String tokens =null;
//		  String email = null;
//		  if(authHeader != null && authHeader.startsWith("Bearer ")) {
//			  tokens = authHeader.substring(7);
//			  email =  jwtToken.extractEmail(tokens);
//		  }
//		  else {
//			  throw new RuntimeException(jwtToken.getToken(authentication));
//		  }
//		  if(email != null && SecurityContextHolder.getContext().getAuthentication() !=null) {
//			  UserDetails user = empCheck.loadUserByUsername(email);
//			  if(jwtToken.validToken(email, user)){
//			  UsernamePasswordAuthenticationToken userPasswordAuthentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//			  SecurityContextHolder.getContext().setAuthentication(userPasswordAuthentication);
//			  }
//		  }
//		  filterChain.doFilter(request, response);
//	}
//
//}
