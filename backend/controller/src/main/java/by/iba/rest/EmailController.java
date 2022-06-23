package by.iba.rest;

import by.iba.dto.req.RecoveryDto;
import by.iba.dto.req.ResetDto;
import by.iba.security.dto.resp.ApiResp;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RequestMapping("/api/v1/users/mail")
public interface EmailController {

    @PostMapping("/{id}/recovery-password")
    ResponseEntity<ApiResp> recoveryPassword(@PathVariable("id") Long id, @Valid @RequestBody RecoveryDto recoveryDto);

    @PutMapping("/reset-password")
    ResponseEntity<ApiResp> resetPassword(@Valid @RequestBody ResetDto resetDto);
}
