package com.jannkasper.baeldung.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;

@Entity
@Table(name = "suppliers")
@Data
@Accessors(chain = true)
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "SupplierID")),
        @AttributeOverride(name = "name", column = @Column(name = "SupplierName"))
})
@ToString
public class Supplier extends AbstractNameEntity {

    @Column(name = "ContactName")
    private String contactName;
    @Embedded
    Address address;
//    @OneToMany(mappedBy = "supplier", targetEntity = Product.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
//    private Set<Product> products = new HashSet<Product>();

}
