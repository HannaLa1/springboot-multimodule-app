package by.iba.service;

import by.iba.dto.resp.SparePartDto;

public interface SellerService {
    SparePartDto addSparePartForSale(Long id, SparePartDto sparePartDto);
}
