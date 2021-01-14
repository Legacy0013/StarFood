package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "order_line", schema = "dbo", catalog = "DB_STARFOOD")
@IdClass(OrderLineEntityPK.class)
public class OrderLineEntity {
    private int orderId;
    private int productId;
    private int orderLineNumber;
    private int orderLineQuantity;
    private int statusId;
    private Integer orderLineType;
    private Boolean orderLineIsFree;
    private OrderEntity orderByOrderId;
    private StatusEntity statusByStatusId;

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Id
    @Column(name = "order_line_number", nullable = false)
    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Basic
    @Column(name = "order_line_quantity", nullable = false)
    public int getOrderLineQuantity() {
        return orderLineQuantity;
    }

    public void setOrderLineQuantity(int orderLineQuantity) {
        this.orderLineQuantity = orderLineQuantity;
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
    @Column(name = "order_line_type", nullable = true)
    public Integer getOrderLineType() {
        return orderLineType;
    }

    public void setOrderLineType(Integer orderLineType) {
        this.orderLineType = orderLineType;
    }

    @Basic
    @Column(name = "order_line_is_free", nullable = true)
    public Boolean getOrderLineIsFree() {
        return orderLineIsFree;
    }

    public void setOrderLineIsFree(Boolean orderLineIsFree) {
        this.orderLineIsFree = orderLineIsFree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineEntity that = (OrderLineEntity) o;
        return orderId == that.orderId &&
                productId == that.productId &&
                orderLineNumber == that.orderLineNumber &&
                orderLineQuantity == that.orderLineQuantity &&
                statusId == that.statusId &&
                Objects.equals(orderLineType, that.orderLineType) &&
                Objects.equals(orderLineIsFree, that.orderLineIsFree);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, productId, orderLineNumber, orderLineQuantity, statusId, orderLineType, orderLineIsFree);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", referencedColumnName = "order_id", nullable = false, insertable = false, updatable = false)
    public OrderEntity getOrderByOrderId() {
        return orderByOrderId;
    }

    public void setOrderByOrderId(OrderEntity orderByOrderId) {
        this.orderByOrderId = orderByOrderId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status_id", referencedColumnName = "status_id", nullable = false, insertable = false, updatable = false)
    public StatusEntity getStatusByStatusId() {
        return statusByStatusId;
    }

    public void setStatusByStatusId(StatusEntity statusByStatusId) {
        this.statusByStatusId = statusByStatusId;
    }
}
