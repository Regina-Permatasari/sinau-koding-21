package com.sinaukoding21.tugas6.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "pembayaran")

public class pembayaran {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Getter
    @Setter
    @Column
    private Date tglBayar;

    @Getter
    @Setter
    @Column
    private Double Total;

    @Setter
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id_transaksi")
    private transaksi transaksi;
}
