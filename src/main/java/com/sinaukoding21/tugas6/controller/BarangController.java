package com.sinaukoding21.tugas6.controller;


import com.sinaukoding21.tugas6.model.barang;
import com.sinaukoding21.tugas6.service.BarangService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/barang")
public class BarangController {
    @Autowired
    BarangService service;

    @GetMapping
    public ResponseEntity<?> findAllbarang() {
        return new ResponseEntity(service.findAllbarang(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savebarang(@RequestBody barang barang) {
        return new ResponseEntity(service.createbarang(barang), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletebarang(@PathVariable Integer id) {
        service.deletebarang(id);
        return new ResponseEntity("Berhasil dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatebarang(@PathVariable Integer id, @RequestBody barang barang) {
        return new ResponseEntity(service.updatebarang(id, barang), HttpStatus.OK);
    }
}
