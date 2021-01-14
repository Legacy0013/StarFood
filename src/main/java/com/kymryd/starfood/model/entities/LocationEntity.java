package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "location", schema = "dbo", catalog = "DB_STARFOOD")
public class LocationEntity {
    private int locationId;
    private String locationShortDescription;
    private Set<StockEntity> stocksByLocationId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable = false)
    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    @Basic
    @Column(name = "location_short_description", nullable = true, length = 50)
    public String getLocationShortDescription() {
        return locationShortDescription;
    }

    public void setLocationShortDescription(String locationShortDescription) {
        this.locationShortDescription = locationShortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LocationEntity that = (LocationEntity) o;
        return locationId == that.locationId &&
                Objects.equals(locationShortDescription, that.locationShortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(locationId, locationShortDescription);
    }

    @OneToMany(mappedBy = "locationByLocationId")
    public Set<StockEntity> getStocksByLocationId() {
        return stocksByLocationId;
    }

    public void setStocksByLocationId(Set<StockEntity> stocksByLocationId) {
        this.stocksByLocationId = stocksByLocationId;
    }
}
