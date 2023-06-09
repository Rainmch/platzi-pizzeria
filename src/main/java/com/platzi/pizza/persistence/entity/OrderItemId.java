package com.platzi.pizza.persistence.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderItemId {
    private Integer idOrder;
    private Integer idItem;

    @Override
    public int hashCode() {
        return Objects.hash(idOrder, idItem);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj ) return true;
        if(!(obj instanceof OrderItemId that) ) return false;
        return Objects.equals(idOrder, that.idOrder) && Objects.equals(idItem, that.idItem);
    }
}
