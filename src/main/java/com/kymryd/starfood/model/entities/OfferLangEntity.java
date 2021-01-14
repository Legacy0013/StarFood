package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "offer_lang", schema = "dbo", catalog = "DB_STARFOOD")
@IdClass(OfferLangEntityPK.class)
public class OfferLangEntity {
    private int offerId;
    private int langId;
    private String offerLangShortDescription;
    private String offerLangLongDescription;
    private OfferEntity offerByOfferId;
    private LangEntity langByLangId;

    @Id
    @Column(name = "offer_id", nullable = false)
    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    @Id
    @Column(name = "lang_id", nullable = false)
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Basic
    @Column(name = "offer_lang_short_description", nullable = false, length = 255)
    public String getOfferLangShortDescription() {
        return offerLangShortDescription;
    }

    public void setOfferLangShortDescription(String offerLangShortDescription) {
        this.offerLangShortDescription = offerLangShortDescription;
    }

    @Basic
    @Column(name = "offer_lang_long_description", nullable = false, length = -1)
    public String getOfferLangLongDescription() {
        return offerLangLongDescription;
    }

    public void setOfferLangLongDescription(String offerLangLongDescription) {
        this.offerLangLongDescription = offerLangLongDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferLangEntity that = (OfferLangEntity) o;
        return offerId == that.offerId &&
                langId == that.langId &&
                Objects.equals(offerLangShortDescription, that.offerLangShortDescription) &&
                Objects.equals(offerLangLongDescription, that.offerLangLongDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, langId, offerLangShortDescription, offerLangLongDescription);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "offer_id", referencedColumnName = "offer_id", nullable = false, insertable = false, updatable = false)
    public OfferEntity getOfferByOfferId() {
        return offerByOfferId;
    }

    public void setOfferByOfferId(OfferEntity offerByOfferId) {
        this.offerByOfferId = offerByOfferId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lang_id", referencedColumnName = "lang_id", nullable = false, insertable = false, updatable = false)
    public LangEntity getLangByLangId() {
        return langByLangId;
    }

    public void setLangByLangId(LangEntity langByLangId) {
        this.langByLangId = langByLangId;
    }
}
