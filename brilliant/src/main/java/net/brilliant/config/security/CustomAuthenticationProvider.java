/*package net.brilliant.config.security;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.ObjectFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Component;

import net.paramount.auth.domain.UserSecurityProfile;
import net.paramount.auth.entity.Authority;
import net.paramount.auth.service.AuthorizationService;
import net.paramount.common.CommonUtility;
import net.paramount.exceptions.NgepAuthException;
import net.paramount.framework.component.CompCore;
import net.paramount.global.GlobalConstants;

*//**
 * Created by aLeXcBa1990 on 24/11/2018.
 * 
 *//*
@Component(value="authenticationProvider")
public class CustomAuthenticationProvider extends CompCore implements AuthenticationProvider {
	*//**
	 * 
	 *//*
	private static final long serialVersionUID = -8355652678792800184L;

	@Inject
	ObjectFactory<HttpSession> httpSessionFactory;
	
	@Inject 
	private AuthorizationService authorizationService;

	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		Authentication authenticateResult = null;
		try {
			authenticateResult = authenticateProductive(authentication);
		} catch (Exception e) {
			log.error(e);
			authenticateResult = authenticateDevelopment(authentication);
		}

		if (null==authenticateResult) {
			log.error("Authentication got issue. Please check system dependencies and resolve as soon as possible!");
		}
		return authenticateResult;
	}

	private Authentication authenticateProductive(Authentication authentication) throws AuthenticationException {
		Authentication authenticateResp = null;
		try {
			if (authentication.getName().length() < 150) {
				authenticateResp = authenticateBySsoId(authentication.getName(), (null != authentication.getCredentials())?authentication.getCredentials().toString():"");
			} else {
				authenticateResp = authenticateByToken(authentication.getName());
			}
		} catch (NgepAuthException cae) {
			log.error(cae);
			throw cae;
		}
		return authenticateResp;
	}

	private Authentication authenticateDevelopment(Authentication authentication) throws AuthenticationException {
		String user = authentication.getName();
		String password = authentication.getCredentials().toString();
		Authentication authenticationToken = null;
		// Here you can add a database connection for your custom login  
		
		List<GrantedAuthority> grantedAuths = new ArrayList<>();
		if (user.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")){
			grantedAuths.add(Authority.builder().name("ROLE_ADMIN").build()new SimpleGrantedAuthority("ROLE_ADMIN"));
		} else if (user.equalsIgnoreCase("user") && password.equalsIgnoreCase("user")){
			grantedAuths.add(Authority.builder().name("ROLE_USER").build() new SimpleGrantedAuthority("ROLE_USER"));
		}
		
		if (grantedAuths.size() > 0) {
			authenticationToken = new UsernamePasswordAuthenticationToken(user, password, grantedAuths);
		}
			
		return authenticationToken;
	}

	@Override
	public boolean supports(Class<? extends Object> authentication) {
		return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
	}

	private Authentication authenticateBySsoId(String ssoId, String password) throws NgepAuthException {
		Authentication authObject = null;
		if ("administrator".equalsIgnoreCase(ssoId) && "administrator".equalsIgnoreCase(password))
			authObject = new UsernamePasswordAuthenticationToken(ssoId, password);
			
		UserSecurityProfile securityPrincipalProfile = null;
		try {
			securityPrincipalProfile = authorizationService.authenticate(ssoId, password);
			if (null != securityPrincipalProfile) {
				authObject = new UsernamePasswordAuthenticationToken(ssoId, password, securityPrincipalProfile.getUserAccount().getAuthorities());
				securityPrincipalProfile.setAuthentication(authObject);

				httpSessionFactory.getObject().setAttribute(GlobalConstants.AUTHENTICATED_PROFILE, securityPrincipalProfile);
			}
		} catch (Exception uae) {
			throw new NgepAuthException(uae);
		}

		return authObject;
	}

	private Authentication authenticateByToken(String token) throws NgepAuthException {
		Authentication authByToken = null;
		UserSecurityProfile userAccountProfile = null;
		try {
			userAccountProfile = authorizationService.authenticate(token);
			if (null != userAccountProfile) {
				authByToken = new UsernamePasswordAuthenticationToken(token, CommonUtility.STRING_BLANK, userAccountProfile.getUserAccount().getAuthorities());			
			}
		} catch (Exception e) {
			throw new NgepAuthException(e);
		}

		return authByToken;
	}
}
*/