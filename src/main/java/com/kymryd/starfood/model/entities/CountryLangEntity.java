package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "country_lang", schema = "dbo", catalog = "DB_STARFOOD")
@IdClass(CountryLangEntityPK.class)
public class CountryLangEntity {
    private int countryId;
    private int langId;
    private int countryLangShortDescription;
    private CountryEntity countryByCountryId;
    private LangEntity langByLangId;

    @Id
    @Column(name = "country_id", nullable = false)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
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
    @Column(name = "country_lang_short_description", nullable = false)
    public int getCountryLangShortDescription() {
        return countryLangShortDescription;
    }

    public void setCountryLangShortDescription(int countryLangShortDescription) {
        this.countryLangShortDescription = countryLangShortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryLangEntity that = (CountryLangEntity) o;
        return countryId == that.countryId &&
                langId == that.langId &&
                countryLangShortDescription == that.countryLangShortDescription;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, langId, countryLangShortDescription);
    }


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false,insertable = false, updatable = false)
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
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
