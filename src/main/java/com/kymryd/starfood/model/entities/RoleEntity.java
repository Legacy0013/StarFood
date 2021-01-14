package com.kymryd.starfood.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "role", schema = "dbo", catalog = "DB_STARFOOD")
public class RoleEntity implements Serializable {
    private int roleId;
    private String roleShortDescription;
    private Set<UserEntity> usersByRoleId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "role_short_description", nullable = false, length = 50)
    public String getRoleShortDescription() {
        return roleShortDescription;
    }

    public void setRoleShortDescription(String roleShortDescription) {
        this.roleShortDescription = roleShortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleEntity that = (RoleEntity) o;
        return roleId == that.roleId &&
                Objects.equals(roleShortDescription, that.roleShortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roleId, roleShortDescription);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "roleByRoleId")
    public Set<UserEntity> getUsersByRoleId() {
        return usersByRoleId;
    }

    public void setUsersByRoleId(Set<UserEntity> usersByRoleId) {
        this.usersByRoleId = usersByRoleId;
    }
}
