package by.iba.rest;

import by.iba.dto.req.ModificationRoleDto;
import by.iba.dto.req.UpdateDto;
import by.iba.dto.resp.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@PreAuthorize("hasAuthority('USER')")
@RequestMapping("/api/v1/users/{id}")
public interface CustomerController {

    @PutMapping("/add-role")
    ResponseEntity<UserDto> addRoleToUser(@PathVariable("id") Long id, @Valid @RequestBody ModificationRoleDto modificationRoleDto);

    @GetMapping
    ResponseEntity<UserDto> personalAccount(@PathVariable("id") Long id);

    @PutMapping("/update-info")
    ResponseEntity<UserDto> updatePersonalInfo(@PathVariable("id") Long id, @Valid @RequestBody UpdateDto updateDto);
}
