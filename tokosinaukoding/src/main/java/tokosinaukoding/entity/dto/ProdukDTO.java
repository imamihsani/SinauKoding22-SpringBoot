package tokosinaukoding.entity.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProdukDTO {
    private Long id;

    private String name;

    private Double price;

    private Integer stock;
}