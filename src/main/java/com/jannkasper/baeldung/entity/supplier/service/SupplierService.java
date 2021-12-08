package com.jannkasper.baeldung.entity.supplier.service;

import com.jannkasper.baeldung.entity.supplier.database.Supplier;
import com.jannkasper.baeldung.entity.supplier.database.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierService {

    SupplierRepository repository;

    @Autowired
    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public Integer create(Supplier newEntity) {
        return this.repository.create(newEntity);
    }

//    public Optional<Supplier> findById(Integer id) {
//        return this.repository.findById(id);
//    }
}
