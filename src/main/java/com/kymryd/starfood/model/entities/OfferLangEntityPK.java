package com.kymryd.starfood.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class OfferLangEntityPK implements Serializable {
    private int offerId;
    private int langId;

    @Column(name = "offer_id", nullable = false)
    @Id
    public int getOfferId() {
        return offerId;
    }

    public void setOfferId(int offerId) {
        this.offerId = offerId;
    }

    @Column(name = "lang_id", nullable = false)
    @Id
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OfferLangEntityPK that = (OfferLangEntityPK) o;
        return offerId == that.offerId &&
                langId == that.langId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(offerId, langId);
    }
}
