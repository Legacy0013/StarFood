package com.kymryd.starfood.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CountryLangEntityPK implements Serializable {
    private int countryId;
    private int langId;

    @Column(name = "country_id", nullable = false)
    @Id
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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
        CountryLangEntityPK that = (CountryLangEntityPK) o;
        return countryId == that.countryId &&
                langId == that.langId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, langId);
    }
}
