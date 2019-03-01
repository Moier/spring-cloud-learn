package com.example.authserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;
import org.springframework.security.oauth2.provider.token.store.JwtTokenStore;

@SpringBootApplication
@EnableAuthorizationServer
public class AuthServerApplication extends AuthorizationServerConfigurerAdapter {


	@Autowired
	private AuthenticationManager authenticationManager;


	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("zuul-server")
				.secret("secret")
				.scopes("WRITH","read")
				.authorities("WRITH_READ","WRITH_WRITH")
				.authorizedGrantTypes("implicit","refresh_token","password","authorization_code");
	}

	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.tokenStore(jwtTokenStore()).tokenEnhancer(jwtTokenConverter()).authenticationManager(authenticationManager);
	}


	@Bean
	public TokenStore jwtTokenStore(){
		return new JwtTokenStore(jwtTokenConverter());
	}


	public JwtAccessTokenConverter jwtTokenConverter(){
		JwtAccessTokenConverter converter = new JwtAccessTokenConverter();
		converter.setSigningKey("springcloud123");
		return converter;
	}

	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
	}



}
