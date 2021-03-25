package com.organization.portal.controller;

import com.organization.portal.model.Employ;
import com.organization.portal.service.EmployService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployController {
    @Autowired
    EmployService employService;

    @GetMapping("/employ/get")
    public List<Employ> getEmploys() {
        return employService.findAll();
    }

    @GetMapping("/employ/name={name}")
    public Employ getEmployByName(@PathVariable String name) {
        return employService.findByName(name);
    }

    @GetMapping("/employ/id={id}")
    public Employ getEmployById(@PathVariable long id) {
        return employService.findById(id);
    }

    @PostMapping("/employ/add")
    public void add(@RequestBody Employ employ) {
        employService.add(employ);
    }

    @PostMapping("/employ/addBulk")
    public void addAll(@RequestBody List<Employ> employList) {
        employService.addAll(employList);
    }

    @PutMapping("/employ/update/id={id}")
    public void update(@RequestBody Employ employ, @PathVariable long id) {
        employService.update(employ, id);
    }
}
