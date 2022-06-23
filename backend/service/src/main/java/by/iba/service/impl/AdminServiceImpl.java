package by.iba.service.impl;

import by.iba.dto.page.PageWrapper;
import by.iba.dto.resp.RoleDto;
import by.iba.dto.resp.SellerDto;
import by.iba.dto.resp.SparePartDto;
import by.iba.dto.resp.UserDto;
import by.iba.dto.seacrhcriteria.SellerSearchCriteria;
import by.iba.dto.seacrhcriteria.SparePartSearchCriteria;
import by.iba.dto.seacrhcriteria.UserSearchCriteria;
import by.iba.entity.customer.Role;
import by.iba.entity.customer.User;
import by.iba.entity.customer.AccountStatus;
import by.iba.entity.seller.Seller;
import by.iba.entity.sparepart.Image;
import by.iba.entity.sparepart.SparePart;
import by.iba.exception.ResourceNotFoundException;
import by.iba.repository.RoleRepository;
import by.iba.repository.SellerRepository;
import by.iba.repository.SparePartRepository;
import by.iba.repository.UserRepository;
import by.iba.service.AdminService;
import by.iba.service.ImageService;
import by.iba.specification.SellersSpecification;
import by.iba.specification.UsersSpecification;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class AdminServiceImpl implements AdminService {

    private final ModelMapper mapper;

    private final ImageService imageService;

    private final UserRepository userRepository;

    private final SellerRepository sellerRepository;

    private final SparePartRepository sparePartRepository;

    private final RoleRepository roleRepository;

    @Override
    public PageWrapper<UserDto> findAllUsers(UserSearchCriteria searchCriteria, final Integer page, final Integer size) {
        Pageable pageable = searchCriteria.getPageable();

        Specification<User> specification = UsersSpecification.getSpecificationByCriteria(searchCriteria, resolveRoles(searchCriteria.getRoles()));
        Page<User> users = userRepository.findAll(specification, pageable);

        List<UserDto> userDtoList = users.toList().stream()
                .map(user -> mapper.map(user, UserDto.class))
                .collect(Collectors.toList());

        return new PageWrapper<>(
                userDtoList,
                users.getTotalPages(),
                users.getTotalElements()
        );
    }

    @Override
    public PageWrapper<SellerDto> findAllSellers(SellerSearchCriteria searchCriteria, final Integer page, final Integer size) {
        Pageable pageable = searchCriteria.getPageable();

        Specification<Seller> specification = SellersSpecification.getSpecificationByCriteria(searchCriteria);
        Page<Seller> sellers = sellerRepository.findAll(specification, pageable);

        List<SellerDto> sellerDtoList = sellers.toList().stream()
                .map(seller -> mapper.map(seller, SellerDto.class))
                .collect(Collectors.toList());

        return new PageWrapper<>(
                sellerDtoList,
                sellers.getTotalPages(),
                sellers.getTotalElements()
        );
    }

    @Override
    public PageWrapper<SparePartDto> findAllSpareParts(SparePartSearchCriteria searchCriteria, final Integer page, final Integer size) {
        return null;
    }

    @Override
    public UserDto changeRole(Long id, Long roleId) {

        User user = getUserById(id);

        if(user.getRoles().size() > 1){
            Role role = roleRepository.findById(roleId)
                    .orElseThrow(() -> new ResourceNotFoundException("Role is not found!"));

            user.setRoles(Collections.singleton(role));
            userRepository.save(user);
        }

        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto bannedUser(Long userId) {
        User user = getUserById(userId);

        user.setAccountStatus(AccountStatus.BLOCKED);
        userRepository.save(user);
        log.info("In method bannedUser - user with id: {} successfully banned", userId);

        return mapper.map(user, UserDto.class);
    }

    @Override
    public UserDto unBannedUser(Long userId) {
        User user = getUserById(userId);

        user.setAccountStatus(AccountStatus.VERIFIED);
        userRepository.save(user);
        log.info("In method unBannedUser - user with id: {} successfully unbanned", userId);

        return mapper.map(user, UserDto.class);
    }

    @Override
    public SellerDto bannedSeller(Long sellerId) {
        Seller seller = getSellerById(sellerId);

        seller.setAccountStatus(AccountStatus.BLOCKED);
        sellerRepository.save(seller);
        log.info("In method bannedSeller - seller with id: {} successfully banned", sellerId);

        return mapper.map(seller, SellerDto.class);
    }

    @Override
    public SellerDto unBannedSeller(Long sellerId) {
        Seller seller = getSellerById(sellerId);

        seller.setAccountStatus(AccountStatus.VERIFIED);
        sellerRepository.save(seller);
        log.info("In method unBannedSeller - seller with id: {} successfully unbanned", sellerId);

        return mapper.map(seller, SellerDto.class);
    }

    @Override
    public UserDto findUserById(Long userId) {
        User user = getUserById(userId);

        log.info("IN method findUserById - user: {} found by id: {}", user, userId);
        return mapper.map(user, UserDto.class);
    }

    @Override
    public SellerDto findSellerById(Long sellerId) {
        Seller seller = getSellerById(sellerId);

        log.info("IN method findSellerById - seller: {} found by id: {}", seller, sellerId);
        return mapper.map(seller, SellerDto.class);
    }

    @Override
    public UserDto deleteUserImage(Long userId) {
        User user = getUserById(userId);

        final Image image = imageService.getDefaultImage();
        user.setImage(image);

        return mapper.map(user, UserDto.class);
    }

    @Override
    public SellerDto deleteSellerImage(Long sellerId) {
        Seller seller = getSellerById(sellerId);

        final Image image = imageService.getDefaultImage();
        seller.setImage(image);

        return mapper.map(seller, SellerDto.class);
    }

    private User getUserById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + id + " not found"));

        log.info("IN method getUserById - user: {} found by id: {}", user, id);
        return user;
    }

    private Seller getSellerById(Long id) {
        Seller seller = sellerRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller with id: " + id + " not found"));

        log.info("IN method getSellerById - seller: {} found by id: {}", seller, id);
        return seller;
    }

    private Set<Role> resolveRoles(Set<RoleDto> roles) {
        return Objects.isNull(roles) ?
                Collections.emptySet() :
                roles.stream()
                        .map(role -> roleRepository.getByRoleType(role.getTypeOfRole())
                                .orElse(new Role()))
                        .collect(Collectors.toSet());
    }
}
