package com.kymryd.starfood.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OrderLineEntityPK implements Serializable {
    private int orderId;
    private int orderLineNumber;

    @Column(name = "order_id", nullable = false)
    @Id
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Column(name = "order_line_number", nullable = false)
    @Id
    public int getOrderLineNumber() {
        return orderLineNumber;
    }

    public void setOrderLineNumber(int orderLineNumber) {
        this.orderLineNumber = orderLineNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderLineEntityPK that = (OrderLineEntityPK) o;
        return orderId == that.orderId &&
                orderLineNumber == that.orderLineNumber;
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, orderLineNumber);
    }
}
