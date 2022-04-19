package by.iba.rest;

import by.iba.dto.ModificationRoleDto;
import by.iba.dto.UpdateDto;
import by.iba.dto.UserDto;
import by.iba.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@PreAuthorize("hasAuthority('USER')")
@RequestMapping("/api/v1/users/{id}")
public class UserController {

    private final UserService service;

    @PutMapping("/add-role")
    public ResponseEntity<UserDto> addRoleToUser(@PathVariable("id") Long id, @Valid @RequestBody ModificationRoleDto modificationRoleDto) {
        UserDto userDTO = service.addRole(id, modificationRoleDto);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<UserDto> personalAccount(@PathVariable("id") Long id) {
        UserDto userDTO = service.findById(id);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/update-info")
    public ResponseEntity<UserDto> updatePersonalInfo(@PathVariable("id") Long id, @Valid @RequestBody UpdateDto updateDto){
        UserDto updatedUser = service.updatePersonalInfo(id, updateDto);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
}
