package by.iba.service.impl;

import by.iba.dto.RoleDto;
import by.iba.dto.UserDto;
import by.iba.dto.UserSearchCriteriaDto;
import by.iba.dto.page.PageWrapper;
import by.iba.dto.page.Paging;
import by.iba.entity.Role;
import by.iba.entity.User;
import by.iba.entity.UserAccountStatus;
import by.iba.exception.ResourceNotFoundException;
import by.iba.repository.RoleRepository;
import by.iba.repository.UserRepository;
import by.iba.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

import static by.iba.repository.specification.UserSpecification.*;

@Service
@Slf4j
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ModelMapper mapper;

    private final UserRepository userRepository;

    private final RoleRepository roleRepository;

    @Override
    public PageWrapper<UserDto> findAll(UserSearchCriteriaDto criteriaDto, Paging paging) {
        Pageable pageable = PageRequest.of(paging.getPage(), paging.getSize(), Sort.by("firstName").ascending()
                .and(Sort.by("lastName").ascending()));

        Specification<User> specification = getUserSpecification(criteriaDto);
        Page<User> page = userRepository.findAll(specification, pageable);

        List<UserDto> users = page.toList().stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());

        return PageWrapper.of(
                users,
                page.getTotalPages(),
                page.getTotalElements(),
                paging.getPage(),
                page.getNumberOfElements());
    }

    private Specification<User> getUserSpecification(UserSearchCriteriaDto criteriaDto) {
        Set<Role> roles = resolveRoles(criteriaDto.getRoles());

        return hasUsername(criteriaDto.getUsername())
                .or(hasEmail(criteriaDto.getEmail())
                .or(hasFirstName(criteriaDto.getFirstName()))
                .or(hasLastName(criteriaDto.getLastName())))
                .or(hasRoles(roles));
    }

    private Set<Role> resolveRoles(Set<RoleDto> roles) {
        return Objects.isNull(roles) ?
                Collections.emptySet() :
                roles.stream()
                        .map(role -> roleRepository.getByTypeOfRole(role.getTypeOfRole())
                                .orElse(new Role()))
                        .collect(Collectors.toSet());
    }

    @Override
    public UserDto changeRole(Long id, Long roleId) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));

        if(user.getRoles().size() > 1){
            Role role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new ResourceNotFoundException("Role is not found!"));

            user.setRoles(Collections.singleton(role));
            userRepository.save(user);
        }

        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto bannedUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));

        user.setUserAccountStatus(UserAccountStatus.BANNED);
        userRepository.save(user);

        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto unBannedUser(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));

        user.setUserAccountStatus(UserAccountStatus.ACTIVE);
        userRepository.save(user);

        return mapper.map(user, UserDto.class);
    }
}
