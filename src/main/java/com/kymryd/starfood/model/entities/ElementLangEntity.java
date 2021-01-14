package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "element_lang", schema = "dbo", catalog = "DB_STARFOOD")
@IdClass(ElementLangEntityPK.class)
public class ElementLangEntity {
    private int elementId;
    private int langId;
    private String elementLangLongDescription;
    private LangEntity langByLangId;

    @Id
    @Column(name = "element_id", nullable = false)
    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
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
    @Column(name = "element_lang_long_description", nullable = false, length = 255)
    public String getElementLangLongDescription() {
        return elementLangLongDescription;
    }

    public void setElementLangLongDescription(String elementLangLongDescription) {
        this.elementLangLongDescription = elementLangLongDescription;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ElementLangEntity that = (ElementLangEntity) o;
        return elementId == that.elementId &&
                langId == that.langId &&
                Objects.equals(elementLangLongDescription, that.elementLangLongDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementId, langId, elementLangLongDescription);
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
