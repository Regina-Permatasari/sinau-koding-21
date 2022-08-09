package com.sinaukoding21.tugas6.controller;

import com.sinaukoding21.tugas6.model.transaksi;
import com.sinaukoding21.tugas6.service.TransaksiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/transaksi")
public class TransaksiController {
    @Autowired
    TransaksiService service;

    @GetMapping
    public ResponseEntity<?> findAlltransaksi() {
        return new ResponseEntity(service.findAlltransaksi(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savetransaksi(@RequestBody transaksi transaksi) {
        return new ResponseEntity(service.createtransaksi(transaksi), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletetransaksi(@PathVariable Integer id) {
        service.deletetransaksi(id);
        return new ResponseEntity("Berhasil dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatetransaksi(@PathVariable Integer id, @RequestBody transaksi transaksi) {
        return new ResponseEntity(service.updatetransaksi(id, transaksi), HttpStatus.OK);
    }
}

