package com.sinaukoding21.tugas6.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Table(name = "barang")
@Getter
@Setter
public class barang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nama_barang")
    private String namaBarang;

    @Column(name = "harga" , length = 30)
    private Double harga;

    @Column(name = "stok")
    private Integer stok;

    @Column(name = "id_supplier")
    private Integer idSupplier;

    @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "supplier_id")
    private supplier supplier;
}