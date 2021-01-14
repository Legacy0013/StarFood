package com.kymryd.starfood.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "lang", schema = "dbo", catalog = "DB_STARFOOD")
public class LangEntity {
    private int langId;
    @Size(min = 5, max = 8, message = "la desc doit faire entre 5 et 8 caractères")
    private String langShortDescription;
    private Set<CategoryLangEntity> categoryLangsByLangId;
    private Set<CountryLangEntity> countryLangsByLangId;
    private Set<ElementLangEntity> elementLangsByLangId;
    private Set<OfferLangEntity> offerLangsByLangId;
    private Set<ProductLangEntity> productLangsByLangId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lang_id", nullable = false)
    public int getLangId() {
        return langId;
    }

    public void setLangId(int langId) {
        this.langId = langId;
    }

    @Basic
    @Column(name = "lang_short_description", nullable = false, length = 50)
    public String getLangShortDescription() {
        return langShortDescription;
    }

    public void setLangShortDescription(String langShortDescription) {
        this.langShortDescription = langShortDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LangEntity that = (LangEntity) o;
        return langId == that.langId &&
                langShortDescription.equals(that.langShortDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(langId, langShortDescription);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "langByLangId")
    public Set<CategoryLangEntity> getCategoryLangsByLangId() {
        return categoryLangsByLangId;
    }

    public void setCategoryLangsByLangId(Set<CategoryLangEntity> categoryLangsByLangId) {
        this.categoryLangsByLangId = categoryLangsByLangId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "langByLangId")
    public Set<CountryLangEntity> getCountryLangsByLangId() {
        return countryLangsByLangId;
    }

    public void setCountryLangsByLangId(Set<CountryLangEntity> countryLangsByLangId) {
        this.countryLangsByLangId = countryLangsByLangId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "langByLangId")
    public Set<ElementLangEntity> getElementLangsByLangId() {
        return elementLangsByLangId;
    }

    public void setElementLangsByLangId(Set<ElementLangEntity> elementLangsByLangId) {
        this.elementLangsByLangId = elementLangsByLangId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "langByLangId")
    public Set<OfferLangEntity> getOfferLangsByLangId() {
        return offerLangsByLangId;
    }

    public void setOfferLangsByLangId(Set<OfferLangEntity> offerLangsByLangId) {
        this.offerLangsByLangId = offerLangsByLangId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "langByLangId")
    public Set<ProductLangEntity> getProductLangsByLangId() {
        return productLangsByLangId;
    }

    public void setProductLangsByLangId(Set<ProductLangEntity> productLangsByLangId) {
        this.productLangsByLangId = productLangsByLangId;
    }
}
