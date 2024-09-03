package ormcategoryproduct.ormcategoryproduct.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateProductDTO {
    private String product_name;
    private String product_manufacturer;
    private Double product_price;
    private Integer product_inStock;
    private Integer category_id;
}
