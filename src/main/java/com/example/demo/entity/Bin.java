package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity(name = "Bin")
@Table(name = "bins")
public class Bin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User user;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    private List<BinItem> binItems = new ArrayList<>();

    public Bin() {
    }

    public Bin(long id, User user, List<BinItem> binItems) {
        this.id = id;
        this.user = user;
        this.binItems = binItems;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<BinItem> getBinItems() {
        return binItems;
    }

    public void setBinItems(List<BinItem> binItems) {
        this.binItems = binItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bin)) return false;
        Bin bin = (Bin) o;
        return getId() == bin.getId() &&
                Objects.equals(getUser(), bin.getUser()) &&
                getBinItems().equals(bin.getBinItems());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getUser(), getBinItems());
    }
}
