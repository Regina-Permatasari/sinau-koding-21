package com.sinaukoding21.tugas6.controller;

import com.sinaukoding21.tugas6.model.supplier;
import com.sinaukoding21.tugas6.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    SupplierService service;

    @GetMapping
    public ResponseEntity<?> findAllsupplier() {
        return new ResponseEntity(service.findAllsupplier(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savesupplier(@RequestBody supplier supplier) {
        return new ResponseEntity(service.createsupplier(supplier), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletesupplier(@PathVariable Integer id) {
        service.deletesupplier(id);
        return new ResponseEntity("Berhasil dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatesupplier(@PathVariable Integer id, @RequestBody supplier supplier) {
        return new ResponseEntity(service.updatesupplier(id, supplier), HttpStatus.OK);
    }
}

