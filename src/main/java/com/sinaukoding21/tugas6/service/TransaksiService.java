package com.sinaukoding21.tugas6.service;

import com.sinaukoding21.tugas6.model.transaksi;
import com.sinaukoding21.tugas6.repository.TransaksiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TransaksiService {
    @Autowired
    TransaksiRepository repository;

    public List<transaksi> findAlltransaksi() {
        return repository.findAll();
    }

    @Transactional
    public transaksi createtransaksi(transaksi param) {
        transaksi transaksi = param;
        transaksi = repository.save(transaksi);

        return transaksi;
    }

    public void deletetransaksi(int id) {
        transaksi data = repository.findById(id).orElseThrow(null);
        repository.delete(data);
    }

    public transaksi updatetransaksi(int id, transaksi transaksi) {
        transaksi data = repository.findById(id).orElseThrow(null);
        data.setTglTransaksi(transaksi.getTglTransaksi() != null ? transaksi.getTglTransaksi() : data.getTglTransaksi());
        data.setKeterangan(transaksi.getKeterangan() != null ? transaksi.getKeterangan() : data.getKeterangan());

        return repository.save(data);
    }
}


