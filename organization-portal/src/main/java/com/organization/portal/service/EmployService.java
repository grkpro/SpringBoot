package com.organization.portal.service;

import com.organization.portal.exception.EmployNotFoundException;
import com.organization.portal.model.Employ;
import com.organization.portal.repository.EmployRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployService {
    @Autowired
    EmployRepository employRepository;

    public List<Employ> findAll() {
        List<Employ> employList = new ArrayList<>();
        employRepository.findAll().forEach(employList::add);
        return employList;
    }

    public Employ findById(Long id) {
        return employRepository.findById(id)
                .orElseThrow(() -> new EmployNotFoundException(new StringBuilder().append("Employ not found with id=").append(id).toString()));
    }

    public Employ findByName(String name) {
        return employRepository.findByName(name);
    }

    public void add(Employ employ) {
        employRepository.save(employ);
    }

    public void addAll(List<Employ> employList) {
        employRepository.saveAll(employList);
    }

    public void update(Employ employ, long id) {
        if (!employRepository.existsById(id))
            throw new EmployNotFoundException("Employ Not found and id = " + id);
        employRepository.save(employ);
    }
}
