package by.wms.server.DTO;

import lombok.Data;

@Data
public class ProductDTO {

    private String name;
    private Integer waybill;
    private Double length;
    private Double width;
    private Double weight;
    private Double height;

}
