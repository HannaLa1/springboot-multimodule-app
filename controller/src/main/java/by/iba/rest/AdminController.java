package by.iba.rest;

import by.iba.dto.ModificationRoleDto;
import by.iba.dto.UserDto;
import by.iba.dto.UserSearchCriteriaDto;
import by.iba.dto.page.PageWrapper;
import by.iba.dto.page.Paging;
import by.iba.service.AdminService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;

@RestController
@AllArgsConstructor
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping("/api/v1/admins/users")
public class AdminController {

    private final AdminService service;

    @GetMapping
    public ResponseEntity<PageWrapper<UserDto>> findAll(@RequestParam(defaultValue = "10", value = "size")
                                                     @Min(value = 1, message = "Min size value is 1!") Integer size,
                                                        @RequestParam(defaultValue = "0", value = "page")
                                                        @Min(value = 1, message = "Min page value is 1!") Integer page,
                                                        @Valid @RequestBody UserSearchCriteriaDto criteriaDto) {
        Paging paging = new Paging(page, size);
        PageWrapper<UserDto> userDTOList = service.findAll(criteriaDto, paging);

        return new ResponseEntity<>(userDTOList, HttpStatus.OK);
    }

    @PutMapping("/{id}/change-role")
    public ResponseEntity<UserDto> changeRole(@PathVariable("id") Long id, @Valid @RequestBody ModificationRoleDto roleDto) {
        UserDto userDTO = service.changeRole(id, roleDto.getRoleId());

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}/ban")
    public ResponseEntity<UserDto> bannedUser(@PathVariable ("id") Long id) {
        UserDto userDTO = service.bannedUser(id);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }

    @PutMapping("/{id}/unban")
    public ResponseEntity<UserDto> unBannedUser(@PathVariable ("id") Long id) {
        UserDto userDTO = service.unBannedUser(id);

        return new ResponseEntity<>(userDTO, HttpStatus.OK);
    }
}
