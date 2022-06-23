package by.iba.rest.impl;

import by.iba.dto.resp.SparePartDto;
import by.iba.rest.SellerController;
import by.iba.service.SellerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class SellerControllerImpl implements SellerController {
    private final SellerService service;

    @Override
    public ResponseEntity<SparePartDto> addSparePartForSale(Long id, SparePartDto sparePart) {
        SparePartDto sparePartDto = service.addSparePartForSale(id, sparePart);

        return new ResponseEntity<>(sparePartDto, HttpStatus.OK);
    }
}
