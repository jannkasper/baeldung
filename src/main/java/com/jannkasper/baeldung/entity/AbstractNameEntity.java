package com.jannkasper.baeldung.entity;

import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Data
@Accessors(chain = true)
public class AbstractNameEntity extends AbstractEntity {

    @Column(name = "name")
    private String name;
}
