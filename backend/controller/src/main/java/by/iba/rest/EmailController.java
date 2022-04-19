package by.iba.rest;

import by.iba.dto.RecoveryDto;
import by.iba.dto.ResetDto;
import by.iba.security.dto.ApiResp;
import by.iba.service.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api/v1/users/mail")
public class EmailController {

    private final MailService service;

    @PostMapping("/{id}/recovery-password")
    public ResponseEntity<ApiResp> recoveryPassword(@PathVariable("id") Long id, @Valid @RequestBody RecoveryDto recoveryDto){
        service.recoveryPassword(id, recoveryDto.getEmail());
        
        return new ResponseEntity<>(new ApiResp("Notification send!"), HttpStatus.OK);
    }

    @PutMapping("/reset-password")
    public ResponseEntity<ApiResp> resetPassword(@Valid @RequestBody ResetDto resetDto){
        service.resetPassword(resetDto);

        return new ResponseEntity<>(new ApiResp("Your password successfully updated!"), HttpStatus.OK);
    }
}
