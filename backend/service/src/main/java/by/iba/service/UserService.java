package by.iba.service;

import by.iba.dto.ModificationRoleDto;
import by.iba.dto.UpdateDto;
import by.iba.dto.UserDto;
import by.iba.security.dto.JwtResp;
import by.iba.security.dto.SignInReq;
import by.iba.security.dto.SignUpReq;

public interface UserService {
    UserDto addRole(Long id, ModificationRoleDto modificationRoleDto);
    JwtResp singIn(SignInReq signInReq);
    UserDto signUp(SignUpReq signUpReq);
    UserDto findById(Long id);
    UserDto updatePersonalInfo(Long id, UpdateDto updateDto);
}
