package com.devsuperior.DScommercenovo.dto;

import com.devsuperior.DScommercenovo.entities.OrderItem;

public class OrderItemDTO {

    private Long productId;
    private String name;
    private Double price;
    private Integer quantity;
    private String imgUrl;

    //OBSERVAÇÃO: SUBTOTAL É UM CAMPO CALCULADO! NÃO ADICIONAMOS ELE COMO ATRIBUTO, E SIM COMO MÉTODO.

    public OrderItemDTO(Long productId, String name, Double price, Integer quantity, String imgUrl) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.imgUrl = imgUrl;
    }

    public OrderItemDTO(OrderItem entity) {
        productId = entity.getProduct().getId();
        name = entity.getProduct().getName();
        price = entity.getPrice();
        quantity = entity.getQuantity();
        imgUrl = entity.getProduct().getImgUrl();
    }

    public Long getProductId() {
        return productId;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    //O nome do método precisa ter o get e ser igual ao json
    public Double getSubTotal(){
        return price * quantity;
    }

    public String getImgUrl() {
        return imgUrl;
    }
}
