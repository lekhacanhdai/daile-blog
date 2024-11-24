package com.blog.gateway.config;

import java.util.List;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;

/**
 * @author lkadai0801
 * @since 28/03/2024
 */
@Configuration
@EnableMethodSecurity(securedEnabled = true)
public class SecurityConfig {
  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http.csrf(AbstractHttpConfigurer::disable) // TODO: research csrf
        .authorizeHttpRequests(
            auth ->
                auth.requestMatchers(
                        HttpMethod.GET, "/**"
                        //                                "/public/**",
                        //                                "/swagger-ui/**",
                        //                                "/v3/api-docs/**",
                        //                                "/v3/api-docs.yaml"
                        )
                    .permitAll()
                    .requestMatchers(
                        HttpMethod.POST, "/**", "/posts"
                        //                                "/files"
                        )
                    .permitAll()
                    .anyRequest()
                    .authenticated())
        .oauth2ResourceServer(
            oauth2 ->
                oauth2.jwt(
                    jwtConfigurer ->
                        jwtConfigurer.jwtAuthenticationConverter(JwtUtils::createJwtUser)))
        .cors(
            cors ->
                cors.configurationSource(
                    request -> {
                      CorsConfiguration configuration = new CorsConfiguration();
                      configuration.setAllowedOrigins(List.of("*"));
                      configuration.setAllowedMethods(List.of("*"));
                      configuration.setAllowedHeaders(List.of("*"));
                      return configuration;
                    }));
    return http.build();
  }
  /*
  private Converter<Jwt, AbstractAuthenticationToken> jwtAuthenticationConvertor(){
      JwtGrantedAuthoritiesConverter grantedAuthoritiesConverter = new JwtGrantedAuthoritiesConverter();
      grantedAuthoritiesConverter.setAuthorityPrefix(""); // prefix is so importance (role or scope). I'm wrong many times and spend time.
      grantedAuthoritiesConverter.setAuthoritiesClaimName("roles");
      JwtAuthenticationConverter converter = new JwtAuthenticationConverter();
      converter.setJwtGrantedAuthoritiesConverter(grantedAuthoritiesConverter);
      return converter;
  } */
}
