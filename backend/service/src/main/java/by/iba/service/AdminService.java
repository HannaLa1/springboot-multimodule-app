package by.iba.service;

import by.iba.dto.resp.SellerDto;
import by.iba.dto.resp.SparePartDto;
import by.iba.dto.resp.UserDto;
import by.iba.dto.seacrhcriteria.SellerSearchCriteria;
import by.iba.dto.seacrhcriteria.SparePartSearchCriteria;
import by.iba.dto.seacrhcriteria.UserSearchCriteria;
import by.iba.dto.page.PageWrapper;

public interface AdminService {
    PageWrapper<UserDto> findAllUsers(UserSearchCriteria searchCriteria, final Integer page, final Integer size);
    PageWrapper<SellerDto> findAllSellers(SellerSearchCriteria searchCriteria, final Integer page, final Integer size);
    PageWrapper<SparePartDto> findAllSpareParts(SparePartSearchCriteria searchCriteria, final Integer page, final Integer size);
    UserDto changeRole(Long id, Long roleId);
    UserDto bannedUser(Long userId);
    UserDto unBannedUser(Long userId);
    SellerDto bannedSeller(Long sellerId);
    SellerDto unBannedSeller(Long sellerId);
    UserDto findUserById(Long userId);
    SellerDto findSellerById(Long sellerId);
    UserDto deleteUserImage(Long userId);

    SellerDto deleteSellerImage(Long sellerId);
}
