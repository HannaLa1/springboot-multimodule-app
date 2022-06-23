package by.iba.rest.impl;

import by.iba.dto.resp.UserDto;
import by.iba.rest.AuthenticationController;
import by.iba.security.dto.resp.JwtResp;
import by.iba.security.dto.req.SignInReq;
import by.iba.security.dto.req.SignUpReq;
import by.iba.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@AllArgsConstructor
@Slf4j
public class AuthenticationControllerImpl implements AuthenticationController {
    private final UserService service;

    @Override
    public ResponseEntity<JwtResp> logIn(SignInReq signInReq) {
        JwtResp resp = service.singIn(signInReq);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<UserDto> registration(SignUpReq signUpReq) {
        UserDto resp = service.signUp(signUpReq);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(resp.getId()).toUri());

        return new ResponseEntity<>(resp, httpHeaders, HttpStatus.CREATED);
    }
}
