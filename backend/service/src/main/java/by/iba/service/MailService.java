package by.iba.service;

import by.iba.dto.ResetDto;

public interface MailService {
    void recoveryPassword(Long id, String email);
    void resetPassword(ResetDto resetDto);
}
