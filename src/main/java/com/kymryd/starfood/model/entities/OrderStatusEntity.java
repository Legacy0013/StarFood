package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "order_status", schema = "dbo", catalog = "DB_STARFOOD")
public class OrderStatusEntity {
    private int orderStatusId;
    private String orderStatusShortDescription;
    private Set<OrderEntity> ordersByOrderStatusId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_status_id", nullable = false)
    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Basic
    @Column(name = "order_status_short_description", nullable = false, length = 255)
    public String getOrderStatusShortDescription() {
        return orderStatusShortDescription;
    }

    public void setOrderStatusShortDescription(String orderStatusShortDescription) {
        this.orderStatusShortDescription = orderStatusShortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderStatusEntity that = (OrderStatusEntity) o;
        return orderStatusId == that.orderStatusId &&
                Objects.equals(orderStatusShortDescription, that.orderStatusShortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderStatusId, orderStatusShortDescription);
    }

    @OneToMany(mappedBy = "orderStatusByOrderStatusId")
    public Set<OrderEntity> getOrdersByOrderStatusId() {
        return ordersByOrderStatusId;
    }

    public void setOrdersByOrderStatusId(Set<OrderEntity> ordersByOrderStatusId) {
        this.ordersByOrderStatusId = ordersByOrderStatusId;
    }
}
