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

@Data
@NoArgsConstructor
@AllArgsConstructor
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
}
