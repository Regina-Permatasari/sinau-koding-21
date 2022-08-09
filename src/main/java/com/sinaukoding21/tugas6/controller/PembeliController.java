package com.sinaukoding21.tugas6.controller;

import com.sinaukoding21.tugas6.model.pembeli;
import com.sinaukoding21.tugas6.service.PembeliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembeli")
public class PembeliController {
    @Autowired
    PembeliService service;

    @GetMapping
    public ResponseEntity<?> findAllpembeli() {
        return new ResponseEntity(service.findAllpembeli(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savepembeli(@RequestBody pembeli pembeli) {
        return new ResponseEntity(service.createpembeli(pembeli), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletepembeli(@PathVariable Integer id) {
        service.deletepembeli(id);
        return new ResponseEntity("Berhasil dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatepembeli(@PathVariable Integer id, @RequestBody pembeli pembeli) {
        return new ResponseEntity(service.updatepembeli(id, pembeli), HttpStatus.OK);
    }
}
