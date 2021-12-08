package com.jannkasper.baeldung.entity.supplier.database;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class SupplierRepository {

    private final SupplierJpaRepository repository;

    public Optional<Supplier> findById(Integer integer) {
        return repository.findById(integer);
    }

    public Supplier save(Supplier entity) {
        return repository.save(entity);
    }
}
