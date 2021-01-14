package com.kymryd.starfood.model.entities;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class ElementLangEntityPK implements Serializable {
    private int elementId;
    private int langId;

    @Column(name = "element_id", nullable = false)
    @Id
    public int getElementId() {
        return elementId;
    }

    public void setElementId(int elementId) {
        this.elementId = elementId;
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
        ElementLangEntityPK that = (ElementLangEntityPK) o;
        return elementId == that.elementId &&
                langId == that.langId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(elementId, langId);
    }
}
