package com.sinaukoding21.tugas6.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "transaksi")
@Getter
@Setter
public class transaksi implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_barang")
    private barang barang;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_pembeli")
    private pembeli pembeli;

    @Column(name = "tgl_transaksi")
    private Date tglTransaksi;

    @Column(name = "keterangan")
    private String keterangan;

    @OneToOne(mappedBy = "transaksi", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private pembayaran pembabayaran;
}

