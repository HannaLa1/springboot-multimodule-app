package by.iba.service.impl;

import by.iba.repository.SellerRepository;
import by.iba.repository.UserRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@AllArgsConstructor
public class SellerServiceImpl {

    private final ModelMapper mapper;

    private final SellerRepository sellerRepository;

    private final UserRepository userRepository;
}
