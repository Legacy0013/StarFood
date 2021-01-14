package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "origin", schema = "dbo", catalog = "DB_STARFOOD")
public class OriginEntity {
    private int originId;
    private String originShortDescription;
    private Set<OrderEntity> ordersByOriginId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "origin_id", nullable = false)
    public int getOriginId() {
        return originId;
    }

    public void setOriginId(int originId) {
        this.originId = originId;
    }

    @Basic
    @Column(name = "origin_short_description", nullable = false, length = 255)
    public String getOriginShortDescription() {
        return originShortDescription;
    }

    public void setOriginShortDescription(String originShortDescription) {
        this.originShortDescription = originShortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OriginEntity that = (OriginEntity) o;
        return originId == that.originId &&
                Objects.equals(originShortDescription, that.originShortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(originId, originShortDescription);
    }

    @OneToMany(mappedBy = "originByOriginId")
    public Set<OrderEntity> getOrdersByOriginId() {
        return ordersByOriginId;
    }

    public void setOrdersByOriginId(Set<OrderEntity> ordersByOriginId) {
        this.ordersByOriginId = ordersByOriginId;
    }
}
