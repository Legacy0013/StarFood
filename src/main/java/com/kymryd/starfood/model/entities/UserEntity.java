package com.kymryd.starfood.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "[user]", schema = "dbo", catalog = "DB_STARFOOD")
public class UserEntity implements Serializable {
    private int userId;
    private String userFirstname;
    private String userLastname;
    private String userEmail;
    private String userPhone;
    private int roleId;
    private int statusId;
    private String userPassword;
    private Set<AddressEntity> addressesByUserId;
    private Set<OrderEntity> ordersByUserId;
    private Set<OrderEntity> ordersByUserId_0;
    private RoleEntity roleByRoleId;
    private StatusEntity statusByStatusId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "user_firstname", nullable = false, length = 255)
    public String getUserFirstname() {
        return userFirstname;
    }

    public void setUserFirstname(String userFirstname) {
        this.userFirstname = userFirstname;
    }

    @Basic
    @Column(name = "user_lastname", nullable = false, length = 255)
    public String getUserLastname() {
        return userLastname;
    }

    public void setUserLastname(String userLastname) {
        this.userLastname = userLastname;
    }

    @Basic
    @Column(name = "user_email", nullable = false, length = 255)
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Basic
    @Column(name = "user_phone", nullable = false, length = 50)
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "role_id", nullable = false)
    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "status_id", nullable = false)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }


    @Basic
    @Column(name = "user_password")
    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserEntity that = (UserEntity) o;
        return userId == that.userId &&
//                roleId == that.roleId &&
                statusId == that.statusId &&
                Objects.equals(userFirstname, that.userFirstname) &&
                Objects.equals(userLastname, that.userLastname) &&
                Objects.equals(userEmail, that.userEmail) &&
                Objects.equals(userPhone, that.userPhone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(userId, userFirstname, userLastname, userEmail, userPhone, /*roleId, */statusId);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userByUserId")
    public Set<AddressEntity> getAddressesByUserId() {
        return addressesByUserId;
    }

    public void setAddressesByUserId(Set<AddressEntity> addressesByUserId) {
        this.addressesByUserId = addressesByUserId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userByUserIdCustomer")
    public Set<OrderEntity> getOrdersByUserId() {
        return ordersByUserId;
    }

    public void setOrdersByUserId(Set<OrderEntity> ordersByUserId) {
        this.ordersByUserId = ordersByUserId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "userByUserIdOrigin")
    public Set<OrderEntity> getOrdersByUserId_0() {
        return ordersByUserId_0;
    }

    public void setOrdersByUserId_0(Set<OrderEntity> ordersByUserId_0) {
        this.ordersByUserId_0 = ordersByUserId_0;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER) //TODO passer en lazy en fournissant l'info au controller ?
    @JoinColumn(name = "role_id", referencedColumnName = "role_id", nullable = false, insertable = false, updatable = false)
    public RoleEntity getRoleByRoleId() {
        return roleByRoleId;
    }

    public void setRoleByRoleId(RoleEntity roleByRoleId) {
        this.roleByRoleId = roleByRoleId;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id", nullable = false, insertable = false, updatable = false)
    public StatusEntity getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(StatusEntity statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }
}
