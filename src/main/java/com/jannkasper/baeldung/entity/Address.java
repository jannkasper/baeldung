package com.jannkasper.baeldung.entity;

import lombok.Data;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@ToString
@Data
@Accessors(chain = true)
public class Address {

    @Column(name = "Address")
    private String address;
    @Column(name = "City")
    private String city;
    @Column(name = "PostalCode")
    private String postalCode;
    @Column(name = "Country")
    private String country;
}
