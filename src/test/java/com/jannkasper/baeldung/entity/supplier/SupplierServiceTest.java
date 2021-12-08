package com.jannkasper.baeldung.entity.supplier;

import com.jannkasper.baeldung.entity.Address;
import com.jannkasper.baeldung.entity.supplier.database.Supplier;
import com.jannkasper.baeldung.entity.supplier.database.SupplierJpaRepository;
import com.jannkasper.baeldung.entity.supplier.database.SupplierRepository;
import com.jannkasper.baeldung.entity.supplier.service.SupplierService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.orm.hibernate5.HibernateTemplate;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * https://www.baeldung.com/testing-the-java-service-layer
 */
public class SupplierServiceTest {

    private SupplierService instance;
    private SupplierRepository supplierRepository;
    private SupplierJpaRepository supplierJpaRepository;

    @Before
    public void before() {
        this.supplierJpaRepository = mock(SupplierJpaRepository.class);
        this.supplierRepository = new SupplierRepository(supplierJpaRepository);

        this.instance = new SupplierService(supplierRepository);
    }

    @Test
    public void whenCreateIsTriggered_thenNoException(){
        // When
        this.instance.create(buildEntity());
    }

    @Test(expected = NullPointerException.class)
    public void whenCreateIsTriggeredForNullEntity_thenException(){
        // When
        this.instance.create( null );
    }

    @Test
    public void whenCreateIsTriggered_thenEntityIsCreated(){
        // When
        Supplier entity = buildEntity();
        this.instance.create(entity);

        // Then
        ArgumentCaptor<Supplier> argument = ArgumentCaptor.forClass(Supplier.class);
        verify(this.supplierJpaRepository).save(argument.capture());
        Assert.assertEquals(entity, (argument.getValue()));
    }

    private Supplier buildEntity() {
        return new Supplier()
                .setAddress(new Address()
                        .setAddress("street")
                        .setCity("city")
                        .setCountry("country")
                        .setPostalCode("code"))
                .setContactName("contactName");
    }

}
