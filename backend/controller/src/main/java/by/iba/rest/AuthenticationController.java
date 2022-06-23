package by.iba.rest;

import by.iba.dto.resp.UserDto;
import by.iba.security.dto.resp.JwtResp;
import by.iba.security.dto.req.SignInReq;
import by.iba.security.dto.req.SignUpReq;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@RequestMapping("/api/v1/users/auth")
public interface AuthenticationController {

    @PostMapping("/signIn")
    ResponseEntity<JwtResp> logIn(@Valid @RequestBody SignInReq signInReq);

    @PostMapping("/signUp")
    ResponseEntity<UserDto> registration(@Valid @RequestBody SignUpReq signUpReq);
}
