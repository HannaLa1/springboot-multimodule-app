package by.iba.rest;

import by.iba.dto.page.PageWrapper;
import by.iba.dto.req.ModificationRoleDto;
import by.iba.dto.resp.SellerDto;
import by.iba.dto.resp.SparePartDto;
import by.iba.dto.resp.UserDto;
import by.iba.dto.seacrhcriteria.SellerSearchCriteria;
import by.iba.dto.seacrhcriteria.SparePartSearchCriteria;
import by.iba.dto.seacrhcriteria.UserSearchCriteria;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/v1/admins/users")
@PreAuthorize("hasAuthority('ADMIN')")
public interface AdminController {

    @GetMapping
    ResponseEntity<PageWrapper<UserDto>> findAllUsers(@RequestParam(defaultValue = "0", required = false) final Integer page,
                                                      @RequestParam(defaultValue = "10", required = false) final Integer size,
                                                      @Valid @RequestBody UserSearchCriteria searchCriteria);

    @GetMapping
    ResponseEntity<PageWrapper<SellerDto>> findAllSellers(@RequestParam(defaultValue = "0", required = false) final Integer page,
                                                          @RequestParam(defaultValue = "10", required = false) final Integer size,
                                                          @Valid @RequestBody SellerSearchCriteria searchCriteria);

    @GetMapping
    ResponseEntity<PageWrapper<SparePartDto>> findAllSpareParts(@RequestParam(defaultValue = "0", required = false) final Integer page,
                                                                @RequestParam(defaultValue = "10", required = false) final Integer size,
                                                                @Valid @RequestBody SparePartSearchCriteria searchCriteria);

    @PutMapping("/{id}/change-role")
    ResponseEntity<UserDto> changeRole(@PathVariable Long id, @Valid @RequestBody ModificationRoleDto roleDto);

    @PutMapping("/{userId}/ban")
    ResponseEntity<UserDto> bannedUser(@PathVariable("userId") Long userId);

    @PutMapping("/{userId}/unban")
    ResponseEntity<UserDto> unBannedUser(@PathVariable("userId") Long userId);

    @PutMapping("/{sellerId}/ban")
    ResponseEntity<SellerDto> bannedSeller(@PathVariable("sellerId") Long sellerId);

    @PutMapping("/{sellerId}/unban")
    ResponseEntity<SellerDto> unBannedSeller(@PathVariable("sellerId") Long sellerId);

    @GetMapping("/{userId}")
    ResponseEntity<UserDto> findUserById(@PathVariable("userId") Long userId);

    @GetMapping("/{sellerId}")
    ResponseEntity<SellerDto> findSellerById(@PathVariable("sellerId") Long sellerId);

    @DeleteMapping("/{userId}/image")
    ResponseEntity<UserDto> deleteUserImage(@PathVariable("userId") Long userId);

    @DeleteMapping("/{sellerId}/image")
    ResponseEntity<SellerDto> deleteSellerImage(@PathVariable("sellerId") Long sellerId);
}
