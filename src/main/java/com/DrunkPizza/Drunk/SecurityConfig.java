/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.DrunkPizza.Drunk;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;

import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author angel
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    /*
    @Autowired
    private UserService userDetailsService;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserService getUserService() {
        return new UserService();
    }

    @Bean
    DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(passwordEncoder());
        daoAuthenticationProvider.setUserDetailsService(getUserService());
        return daoAuthenticationProvider;
    }

    @Bean
    public AuthenticationSuccessHandler appAuthenticationSuccessHandler() {
        return new AppAuthenticationSuccessHandler();
    }

    public SecurityConfig(UserService userPrincipalDetailsService) {
        this.userDetailsService = userPrincipalDetailsService;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider());
    }

    //El siguiente metodo funciona para hacer la autenticacion del usuario
    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http.authorizeRequests()
                .antMatchers("/cliente", "login", "/clienteNuevo")
                .hasRole("ADMIN")
                .antMatchers("/cliente", "/", "/login")
                .hasAnyRole("USER", "VENDEDOR", "ADMIN")
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll().defaultSuccessUrl("/cliente", true);
    }
     */

    @Autowired
    private UserDetailsService userDetailsService;

    //El siguiente método funciona para hacer la auttenticación del usuario
    @Override
    protected void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/cliente", "/clienteNuevo", "/saveProducto", "/editClientes/**", "/deleteCliente/**", "/perfil/**",
                        "/", "productos", "/productoN", "/saveProducto", "editProducto/**", "/deleteProducto/**",
                        "/opinion", "/contactenos")
                .hasRole("ADMIN")
                .antMatchers("/cliente", "/clienteNuevo", "/saveProducto", "/editClientes/**", "/deleteCliente/**", "/perfil/**",
                        "/", "productos", "/productoN", "/saveProducto", "editProducto/**", "/deleteProducto/**",
                        "/opinion", "/contactenos")
                .hasAnyRole("ADMIN", "VENDEDOR")
                .antMatchers("/","/carrito")
                .permitAll()
                
                /*SI NO SE ENCUENTRA AUTENTICADO*/
                .antMatchers("/")
                .authenticated()
                .and().formLogin() .loginPage("/login")
                .and()
                /*PROBLEMA DE ROLES*/
                .exceptionHandling().accessDeniedPage("/errores/403");
    }
}
