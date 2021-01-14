package com.kymryd.starfood.model.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "country", schema = "dbo", catalog = "DB_STARFOOD")
public class CountryEntity {
    private int countryId;
    private int countrySequence;
    private String countryISO;
    private Set<AddressEntity> addressesByCountryId;
    private Set<CountryLangEntity> countryLangsByCountryId;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "country_id", nullable = false)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "country_sequence", nullable = false)
    public int getCountrySequence() {
        return countrySequence;
    }

    public void setCountrySequence(int countrySequence) {
        this.countrySequence = countrySequence;
    }

    @Basic
    @Column(name = "country_ISO", nullable = false)
    public String getCountryISO() {
        return countryISO;
    }

    public void setCountryISO(String countryISO) {
        this.countryISO = countryISO;
    }




    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CountryEntity that = (CountryEntity) o;
        return countryId == that.countryId &&
                countrySequence == that.countrySequence;
    }

    @Override
    public int hashCode() {
        return Objects.hash(countryId, countrySequence);
    }

    @JsonIgnore
    @OneToMany(mappedBy = "countryByCountryId", cascade = CascadeType.ALL) // suppression des adresses si le pays est supprimé...
    public Set<AddressEntity> getAddressesByCountryId() {
        return addressesByCountryId;
    }

    public void setAddressesByCountryId(Set<AddressEntity> addressesByCountryId) {
        this.addressesByCountryId = addressesByCountryId;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "countryByCountryId", cascade = CascadeType.ALL) //suppression des traductions si le pays est supprimé
    public Set<CountryLangEntity> getCountryLangsByCountryId() {
        return countryLangsByCountryId;
    }

    public void setCountryLangsByCountryId(Set<CountryLangEntity> countryLangsByCountryId) {
        this.countryLangsByCountryId = countryLangsByCountryId;
    }
}
