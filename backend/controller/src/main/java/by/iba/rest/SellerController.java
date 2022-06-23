package by.iba.rest;

import by.iba.dto.resp.SparePartDto;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/v1/sellers/{id}")
@PreAuthorize("hasAuthority('SELLER')")
public interface SellerController {

    @PostMapping("/spareParts")
    ResponseEntity<SparePartDto> addSparePartForSale(@PathVariable("id") Long id, @Valid @RequestBody SparePartDto sparePart);
}
