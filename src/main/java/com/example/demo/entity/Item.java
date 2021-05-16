package com.example.demo.entity;

import com.example.demo.utils.enums.Category;
import com.vladmihalcea.hibernate.type.array.EnumArrayType;
import com.vladmihalcea.hibernate.type.array.ListArrayType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.TypeDef;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity(name = "Item")
@Table(name = "items")
@TypeDef(name = "list-array", typeClass = ListArrayType.class)
@TypeDef(name = "enum-array", typeClass = EnumArrayType.class)
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    @NotBlank(message = "Name is mandatory")
    private String name;

    @Column(name = "description")
    @NotBlank(message = "Description is mandatory")
    private String description;

    @Type(type = "list-array")
    @Column(
            name = "photos",
            columnDefinition = "text[]"
    )
    private List<String> photos;

    @Column(name = "price")
    @NotBlank(message = "Price is mandatory")
    private double price;

    @Column(name="added")
    private LocalDateTime added;

    @Type(type = "list-array")
    @Column(
            name = "sizes",
            columnDefinition = "text[]"
    )
    @NotBlank(message = "Sizes are mandatory")
    private List<String> sizes;

    @Type(type = "list-array")
    @Column(
            name = "colours",
            columnDefinition = "text[]"
    )
    private List<String> colours;

    @Column(name = "category")
    @NotBlank(message = "Category is mandatory")
    private Category category;

    @Column(name = "oldprice")
    private double oldPrice;

    public Item() {
    }

    public Item(long id,
                @NotBlank(message = "Name is mandatory") String name,
                @NotBlank(message = "Description is mandatory") String description,
                List<String> photos,
                @NotBlank(message = "Price is mandatory") double price,
                LocalDateTime added,
                @NotBlank(message = "Sizes are mandatory") List<String> sizes,
                List<String> colours,
                @NotBlank(message = "Category is mandatory") Category category,
                double oldPrice) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.photos = photos;
        this.price = price;
        this.added = added;
        this.sizes = sizes;
        this.colours = colours;
        this.category = category;
        this.oldPrice = oldPrice;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPhotos() {
        return photos;
    }

    public void setPhotos(List<String> photos) {
        this.photos = photos;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDateTime getAdded() {
        return added;
    }

    public void setAdded(LocalDateTime added) {
        this.added = added;
    }

    public List<String> getSizes() {
        return sizes;
    }

    public void setSizes(List<String> sizes) {
        this.sizes = sizes;
    }

    public List<String> getColours() {
        return colours;
    }

    public void setColours(List<String> colours) {
        this.colours = colours;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public double getOldPrice() {
        return oldPrice;
    }

    public void setOldPrice(double oldPrice) {
        this.oldPrice = oldPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Item)) return false;
        Item item = (Item) o;
        return getId() == item.getId() &&
                Double.compare(item.getPrice(), getPrice()) == 0 &&
                Double.compare(item.getOldPrice(), getOldPrice()) == 0 &&
                getName().equals(item.getName()) &&
                getDescription().equals(item.getDescription()) &&
                Objects.equals(getPhotos(), item.getPhotos()) &&
                Objects.equals(getAdded(), item.getAdded()) &&
                getSizes().equals(item.getSizes()) &&
                Objects.equals(getColours(), item.getColours()) &&
                getCategory() == item.getCategory();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDescription(), getPhotos(),
                getPrice(), getAdded(), getSizes(), getColours(), getCategory(),
                getOldPrice());
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", photos=" + photos +
                ", price=" + price +
                ", added=" + added +
                ", sizes=" + sizes +
                ", colours=" + colours +
                ", category=" + category +
                ", oldPrice=" + oldPrice +
                '}';
    }
}
