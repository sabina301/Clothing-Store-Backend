package com.myclothingstore.backend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "products")
@DynamicUpdate
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String productName;
    private String productDescription;
    private String productIcon;
    private Integer productPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnore
    private CategoryEntity categoryEntity;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ProductSizeEntity> sizes = new HashSet<>();

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "productEntity", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ProductInOrderEntity> productsInOrder = new HashSet<>();

    public void addSize(ProductSizeEntity productSizeEntity){
        sizes.add(productSizeEntity);
        productSizeEntity.setProductEntity(this);
    }

}
