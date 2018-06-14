package com.udemy.service.impl;

import com.udemy.entity.User;
import com.udemy.entity.UserRole;
import com.udemy.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("userService")
public class UserService implements UserDetailsService{

    @Autowired
    @Qualifier("userRepository")
    private UserRepository userRepository;

    @Override
    public User loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userRepository.findByUserName(s);
        List<GrantedAuthority> authorities = buildAuthorities(user.getUserRole());
        return buildUser(user, authorities);
    }

    private User buildUser(User user, List<GrantedAuthority> authorityList){
        return new User(user.getUsername(),user.getPassword(),user.isEnabled(),user.getUserRole());
    }

    private List<GrantedAuthority> buildAuthorities(Set<UserRole> userRoleSet){
        Set<GrantedAuthority> grantedAuthorities = new HashSet<GrantedAuthority>();

        for(UserRole userRole:userRoleSet){
            grantedAuthorities.add(new SimpleGrantedAuthority(userRole.getRole()));
        }

        return new ArrayList<GrantedAuthority>(grantedAuthorities);
    }

}
