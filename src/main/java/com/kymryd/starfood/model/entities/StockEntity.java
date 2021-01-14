package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "stock", schema = "dbo", catalog = "DB_STARFOOD")
@IdClass(StockEntityPK.class)
public class StockEntity {
    private int productId;
    private int locationId;
    private int stockQuantity;
    private ProductEntity productByProductId;
    private LocationEntity locationByLocationId;

    @Id
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Id
    @Column(name = "location_id", nullable = false)
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "stock_quantity", nullable = false)
    public int getStockQuantity() {
        return stockQuantity;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockEntity that = (StockEntity) o;
        return productId == that.productId &&
                locationId == that.locationId &&
                stockQuantity == that.stockQuantity;
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, locationId, stockQuantity);
    }

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "product_id", referencedColumnName = "product_id", nullable = false, insertable = false, updatable = false)
    public ProductEntity getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(ProductEntity productByProductId) {
        this.productByProductId = productByProductId;
    }

    @ManyToOne(fetch = FetchType.LAZY)

    @JoinColumn(name = "location_id", referencedColumnName = "location_id", nullable = false, insertable = false, updatable = false)
    public LocationEntity getLocationByLocationId() {
        return locationByLocationId;
    }

    public void setLocationByLocationId(LocationEntity locationByLocationId) {
        this.locationByLocationId = locationByLocationId;
    }
}
