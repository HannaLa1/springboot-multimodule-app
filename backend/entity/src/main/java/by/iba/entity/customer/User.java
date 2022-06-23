package by.iba.entity.customer;

import by.iba.entity.FullAbstractEntity;
import by.iba.entity.sparepart.Image;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class User extends FullAbstractEntity {

    @Column(name = "username", nullable = false, unique = true)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {
                    @JoinColumn(
                            name = "user_id",
                            referencedColumnName = "id"),
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id",
                            referencedColumnName = "id")
            })
    private Set<Role> roles = new HashSet<>();

    @Column(name = "recovery_token", unique = true)
    private String recoveryToken;

    @Column(name = "token_creation_date")
    private LocalDateTime tokenCreationDate;

    @Column(name = "last_Visited_Date")
    private LocalDateTime lastVisitedDate;

    @Column(name = "account_status", nullable = false)
    @Enumerated
    private AccountStatus accountStatus = AccountStatus.PENDING;

    @OneToOne(fetch = FetchType.LAZY)
    private Image image;
}
