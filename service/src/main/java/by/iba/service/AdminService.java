package by.iba.service;

import by.iba.dto.UserDto;
import by.iba.dto.UserSearchCriteriaDto;
import by.iba.dto.page.PageWrapper;
import by.iba.dto.page.Paging;

public interface AdminService {
    PageWrapper<UserDto> findAll(UserSearchCriteriaDto criteriaDto, Paging paging);
    UserDto changeRole(Long id, Long roleId);
    UserDto bannedUser(Long id);
    UserDto unBannedUser(Long id);
}
