package com.jannkasper.baeldung.entity.supplier.service;

import com.jannkasper.baeldung.entity.supplier.database.Supplier;
import com.jannkasper.baeldung.entity.supplier.database.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SupplierService {

    SupplierRepository repository;

    @Autowired
    public SupplierService(SupplierRepository repository) {
        this.repository = repository;
    }

    public Supplier create(Supplier newEntity) {
        if (newEntity == null) {
            throw new NullPointerException();
        }

        return this.repository.save(newEntity);
    }

    public Optional<Supplier> findById(Integer integer) {
        return repository.findById(integer);
    }

    public Supplier save(Supplier entity) {
        return repository.save(entity);
    }
}
