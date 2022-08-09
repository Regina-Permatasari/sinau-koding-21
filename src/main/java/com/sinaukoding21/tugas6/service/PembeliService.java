package com.sinaukoding21.tugas6.service;

import com.sinaukoding21.tugas6.model.pembeli;
import com.sinaukoding21.tugas6.repository.PembeliRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class PembeliService {
    @Autowired
    PembeliRepository repository;

    public List<pembeli> findAllpembeli() {
        return repository.findAll();
    }

    @Transactional
    public pembeli createpembeli(pembeli param) {
        pembeli pembeli = param;
        pembeli = repository.save(pembeli);

        return pembeli;
    }

    public void deletepembeli(int id) {
        pembeli data = repository.findById(id).orElseThrow(null);
        repository.delete(data);
    }

    public pembeli updatepembeli(int id, pembeli pembeli) {
        pembeli data = repository.findById(id).orElseThrow(null);
        data.setNamaPembeli(pembeli.getNamaPembeli() != null ? pembeli.getNamaPembeli() : data.getNamaPembeli());
        data.setNoTelp(pembeli.getNoTelp() != null ? pembeli.getNoTelp() : data.getNoTelp());
        data.setAlamat(pembeli.getAlamat() != null ? pembeli.getAlamat() : data.getAlamat());

        return repository.save(data);
    }
}

