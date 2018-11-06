package ua.pp.darnsoft.models.manytomany.intermediate.entity;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(uniqueConstraints = {@UniqueConstraint(name = "APP_ROLE_UC", columnNames = "role_name")})
public class RoleE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "role_name", length = 36, nullable = false)
    private String roleName;

    @OneToMany(mappedBy = "role")
    private Set<RoledUser> roledUsers = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<RoledUser> getRoledUsers() {
        return roledUsers;
    }

    public void setRoledUsers(Set<RoledUser> roledUsers) {
        this.roledUsers = roledUsers;
    }
}
