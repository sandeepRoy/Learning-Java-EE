package ormcategoryproduct.ormcategoryproduct.entities;

import jakarta.json.bind.annotation.JsonbTransient;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "product")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer product_id;
    private String product_name;
    private String product_manufacturer;
    private Double product_price;
    private Integer product_inStock;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @JsonbTransient
    private Category category;
}
