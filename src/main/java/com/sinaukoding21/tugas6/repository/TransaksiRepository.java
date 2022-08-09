package com.sinaukoding21.tugas6.repository;

import com.sinaukoding21.tugas6.model.transaksi;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransaksiRepository extends JpaRepository<transaksi, Integer> {
}
