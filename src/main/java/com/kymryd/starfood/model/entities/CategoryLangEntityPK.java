package com.kymryd.starfood.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class CategoryLangEntityPK implements Serializable {
    private int categoryId;
    private int langId;

    @Column(name = "category_id", nullable = false)
    @Id
    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
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
        CategoryLangEntityPK that = (CategoryLangEntityPK) o;
        return categoryId == that.categoryId &&
                langId == that.langId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(categoryId, langId);
    }
}
