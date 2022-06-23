package by.iba.security.service;

import by.iba.entity.customer.User;
import by.iba.repository.UserRepository;
import by.iba.entity.customer.AccountStatus;
import by.iba.security.domain.UserDetailsImpl;
import by.iba.security.exception.BannedUserException;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("User with username: " + email + "not found!"));

        log.info("In method loadUserByUsername - user with username: {} successfully loaded", email);

        if(user.getUserAccountStatus().equals(AccountStatus.BANNED)){
            throw new BannedUserException("User is banned!");
        }

        return UserDetailsImpl.create(user);
    }
}
