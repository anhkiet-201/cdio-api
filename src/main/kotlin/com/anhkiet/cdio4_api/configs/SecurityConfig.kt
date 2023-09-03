package com.anhkiet.cdio4_api.configs

import com.anhkiet.cdio4_api.service.TokenService
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpMethod
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.oauth2.server.resource.InvalidBearerTokenException
import org.springframework.security.oauth2.server.resource.authentication.BearerTokenAuthenticationToken
import org.springframework.security.web.SecurityFilterChain
import org.springframework.web.cors.CorsConfiguration
import org.springframework.web.cors.CorsConfigurationSource
import org.springframework.web.cors.UrlBasedCorsConfigurationSource
import java.util.*

@Configuration
@EnableWebSecurity
class SecurityConfig(
    private val tokenService: TokenService,
) {
    @Bean
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        // Define public and private routes
        http.authorizeHttpRequests {
            it.requestMatchers("/api/auth/**").authenticated()
                .anyRequest().permitAll()
        }
        // Configure JWT
        http.oauth2ResourceServer {
            it.jwt {
            }
            it.authenticationEntryPoint { request, response, authException ->
                response.status = 401
                response.outputStream.println(
                    ObjectMapper().writeValueAsString(
                        mapOf(
                            "timestamp" to Date().time,
                            "error" to "Unauthorized",
                            "message" to authException.message,
                            "path" to request.servletPath
                        )
                    )
                )
            }
        }

        http.authenticationManager { auth ->
            val jwt = auth as BearerTokenAuthenticationToken
            val user = tokenService.parseToken(jwt.token) ?: throw InvalidBearerTokenException("Invalid token")
            UsernamePasswordAuthenticationToken(user, "", listOf(SimpleGrantedAuthority("USER")))
        }
        // Other configuration
        http.cors {
            it.configurationSource(corsConfigurationSource())
        }
        http.sessionManagement {
            it.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        }
        http.csrf {
            it.disable()
        }
        http.headers {
            it.frameOptions {
                it.disable()
            }
            it.xssProtection {
                it.disable()
            }
        }
//        http.headers().frameOptions().disable()
//        http.headers().xssProtection().disable()

        return http.build()
    }

    @Bean
    fun corsConfigurationSource(): CorsConfigurationSource {
        // allow localhost for dev purposes
        val configuration = CorsConfiguration()
        configuration.allowedOrigins = listOf("http://localhost:80", "http://localhost:80", "http://localhost:3000")
        configuration.allowedMethods = listOf("GET", "POST", "PUT", "DELETE")
        configuration.allowedHeaders = listOf("authorization", "content-type")
        val source = UrlBasedCorsConfigurationSource()
        source.registerCorsConfiguration("/**", configuration)
        return source
    }
}