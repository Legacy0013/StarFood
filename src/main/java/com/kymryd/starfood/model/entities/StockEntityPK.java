package com.kymryd.starfood.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class StockEntityPK implements Serializable {
    private int productId;
    private int locationId;

    @Column(name = "product_id", nullable = false)
    @Id
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Column(name = "location_id", nullable = false)
    @Id
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockEntityPK that = (StockEntityPK) o;
        return productId == that.productId &&
                locationId == that.locationId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, locationId);
    }
}
