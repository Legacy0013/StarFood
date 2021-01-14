package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "payment_method", schema = "dbo", catalog = "DB_STARFOOD")
public class PaymentMethodEntity {
    private int paymentMethodId;
    private String paymentMethodShortDescription;
    private Set<OrderEntity> ordersByPaymentMethodId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_method_id", nullable = false)
    public int getPaymentMethodId() {
        return paymentMethodId;
    }

    public void setPaymentMethodId(int paymentMethodId) {
        this.paymentMethodId = paymentMethodId;
    }

    @Basic
    @Column(name = "payment_method_short_description", nullable = true, length = 255)
    public String getPaymentMethodShortDescription() {
        return paymentMethodShortDescription;
    }

    public void setPaymentMethodShortDescription(String paymentMethodShortDescription) {
        this.paymentMethodShortDescription = paymentMethodShortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PaymentMethodEntity that = (PaymentMethodEntity) o;
        return paymentMethodId == that.paymentMethodId &&
                Objects.equals(paymentMethodShortDescription, that.paymentMethodShortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(paymentMethodId, paymentMethodShortDescription);
    }

    @OneToMany(mappedBy = "paymentMethodByPaymentMethodId")
    public Set<OrderEntity> getOrdersByPaymentMethodId() {
        return ordersByPaymentMethodId;
    }

    public void setOrdersByPaymentMethodId(Set<OrderEntity> ordersByPaymentMethodId) {
        this.ordersByPaymentMethodId = ordersByPaymentMethodId;
    }
}
