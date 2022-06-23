package by.iba.rest.impl;

import by.iba.dto.req.RecoveryDto;
import by.iba.dto.req.ResetDto;
import by.iba.rest.EmailController;
import by.iba.security.dto.resp.ApiResp;
import by.iba.service.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@Slf4j
public class EmailControllerImpl implements EmailController {
    private final MailService service;

    @Override
    public ResponseEntity<ApiResp> recoveryPassword(Long id, RecoveryDto recoveryDto) {
        service.recoveryPassword(id, recoveryDto.getEmail());

        return new ResponseEntity<>(new ApiResp("Notification send!"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<ApiResp> resetPassword(ResetDto resetDto) {
        service.resetPassword(resetDto);

        return new ResponseEntity<>(new ApiResp("Your password successfully updated!"), HttpStatus.OK);
    }
}
