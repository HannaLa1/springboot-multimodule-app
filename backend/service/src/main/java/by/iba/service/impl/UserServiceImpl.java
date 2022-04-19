package by.iba.service.impl;

import by.iba.dto.ModificationRoleDto;
import by.iba.dto.UpdateDto;
import by.iba.dto.UserDto;
import by.iba.entity.Role;
import by.iba.entity.TypeOfRole;
import by.iba.entity.User;
import by.iba.entity.UserAccountStatus;
import by.iba.exception.ResourceNotFoundException;
import by.iba.exception.ServiceException;
import by.iba.repository.RoleRepository;
import by.iba.repository.UserRepository;
import by.iba.security.domain.UserDetailsImpl;
import by.iba.security.dto.JwtResp;
import by.iba.security.dto.SignInReq;
import by.iba.security.dto.SignUpReq;
import by.iba.security.exception.WrongPassword;
import by.iba.security.jwt.JwtUtils;
import by.iba.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Collections;

@Service
@Slf4j
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final ModelMapper mapper;

    private final AuthenticationManager authenticationManager;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    private final PasswordEncoder encoder;

    private final JwtUtils jwtUtils;

    @Override
    public JwtResp singIn(SignInReq signInReq) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(signInReq.getEmail(), signInReq.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtUtils.generateJwtToken(authentication);

        UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();

        User byEmail = userRepository.findByEmail(signInReq.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User with email: " + signInReq.getEmail() + " not found"));
        byEmail.setLastVisitedDate(LocalDateTime.now());
        userRepository.save(byEmail);

        return new JwtResp(jwt, userDetails.getUsername());
    }

    @Override
    public UserDto signUp(SignUpReq signUpReq) {
        if (!signUpReq.getPassword().equals(signUpReq.getConfirmPassword())) {
            throw new WrongPassword("The password didn't equals the confirmed password!");
        }

        if (userRepository.existsByUsername(signUpReq.getUsername())) {
            throw new ServiceException("Username is already exist!");
        }

        if (userRepository.existsByEmail(signUpReq.getEmail())) {
            throw new ServiceException("Email is already is already exist!");
        }

        User user = new User();
        user.setUsername(signUpReq.getUsername());
        user.setEmail(signUpReq.getEmail());
        user.setPassword(encoder.encode(signUpReq.getPassword()));
        user.setFirstName(signUpReq.getFirstName());
        user.setLastName(signUpReq.getLastName());
        user.setImageUrl(signUpReq.getImageUrl());
        user.setUserAccountStatus(UserAccountStatus.ACTIVE);

        Role userRole = roleRepository.getByTypeOfRole(TypeOfRole.USER)
                .orElseThrow(() -> new ResourceNotFoundException("Role is not found!"));

        user.setRoles(Collections.singleton(userRole));
        userRepository.save(user);

        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto addRole(Long id, ModificationRoleDto modificationRoleDto) {
        User user = getUserById(id);

        Role role = roleRepository.findById(modificationRoleDto.getRoleId())
                .orElseThrow(() -> new ResourceNotFoundException("Role is not found!"));

        user.getRoles().add(role);
        userRepository.save(user);

        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto findById(Long id) {
        User user = getUserById(id);

        log.info("IN method findById - user: {} found by id: {}", user, id);
        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto updatePersonalInfo(Long id, UpdateDto updateDto) {
        User user = getUserById(id);

        user.setUsername(updateDto.getUsername());
        user.setEmail(updateDto.getEmail());
        user.setPassword(encoder.encode(updateDto.getPassword()));
        user.setFirstName(updateDto.getFirstName());
        user.setLastName(updateDto.getLastName());
        user.setImageUrl(updateDto.getImageUrl());
        log.info("IN method update - updated user : {}", user);

        userRepository.save(user);

        return mapper.map(user, UserDto.class);
    }

    private User getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));

        log.info("IN method getUserById - user: {} found by id: {}", user, id);
        return user;
    }
}
