package com.organization.portal.repository;

import com.organization.portal.model.Employ;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployRepository extends CrudRepository<Employ,Long> {
    public Employ findByName(String name);
}
