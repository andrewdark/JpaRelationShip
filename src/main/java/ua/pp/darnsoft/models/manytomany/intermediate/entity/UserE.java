package ua.pp.darnsoft.models.manytomany.intermediate.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "APP_USER_UC", columnNames = "user_name")})
public class UserE {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_name", length = 36, nullable = false)
    @Size(min = 2)
    private String userName;

    @Column(name = "encrypted_password", length = 128, nullable = false)
    @Size(min = 6)
    private String encryptedPassword;

    @Column(name = "enabled", length = 1, nullable = false)
    private Boolean enabled;

    @OneToMany(mappedBy = "user")
    private Set<RoledUser> roledUsers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Set<RoledUser> getRoledUsers() {
        return roledUsers;
    }

    public void setRoledUsers(Set<RoledUser> roledUsers) {
        this.roledUsers = roledUsers;
    }
}
