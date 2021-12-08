package com.jannkasper.baeldung.entity.supplier.web;

import com.jannkasper.baeldung.entity.supplier.database.Supplier;
import com.jannkasper.baeldung.entity.supplier.service.SupplierService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping(value = "/suppliers", produces = MediaType.APPLICATION_JSON_VALUE)
@RequiredArgsConstructor
public class SupplierResource {

    private final SupplierService service;

    @GetMapping(value = "/{id}")
    public ResponseEntity<Supplier> getSupplier(@PathVariable(name = "id") Integer supplierId) {
        Optional<Supplier> optional = service.findById(supplierId);

        if (optional.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(optional.get());
    }

    public ResponseEntity<Supplier> createSupplier(Supplier createSupplier) {
        Supplier created = service.create(createSupplier);
        return ResponseEntity.ok(created);
    }
}
