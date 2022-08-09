package com.sinaukoding21.tugas6.service;

import com.sinaukoding21.tugas6.model.supplier;
import com.sinaukoding21.tugas6.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SupplierService {
    @Autowired
    SupplierRepository repository;

    public List<supplier> findAllsupplier() {
        return repository.findAll();
    }

    @Transactional
    public supplier createsupplier(supplier param) {
        supplier supplier = param;
        supplier = repository.save(supplier);

        return supplier;
    }

    public void deletesupplier(int id) {
        supplier data = repository.findById(id).orElseThrow(null);
        repository.delete(data);
    }

    public supplier updatesupplier(int id, supplier supplier) {
        supplier data = repository.findById(id).orElseThrow(null);
        data.setNamaSupplier(supplier.getNamaSupplier() != null ? supplier.getNamaSupplier() : data.getNamaSupplier());
        data.setNoTelp(supplier.getNoTelp() != null ? supplier.getNoTelp() : data.getNoTelp());
        data.setAlamat(supplier.getAlamat() != null ? supplier.getAlamat() : data.getAlamat());

        return repository.save(data);
    }
}


