package by.iba.service;

import by.iba.dto.req.ResetDto;

public interface MailService {
    void recoveryPassword(Long id, String email);
    void resetPassword(ResetDto resetDto);
}
