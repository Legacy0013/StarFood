package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "company", schema = "dbo", catalog = "DB_STARFOOD")
public class CompanyEntity {
    private int companyId;
    private String companyName;
    private String companyAddress1;
    private String companyAddress2;
    private String companyPostalCode;
    private int countryId;
    private String companyPhoneNumber;
    private String companyEmail;
    private CountryEntity countryByCountryId;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "company_id", nullable = false)
    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    @Basic
    @Column(name = "company_name", nullable = false, length = 255)
    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    @Basic
    @Column(name = "company_address_1", nullable = false, length = 255)
    public String getCompanyAddress1() {
        return companyAddress1;
    }

    public void setCompanyAddress1(String companyAddress1) {
        this.companyAddress1 = companyAddress1;
    }

    @Basic
    @Column(name = "company_address_2", nullable = true, length = 255)
    public String getCompanyAddress2() {
        return companyAddress2;
    }

    public void setCompanyAddress2(String companyAddress2) {
        this.companyAddress2 = companyAddress2;
    }

    @Basic
    @Column(name = "company_postal_code", nullable = true, length = 10)
    public String getCompanyPostalCode() {
        return companyPostalCode;
    }

    public void setCompanyPostalCode(String companyPostalCode) {
        this.companyPostalCode = companyPostalCode;
    }

    @Basic
    @Column(name = "country_id", nullable = false)
    public int getCountryId() {
        return countryId;
    }

    public void setCountryId(int countryId) {
        this.countryId = countryId;
    }

    @Basic
    @Column(name = "company_phone_number", nullable = false, length = 255)
    public String getCompanyPhoneNumber() {
        return companyPhoneNumber;
    }

    public void setCompanyPhoneNumber(String companyPhoneNumber) {
        this.companyPhoneNumber = companyPhoneNumber;
    }

    @Basic
    @Column(name = "company_email", nullable = false, length = 255)
    public String getCompanyEmail() {
        return companyEmail;
    }

    public void setCompanyEmail(String companyEmail) {
        this.companyEmail = companyEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CompanyEntity that = (CompanyEntity) o;
        return companyId == that.companyId &&
                countryId == that.countryId &&
                Objects.equals(companyName, that.companyName) &&
                Objects.equals(companyAddress1, that.companyAddress1) &&
                Objects.equals(companyAddress2, that.companyAddress2) &&
                Objects.equals(companyPostalCode, that.companyPostalCode) &&
                Objects.equals(companyPhoneNumber, that.companyPhoneNumber) &&
                Objects.equals(companyEmail, that.companyEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(companyId, companyName, companyAddress1, companyAddress2, companyPostalCode, countryId, companyPhoneNumber, companyEmail);
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_id", referencedColumnName = "country_id", nullable = false, insertable = false, updatable = false)
    public CountryEntity getCountryByCountryId() {
        return countryByCountryId;
    }

    public void setCountryByCountryId(CountryEntity countryByCountryId) {
        this.countryByCountryId = countryByCountryId;
    }
}
