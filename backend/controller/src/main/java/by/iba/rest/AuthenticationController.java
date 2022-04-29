package by.iba.rest;

import by.iba.dto.UserDto;
import by.iba.security.dto.JwtResp;
import by.iba.security.dto.SignInReq;
import by.iba.security.dto.SignUpReq;
import by.iba.service.UserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/users/auth")
public class AuthenticationController {

    private final UserService service;

    @PostMapping("/signIn")
    public ResponseEntity<JwtResp> logIn(@Valid @RequestBody SignInReq signInReq){

        JwtResp resp = service.singIn(signInReq);

        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @PostMapping("/signUp")
    public ResponseEntity<UserDto> registration(@Valid @RequestBody SignUpReq signUpReq){

        UserDto resp = service.signUp(signUpReq);

        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(resp.getId()).toUri());

        return new ResponseEntity<>(resp, httpHeaders, HttpStatus.CREATED);
    }
}
