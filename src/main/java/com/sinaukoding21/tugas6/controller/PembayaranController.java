package com.sinaukoding21.tugas6.controller;

import com.sinaukoding21.tugas6.model.barang;
import com.sinaukoding21.tugas6.model.pembayaran;
import com.sinaukoding21.tugas6.service.BarangService;
import com.sinaukoding21.tugas6.service.PembayaranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pembayaran")
public class PembayaranController {
    @Autowired
    PembayaranService service;

    @GetMapping
    public ResponseEntity<?> findAllpembayaran() {
        return new ResponseEntity(service.findAllpembayaran(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> savepembayaran(@RequestBody pembayaran pembayaran) {
        return new ResponseEntity(service.createpembayaran(pembayaran), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletepembayaran(@PathVariable Integer id) {
        service.deletepembayaran(id);
        return new ResponseEntity("Berhasil dihapus", HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatepembayaran(@PathVariable Integer id, @RequestBody pembayaran pembayaran) {
        return new ResponseEntity(service.updatepembayaran(id, pembayaran), HttpStatus.OK);
    }
}