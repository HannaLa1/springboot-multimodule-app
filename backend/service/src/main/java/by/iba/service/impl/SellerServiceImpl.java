package by.iba.service.impl;

import by.iba.dto.RatingDto;
import by.iba.dto.SparePartDto;
import by.iba.entity.seller.SellerRating;
import by.iba.entity.sparepart.SparePart;
import by.iba.entity.customer.User;
import by.iba.exception.ResourceNotFoundException;
import by.iba.repository.SellerRepository;
import by.iba.repository.UserRepository;
import by.iba.service.SellerService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SellerServiceImpl implements SellerService {

    private final ModelMapper mapper;

    private final SellerRepository sellerRepository;

    private final UserRepository userRepository;

    @Override
    public SparePartDto addSparePartForSale(Long id, SparePartDto sparePartDto) {
        User seller = getSellerById(id);

        SparePart sparePart = mapper.map(sparePartDto, SparePart.class);
        sparePart.setUser(seller);
        sellerRepository.save(sparePart);

        return mapper.map(sparePart, SparePartDto.class);
    }

    private User getSellerById(Long id) {
        User seller = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller with id: " + id + " not found"));

        log.info("IN method getSellerById - seller: {} found by id: {}", seller, id);
        return seller;
    }

    @Override
    public RatingDto checkRating(Long id) {
        SellerRating rating = sellerRepository.getSellerRatingById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Seller with id: " + id + " not found"));

        log.info("IN method checkRating - seller found by id: {}", id);
        return mapper.map(rating, RatingDto.class);
    }
}
