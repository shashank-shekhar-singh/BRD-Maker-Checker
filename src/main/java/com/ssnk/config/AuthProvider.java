package com.ssnk.config;

import com.ssnk.dao.UserDao;
import com.ssnk.entity.Role;
import com.ssnk.entity.User;
import com.ssnk.service.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Component
public class AuthProvider implements AuthenticationProvider {

    @Autowired
    private UserDao userDao;
    @Autowired
    private PasswordEncoder encoder;

    public AuthProvider(UserDao userDao, PasswordEncoder encoder) {
        this.userDao = userDao;
        this.encoder = encoder;
    }

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        String password = authentication.getCredentials().toString();

        User user = userDao.findUserByUsername(username);
        if(user==null) {
            throw new BadCredentialsException("User not found");
        }
        if(encoder.matches(password, user.getPassword())) {
            CurrentUser currentUser = CurrentUser.getCurrentUser();
            currentUser.id = user.getUserId();
            currentUser.username = user.getUsername();
            Set<Role> roles = user.getRoles();
            for (Role role : roles) {
                if (role.getName().equalsIgnoreCase("MAKER")) {
                    currentUser.isMaker = true;
                    break;
                }
                else {
                    currentUser.isMaker = false;
                }
            }
            for (Role role : roles) {
                if (role.getName().equalsIgnoreCase("CHECKER")) {
                    currentUser.isChecker = true;
                    break;
                }
                else {
                    currentUser.isChecker = false;
                }
            }
            for (Role role : roles) {
                if (role.getName().equalsIgnoreCase("ADMIN")) {
                    currentUser.isAdmin = true;
                    break;
                }
                else {
                    currentUser.isAdmin = false;
                }
            }
            return new UsernamePasswordAuthenticationToken(username,password, getUserRoles(user));
        } else {
            throw new BadCredentialsException("Password Mismatch");
        }
    }

    private List<GrantedAuthority> getUserRoles(User user) {
        List<GrantedAuthority> grantedAuthorityList = new ArrayList<>();
        for (Role role:user.getRoles()) {
            GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getName());
            grantedAuthorityList.add(grantedAuthority);
        }
        return grantedAuthorityList;
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}
