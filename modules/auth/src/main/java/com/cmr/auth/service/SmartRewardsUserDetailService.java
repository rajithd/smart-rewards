package com.cmr.auth.service;

import com.cmr.auth.dao.UserRepository;
import com.cmr.beans.user.UserAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author : rajith
 */
@Service
public class SmartRewardsUserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserAccount userAccount = userRepository.findUserAccountByUsername(username);
        if (userAccount == null) {
            throw new UsernameNotFoundException("User account not found");
        }

        return new User(userAccount.getUsername(), userAccount.getPassword(), getGrantedAuthorityList(userAccount));
    }

    public List<GrantedAuthority> getGrantedAuthorityList(UserAccount userAccount) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        for (String role : userAccount.getRoles()) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role));
        }
        return grantedAuthorities;
    }
}
