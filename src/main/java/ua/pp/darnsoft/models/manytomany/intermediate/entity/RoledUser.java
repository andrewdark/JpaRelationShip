package ua.pp.darnsoft.models.manytomany.intermediate.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "ROLE_USER")
@org.hibernate.annotations.Immutable
public class RoledUser {

    @Embeddable
    public static class Id implements Serializable {
        @Column(name = "ROLE_ID")
        protected Long RoleId;
        @Column(name = "USER_ID")
        protected Long UserId;

        public Id() {
        }

        public Id(Long roleId, Long userId) {
            RoleId = roleId;
            UserId = userId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Id)) return false;
            Id id = (Id) o;
            return Objects.equals(RoleId, id.RoleId) &&
                    Objects.equals(UserId, id.UserId);
        }

        @Override
        public int hashCode() {

            return Objects.hash(RoleId, UserId);
        }
    }

    @EmbeddedId
    protected Id id = new Id();

    @Column(updatable = false, nullable = false)
    @NotNull
    protected Date addedOn = new Date();

    @ManyToOne
    @JoinColumn(
            name = "ROLE_ID",
            updatable = false, insertable = false
    )
    protected RoleE role;

    @ManyToOne
    @JoinColumn(
            name = "USER_ID",
            updatable = false, insertable = false
    )
    protected UserE user;

    public RoledUser() {
    }

    public RoledUser(RoleE role, UserE user) {
        //SET values to the Classes fields.
        this.user = user;
        this.role = role;
        //Set the values to the Identificator.
        this.id.RoleId = role.getId();
        this.id.UserId = user.getId();
        //Ensures referential integrity if the connection is bidirectional.
        role.getRoledUsers().add(this);
        user.getRoledUsers().add(this);
    }

    public Id getId() {
        return id;
    }

    public Date getAddedOn() {
        return addedOn;
    }

    public RoleE getRole() {
        return role;
    }

    public UserE getUser() {
        return user;
    }
}
