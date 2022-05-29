package by.iba.rest;

import by.iba.dto.RatingDto;
import by.iba.dto.SparePartDto;
import by.iba.service.SellerService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/sellers/{id}")
public class SellerController {
    private final SellerService service;

    @PreAuthorize("hasAuthority('SELLER')")
    @PostMapping("/spareParts")
    public ResponseEntity<SparePartDto> addSparePartForSale(@PathVariable("id") Long id, @Valid @RequestBody SparePartDto sparePart){
        SparePartDto sparePartDto = service.addSparePartForSale(id, sparePart);

        return new ResponseEntity<>(sparePartDto, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping("/check-rating")
    public ResponseEntity<RatingDto> checkRating(@PathVariable("id") Long id){
        RatingDto ratingDto = service.checkRating(id);

        return new ResponseEntity<>(ratingDto, HttpStatus.OK);
    }
}
