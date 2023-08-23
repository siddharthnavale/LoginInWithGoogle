package com.demo.Security.Oauth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.demo.Entity.Provider;
import com.demo.Entity.User;
import com.demo.Service.UserService;

@Component
public class OAuth2LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler{

	@Autowired
	private UserService userService;
	
	   @Override
       public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
               Authentication authentication) throws IOException, ServletException {

           CustomOAuth2User oauthUser = (CustomOAuth2User) authentication.getPrincipal();

		    User user=userService.findByEmail(oauthUser.getEmail());

           if(user==null) {
        	   userService.createNewUserAfterOuathLogin(oauthUser.getName(),oauthUser.getEmail(),Provider.GOOGLE);
           }
           response.sendRedirect("/users/"); //method is used in web development to redirect the user's browser to a different URL.
       }
	

}
