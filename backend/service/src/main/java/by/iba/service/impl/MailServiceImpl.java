package by.iba.service.impl;

import by.iba.dto.ResetDto;
import by.iba.entity.customer.User;
import by.iba.exception.ResourceNotFoundException;
import by.iba.exception.ServiceException;
import by.iba.exception.TokenExpiredException;
import by.iba.repository.UserRepository;
import by.iba.service.MailService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.UUID;

import static by.iba.constants.Constant.EXPIRE_TOKEN_AFTER_MINUTES;
import static by.iba.constants.Constant.RECOVERY_EMAIL;

@Service
@Slf4j
@AllArgsConstructor
public class MailServiceImpl implements MailService {

    private final UserRepository userRepository;
    private final JavaMailSender javaMailSender;
    private final PasswordEncoder encoder;

    @Override
    public void recoveryPassword(Long userId, String email) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User with id: " + userId + " not found"));

        if(!email.equals(RECOVERY_EMAIL)){
            throw new ServiceException("Cannot send mail to this address!");
        }

        user.setRecoveryToken(generateToken());
        user.setTokenCreationDate(LocalDateTime.now());
        userRepository.save(user);

        SimpleMailMessage mail = new SimpleMailMessage();
        mail.setTo(email);
        mail.setSubject("Mail API with token to recovery password");
        mail.setText("Your token to recovery password is " + user.getRecoveryToken());

        javaMailSender.send(mail);
    }

    @Override
    public void resetPassword(ResetDto resetDto) {
        String token = resetDto.getRecovery_token();

        User user = userRepository.findByRecoveryToken(token)
                .orElseThrow(() -> new ResourceNotFoundException("User with recovery token: " + token
                        + " not found"));

        if (isTokenExpired(user.getTokenCreationDate())) {
            throw new TokenExpiredException("Token expired!");
        }

        user.setPassword(encoder.encode(resetDto.getPassword()));
        user.setRecoveryToken(null);
        user.setTokenCreationDate(null);

        userRepository.save(user);
    }

    private String generateToken() {
        StringBuilder token = new StringBuilder();

        return token
                .append(UUID.randomUUID())
                .append(UUID.randomUUID()).toString();
    }

    private boolean isTokenExpired(final LocalDateTime tokenCreationDate) {
        Duration duration = Duration.between(tokenCreationDate, LocalDateTime.now());

        return duration.toMinutes() >= EXPIRE_TOKEN_AFTER_MINUTES;
    }
}
