package com.sinaukoding21.tugas6.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class barangDTO {
    private Integer id;
    private String namaBarang;
    private Double harga;
    private Integer stok;
    private Integer idSupplier;
}
