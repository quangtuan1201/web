package com.example.duan.demo.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Table (name = "PhieuNhapKho")
public class PhieuNhapKho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maPNK;

    @Temporal(TemporalType.DATE)
    private Date ngayLapPNK;

    @Column(nullable = true)
    private Double tongTien;

    @Column(nullable = true)
    private Boolean trangThaiTT;

    @ManyToOne
    @JoinColumn(name = "maNCC")
    private NhaCungCap nhaCungCap;

    @ManyToOne
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

}
