package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "[order]", schema = "dbo", catalog = "DB_STARFOOD")
public class OrderEntity {
    private int orderId;
    private Integer userIdCustomer;
    private int orderWeigth;
    private int originId;
    private int userIdOrigin;
    private Integer paymentMethodId;
    private int orderStatusId;
    private UserEntity userByUserIdCustomer;
    private OriginEntity originByOriginId;
    private UserEntity userByUserIdOrigin;
    private PaymentMethodEntity paymentMethodByPaymentMethodId;
    private OrderStatusEntity orderStatusByOrderStatusId;
    private Set<OrderLineEntity> orderLinesByOrderId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "user_id_customer", nullable = true)
    public Integer getUserIdCustomer() {
        return userIdCustomer;
    }

    public void setUserIdCustomer(Integer userIdCustomer) {
        this.userIdCustomer = userIdCustomer;
    }

    @Basic
    @Column(name = "order_weigth", nullable = false)
    public int getOrderWeigth() {
        return orderWeigth;
    }

    public void setOrderWeigth(int orderWeigth) {
        this.orderWeigth = orderWeigth;
    }

    @Basic
    @Column(name = "origin_id", nullable = false)
    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    @Basic
    @Column(name = "user_id_origin", nullable = false)
    public int getUserIdOrigin() {
        return userIdOrigin;
    }

    public void setUserIdOrigin(int userIdOrigin) {
        this.userIdOrigin = userIdOrigin;
    }

    @Basic
    @Column(name = "payment_method_id", nullable = true)
    public Integer getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(Integer paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @Basic
    @Column(name = "order_status_id", nullable = false)
    public int getOrderStatusId() {
        return orderStatusId;
    }

    public void setOrderStatusId(int orderStatusId) {
        this.orderStatusId = orderStatusId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderEntity that = (OrderEntity) o;
        return orderId == that.orderId &&
                orderWeigth == that.orderWeigth &&
                originId == that.originId &&
                userIdOrigin == that.userIdOrigin &&
                orderStatusId == that.orderStatusId &&
                Objects.equals(userIdCustomer, that.userIdCustomer) &&
                Objects.equals(paymentMethodId, that.paymentMethodId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, userIdCustomer, orderWeigth, originId, userIdOrigin, paymentMethodId, orderStatusId);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_customer", referencedColumnName = "user_id",nullable = false, insertable = false, updatable = false)
    public UserEntity getUserByUserIdCustomer() {
        return userByUserIdCustomer;
    }

    public void setUserByUserIdCustomer(UserEntity userByUserIdCustomer) {
        this.userByUserIdCustomer = userByUserIdCustomer;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "origin_id", referencedColumnName = "origin_id", nullable = false, insertable = false, updatable = false)
    public OriginEntity getOriginByOriginId() {
        return originByOriginId;
    }

    public void setOriginByOriginId(OriginEntity originByOriginId) {
        this.originByOriginId = originByOriginId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id_origin", referencedColumnName = "user_id", nullable = false, insertable = false,updatable = false)
    public UserEntity getUserByUserIdOrigin() {
        return userByUserIdOrigin;
    }

    public void setUserByUserIdOrigin(UserEntity userByUserIdOrigin) {
        this.userByUserIdOrigin = userByUserIdOrigin;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_method_id", referencedColumnName = "payment_method_id", insertable = false, updatable = false)
    public PaymentMethodEntity getPaymentMethodByPaymentMethodId() {
        return paymentMethodByPaymentMethodId;
    }

    public void setPaymentMethodByPaymentMethodId(PaymentMethodEntity paymentMethodByPaymentMethodId) {
        this.paymentMethodByPaymentMethodId = paymentMethodByPaymentMethodId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_status_id", referencedColumnName = "order_status_id", nullable = false, insertable = false, updatable = false)
    public OrderStatusEntity getOrderStatusByOrderStatusId() {
        return orderStatusByOrderStatusId;
    }

    public void setOrderStatusByOrderStatusId(OrderStatusEntity orderStatusByOrderStatusId) {
        this.orderStatusByOrderStatusId = orderStatusByOrderStatusId;
    }

    @OneToMany(mappedBy = "orderByOrderId")
    public Set<OrderLineEntity> getOrderLinesByOrderId() {
        return orderLinesByOrderId;
    }

    public void setOrderLinesByOrderId(Set<OrderLineEntity> orderLinesByOrderId) {
        this.orderLinesByOrderId = orderLinesByOrderId;
    }
}
//TODO : ajouter methodes @transcient pour total, etc.
