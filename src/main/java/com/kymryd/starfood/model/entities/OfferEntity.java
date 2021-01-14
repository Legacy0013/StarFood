package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.sql.Date;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "offer", schema = "dbo", catalog = "DB_STARFOOD")
public class OfferEntity {
    private int offerId;
    private int productId;
    private Date offerStartDate;
    private double offerDiscountedPrice;
    private Date offerEndDate;
    private Set<OfferLangEntity> offerLangsByOfferId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "offer_id", nullable = false)
    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    @Basic
    @Column(name = "product_id", nullable = false)
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    @Basic
    @Column(name = "offer_start_date", nullable = false)
    public Date getOfferStartDate() {
        return offerStartDate;
    }

    public void setOfferStartDate(Date offerStartDate) {
        this.offerStartDate = offerStartDate;
    }

    @Basic
    @Column(name = "offer_discounted_price", nullable = false, precision = 0)
    public double getOfferDiscountedPrice() {
        return offerDiscountedPrice;
    }

    public void setOfferDiscountedPrice(double offerDiscountedPrice) {
        this.offerDiscountedPrice = offerDiscountedPrice;
    }

    @Basic
    @Column(name = "offer_end_date", nullable = false)
    public Date getOfferEndDate() {
        return offerEndDate;
    }

    public void setOfferEndDate(Date offerEndDate) {
        this.offerEndDate = offerEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferEntity that = (OfferEntity) o;
        return offerId == that.offerId &&
                productId == that.productId &&
                Double.compare(that.offerDiscountedPrice, offerDiscountedPrice) == 0 &&
                Objects.equals(offerStartDate, that.offerStartDate) &&
                Objects.equals(offerEndDate, that.offerEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, productId, offerStartDate, offerDiscountedPrice, offerEndDate);
    }

    @OneToMany(mappedBy = "offerByOfferId")
    public Set<OfferLangEntity> getOfferLangsByOfferId() {
        return offerLangsByOfferId;
    }

    public void setOfferLangsByOfferId(Set<OfferLangEntity> offerLangsByOfferId) {
        this.offerLangsByOfferId = offerLangsByOfferId;
    }
}
