package com.kymryd.starfood.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "status", schema = "dbo", catalog = "DB_STARFOOD")
public class StatusEntity {
    private int statusId;
    private String statusShortDescription;
    private Set<CategoryEntity> categoriesByStatusId;
    private Set<OrderLineEntity> orderLinesByStatusId;
    private Set<ProductEntity> productsByStatusId;
    private Set<UserEntity> usersByStatusId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id", nullable = false)
    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }

    @Basic
    @Column(name = "status_short_description", nullable = false, length = 50)
    public String getStatusShortDescription() {
        return statusShortDescription;
    }

    public void setStatusShortDescription(String statusShortDescription) {
        this.statusShortDescription = statusShortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StatusEntity that = (StatusEntity) o;
        return statusId == that.statusId &&
                Objects.equals(statusShortDescription, that.statusShortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(statusId, statusShortDescription);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "statusByStatusId")
    public Set<CategoryEntity> getCategoriesByStatusId() {
        return categoriesByStatusId;
    }

    public void setCategoriesByStatusId(Set<CategoryEntity> categoriesByStatusId) {
        this.categoriesByStatusId = categoriesByStatusId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "statusByStatusId")
    public Set<OrderLineEntity> getOrderLinesByStatusId() {
        return orderLinesByStatusId;
    }

    public void setOrderLinesByStatusId(Set<OrderLineEntity> orderLinesByStatusId) {
        this.orderLinesByStatusId = orderLinesByStatusId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "statusByStatusId")
    public Set<ProductEntity> getProductsByStatusId() {
        return productsByStatusId;
    }

    public void setProductsByStatusId(Set<ProductEntity> productsByStatusId) {
        this.productsByStatusId = productsByStatusId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "statusByStatusId")
    public Set<UserEntity> getUsersByStatusId() {
        return usersByStatusId;
    }

    public void setUsersByStatusId(Set<UserEntity> usersByStatusId) {
        this.usersByStatusId = usersByStatusId;
    }
}
