package by.iba.rest.impl;

import by.iba.dto.req.ModificationRoleDto;
import by.iba.dto.req.UpdateDto;
import by.iba.dto.resp.UserDto;
import by.iba.rest.CustomerController;
import by.iba.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class CustomerControllerImpl implements CustomerController {
    private final UserService service;

    @Override
    public ResponseEntity<UserDto> addRoleToUser(Long id, ModificationRoleDto modificationRoleDto) {
        UserDto userDTO = service.addRole(id, modificationRoleDto);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> personalAccount(Long id) {
        UserDto userDTO = service.findById(id);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> updatePersonalInfo(Long id, UpdateDto updateDto) {
        UserDto updatedUser = service.updatePersonalInfo(id, updateDto);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
