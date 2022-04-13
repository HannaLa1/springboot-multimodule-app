package by.iba.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
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

    @Column(name = "image_url")
    private String imageUrl;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "user_account_status")
    private UserAccountStatus userAccountStatus;
}
