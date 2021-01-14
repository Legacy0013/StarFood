package com.kymryd.starfood.model.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "menu", schema = "dbo", catalog = "DB_STARFOOD")
public class MenuEntity {
    private int menuId;
    private int menuMain;
    private Set<ProductEntity> productByMenuMain;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "menu_id", nullable = false)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Basic
    @Column(name = "menu_main", nullable = false)
    public int getMenuMain() {
        return menuMain;
    }

    public void setMenuMain(int menuMain) {
        this.menuMain = menuMain;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MenuEntity that = (MenuEntity) o;
        return menuId == that.menuId &&
                menuMain == that.menuMain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(menuId, menuMain);
    }

    @ManyToMany
    @JoinColumn(name = "menu_main", referencedColumnName = "product_id", nullable = false, insertable = false, updatable = false)
    public Set<ProductEntity> getProductByMenuMain() {
        return productByMenuMain;
    }

    public void setProductByMenuMain(Set<ProductEntity> productByMenuMain) {
        this.productByMenuMain = productByMenuMain;
    }
}
