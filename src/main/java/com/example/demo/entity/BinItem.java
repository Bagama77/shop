package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity(name = "BinItem")
@Table(name = "binitems")
public class BinItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "item_id")
    private long itemId;

    @Column(name = "quantity")
    private int quantity;

    public BinItem() {
    }

    public BinItem(long id, long itemId, int quantity) {
        this.id = id;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getItemId() {
        return itemId;
    }

    public void setItemId(long itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BinItem)) return false;
        BinItem binItem = (BinItem) o;
        return getId() == binItem.getId() &&
                getItemId() == binItem.getItemId() &&
                getQuantity() == binItem.getQuantity();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getItemId(), getQuantity());
    }

    @Override
    public String toString() {
        return "BinItem{" +
                "id=" + id +
                ", itemId=" + itemId +
                ", quantity=" + quantity +
                '}';
    }
}
