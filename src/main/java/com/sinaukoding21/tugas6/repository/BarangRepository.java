package com.sinaukoding21.tugas6.repository;

import com.sinaukoding21.tugas6.model.barang;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BarangRepository extends JpaRepository<barang, Integer> {
}
