package by.iba.rest.impl;

import by.iba.dto.page.PageWrapper;
import by.iba.dto.req.ModificationRoleDto;
import by.iba.dto.resp.SellerDto;
import by.iba.dto.resp.SparePartDto;
import by.iba.dto.resp.UserDto;
import by.iba.dto.seacrhcriteria.SellerSearchCriteria;
import by.iba.dto.seacrhcriteria.SparePartSearchCriteria;
import by.iba.dto.seacrhcriteria.UserSearchCriteria;
import by.iba.rest.AdminController;
import by.iba.service.AdminService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class AdminControllerImpl implements AdminController {
    private final AdminService service;

    @Override
    public ResponseEntity<PageWrapper<UserDto>> findAllUsers(Integer page, Integer size, UserSearchCriteria searchCriteria) {
        PageWrapper<UserDto> users = service.findAllUsers(searchCriteria, page, size);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageWrapper<SellerDto>> findAllSellers(Integer size, Integer page, SellerSearchCriteria searchCriteria) {
        PageWrapper<SellerDto> sellers = service.findAllSellers(searchCriteria, page, size);

        return new ResponseEntity<>(sellers, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<PageWrapper<SparePartDto>> findAllSpareParts(Integer size, Integer page, SparePartSearchCriteria searchCriteria) {
        PageWrapper<SparePartDto> spareParts = service.findAllSpareParts(searchCriteria, page, size);

        return new ResponseEntity<>(spareParts, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> changeRole(Long id, ModificationRoleDto roleDto) {
        UserDto userDTO = service.changeRole(id, roleDto.getRoleId());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> bannedUser(Long userId) {
        UserDto userDTO = service.bannedUser(userId);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> unBannedUser(Long userId) {
        UserDto userDTO = service.unBannedUser(userId);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SellerDto> bannedSeller(Long sellerId) {
        SellerDto sellerDto = service.bannedSeller(sellerId);

        return new ResponseEntity<>(sellerDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SellerDto> unBannedSeller(Long sellerId) {
        SellerDto sellerDto = service.unBannedSeller(sellerId);

        return new ResponseEntity<>(sellerDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> findUserById(Long userId) {
        UserDto userDTO = service.findUserById(userId);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SellerDto> findSellerById(Long sellerId) {
        SellerDto sellerDto = service.findSellerById(sellerId);

        return new ResponseEntity<>(sellerDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> deleteUserImage(Long userId) {
        UserDto userDto = service.deleteUserImage(userId);

        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<SellerDto> deleteSellerImage(Long sellerId) {
        SellerDto sellerDto = service.deleteSellerImage(sellerId);

        return new ResponseEntity<>(sellerDto, HttpStatus.OK);
    }
}
