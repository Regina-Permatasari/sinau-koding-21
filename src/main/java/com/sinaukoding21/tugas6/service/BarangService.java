package com.sinaukoding21.tugas6.service;

import com.sinaukoding21.tugas6.model.barang;
import com.sinaukoding21.tugas6.repository.BarangRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BarangService {
    @Autowired
    BarangRepository repository;

    public List<barang> findAllbarang() {
        return repository.findAll();
    }

    @Transactional
    public barang createbarang(barang param) {
        barang barang = param;
        barang = repository.save(barang);

        return barang;
    }

    public void deletebarang(int id) {
        barang data = repository.findById(id).orElseThrow(null);
        repository.delete(data);
    }

    public barang updatebarang(int id, barang barang) {
        barang data = repository.findById(id).orElseThrow(null);
        data.setNamaBarang(barang.getNamaBarang() != null ? barang.getNamaBarang() : data.getNamaBarang());
        data.setHarga(barang.getHarga() != null ? barang.getHarga() : data.getHarga());
        data.setStok(barang.getStok() != null ? barang.getStok() : data.getStok());
        data.setIdSupplier(barang.getIdSupplier() != null ? barang.getIdSupplier() : data.getIdSupplier());

        return repository.save(data);
    }
}

