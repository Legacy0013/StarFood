package com.kymryd.starfood.model.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "category_lang", schema = "dbo", catalog = "DB_STARFOOD")
@IdClass(CategoryLangEntityPK.class)
public class CategoryLangEntity {
    private int categoryId;
    private int langId;
    private CategoryEntity categoryByCategoryId;
    private LangEntity langByLangId;
    private String categoryLangShortDescription;
    private String categoryLangLongDescription;


    @Id
    @Column(name = "category_id", nullable = false)
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
    @Column(name = "category_lang_short_description", nullable = true, length = 50)
    public String getCategoryLangShortDescription() {
        return categoryLangShortDescription;
    }

    public void setCategoryLangShortDescription(String categoryLangShortDescription) {
        this.categoryLangShortDescription = categoryLangShortDescription;
    }


    @Basic
    @Column(name = "category_lang_long_description", nullable = true, length = 50)
    public String getCategoryLangLongDescription() {
        return categoryLangLongDescription;
    }

    public void setCategoryLangLongDescription(String categoryLangLongDescription) {
        this.categoryLangLongDescription = categoryLangLongDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryLangEntity that = (CategoryLangEntity) o;
        return categoryId == that.categoryId &&
                langId == that.langId &&
                categoryByCategoryId.equals(that.categoryByCategoryId) &&
                langByLangId.equals(that.langByLangId) &&
                categoryLangShortDescription.equals(that.categoryLangShortDescription) &&
                categoryLangLongDescription.equals(that.categoryLangLongDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, langId, categoryByCategoryId, langByLangId, categoryLangShortDescription, categoryLangLongDescription);
    }

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "category_id", nullable = false, insertable = false, updatable = false)
    public CategoryEntity getCategoryByCategoryId() {
        return categoryByCategoryId;
    }

    public void setCategoryByCategoryId(CategoryEntity categoryByCategoryId) {
        this.categoryByCategoryId = categoryByCategoryId;
    }

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "lang_id", referencedColumnName = "lang_id", nullable = false, insertable = false, updatable = false)
    public LangEntity getLangByLangId() {
        return langByLangId;
    }

    public void setLangByLangId(LangEntity langByLangId) {
        this.langByLangId = langByLangId;
    }
}
