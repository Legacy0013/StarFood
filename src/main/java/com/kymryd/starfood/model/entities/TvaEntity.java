package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tva", schema = "dbo", catalog = "DB_STARFOOD")
public class TvaEntity {
    private int tvaId;
    private String tvaShortDescription;
    private double tvaRate;
    private Set<ProductEntity> productsByTvaId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "tva_id", nullable = false)
    public int getTvaId() {
        return tvaId;
    }

    public void setTvaId(int tvaId) {
        this.tvaId = tvaId;
    }

    @Basic
    @Column(name = "tva_short_description", nullable = false, length = 255)
    public String getTvaShortDescription() {
        return tvaShortDescription;
    }

    public void setTvaShortDescription(String tvaShortDescription) {
        this.tvaShortDescription = tvaShortDescription;
    }

    @Basic
    @Column(name = "tva_rate", nullable = false, precision = 0)
    public double getTvaRate() {
        return tvaRate;
    }

    public void setTvaRate(double tvaRate) {
        this.tvaRate = tvaRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TvaEntity tvaEntity = (TvaEntity) o;
        return tvaId == tvaEntity.tvaId &&
                Double.compare(tvaEntity.tvaRate, tvaRate) == 0 &&
                Objects.equals(tvaShortDescription, tvaEntity.tvaShortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tvaId, tvaShortDescription, tvaRate);
    }

    @OneToMany(mappedBy = "tvaByTvaId")
    public Set<ProductEntity> getProductsByTvaId() {
        return productsByTvaId;
    }

    public void setProductsByTvaId(Set<ProductEntity> productsByTvaId) {
        this.productsByTvaId = productsByTvaId;
    }
}
