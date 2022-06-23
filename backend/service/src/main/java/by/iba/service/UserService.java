package by.iba.service;

import by.iba.dto.req.ModificationRoleDto;
import by.iba.dto.req.UpdateDto;
import by.iba.dto.resp.UserDto;
import by.iba.security.dto.resp.JwtResp;
import by.iba.security.dto.req.SignInReq;
import by.iba.security.dto.req.SignUpReq;

public interface UserService {
    UserDto addRole(Long id, ModificationRoleDto modificationRoleDto);
    JwtResp singIn(SignInReq signInReq);
    UserDto signUp(SignUpReq signUpReq);
    UserDto findById(Long id);
    UserDto updatePersonalInfo(Long id, UpdateDto updateDto);
}
