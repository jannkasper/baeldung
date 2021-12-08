package com.jannkasper.baeldung.entity.supplier.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierJpaRepository extends JpaRepository<Supplier, Integer> {

}