package by.iba.service;

import by.iba.dto.RatingDto;
import by.iba.dto.SparePartDto;

public interface SellerService {
    SparePartDto addSparePartForSale(Long id, SparePartDto sparePartDto);
    RatingDto checkRating(Long id);
}
