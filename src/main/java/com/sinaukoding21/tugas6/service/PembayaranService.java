package com.sinaukoding21.tugas6.service;

import com.sinaukoding21.tugas6.model.pembayaran;
import com.sinaukoding21.tugas6.repository.PembayaranRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PembayaranService {
    @Autowired
    PembayaranRepository repository;

    public List<pembayaran> findAllpembayaran() {
        return repository.findAll();
    }

    @Transactional
    public pembayaran createpembayaran(pembayaran param) {
        pembayaran pembayaran = param;
        pembayaran = repository.save(pembayaran);

        return pembayaran;
    }

    public void deletepembayaran(int id) {
        pembayaran data = repository.findById(id).orElseThrow(null);
        repository.delete(data);
    }

    public pembayaran updatepembayaran(int id, pembayaran pembayaran) {
        pembayaran data = repository.findById(id).orElseThrow(null);
        data.setTglBayar(pembayaran.getTglBayar() != null ? pembayaran.getTglBayar() : data.getTglBayar());
        data.setTotal(pembayaran.getTotal() != null ? pembayaran.getTotal() : data.getTotal());

        return repository.save(data);
    }
}


