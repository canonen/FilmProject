package com.FilmProject.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.FilmProject.model.KullaniciEntity;
import com.FilmProject.service.KullaniciService;
import com.FilmProject.utility.JwtUtil;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil; 
	private final KullaniciService kullaniciService;
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		
		String jwt = null;
		if (request.getCookies() == null) {
			filterChain.doFilter(request, response);
			return;
		}
		
		for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals(JwtUtil.JWT_COOKIE_KEY)) {
				jwt = cookie.getValue();
				break;
			}
		}
		
		if ((jwt == null || request.getServletPath().startsWith("/api/auth"))) {
			filterChain.doFilter(request, response);
			return;
		}
		
		String userName = jwtUtil.extractUsername(jwt);
		
		if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {
			KullaniciEntity kullanici = kullaniciService.findByKullaniciAdi(userName);
			
			if (jwtUtil.isTokenValid(jwt, kullanici)) {
				
				UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(kullanici, null, List.of(new SimpleGrantedAuthority("ROLE_" + kullanici.getRole().name())));
				authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
				
				SecurityContextHolder.getContext().setAuthentication(authToken);
				
			}
		}
		
		filterChain.doFilter(request, response);
	}

}
