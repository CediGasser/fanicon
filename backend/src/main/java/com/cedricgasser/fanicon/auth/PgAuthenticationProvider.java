package com.cedricgasser.fanicon.auth;

import com.cedricgasser.fanicon.dto.UserDto;
import com.cedricgasser.fanicon.model.User;
import com.cedricgasser.fanicon.model.UserGroup;
import com.cedricgasser.fanicon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class PgAuthenticationProvider implements AuthenticationProvider {

    private final UserService loginService;

    @Autowired
    public PgAuthenticationProvider(final UserService loginService) {
        this.loginService = loginService;
    }

    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {

        final String name = authentication.getName();
        final String password = authentication.getCredentials().toString();

        return getAuth(name, password);
    }

    public Authentication login(final UserDto user){
        final String name = user.getName();
        final String password = user.getPassword();

        return getAuth(name, password);
    }

    private Authentication getAuth(final String name, final String password) {
        if (loginService.login(name, password).isPresent()) {
            final UserGroup userGroup = loginService.login(name, password).get();
            return new UsernamePasswordAuthenticationToken(
                    name,
                    password,
                    Collections.singletonList(new SimpleGrantedAuthority(userGroup.toString())));
        }
        return null;
    }

    @Override
    public boolean supports(final Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
