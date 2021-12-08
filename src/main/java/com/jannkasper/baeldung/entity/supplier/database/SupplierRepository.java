package com.jannkasper.baeldung.entity.supplier.database;

import org.springframework.orm.hibernate5.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class SupplierRepository extends HibernateDaoSupport {

    public Integer create(Supplier entity) {
        if (entity == null) {
            throw new NullPointerException();
        }

        return (Integer) this.getHibernateTemplate().save(entity);
    }
}
