package com.prog2.ecommerce.model;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//many to many relationship
@Entity
@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
public class Cart {

    @EmbeddedId
    CartKey cartKey;

    @ManyToOne
    @MapsId("product_id")
    @JoinColumn(name = "product_id")
    Product product;

    @ManyToOne
    @MapsId("user_id")
    @JoinColumn(name = "user_id")
    User user;
}
