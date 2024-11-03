package com.example.duan.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
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
@Table (name = "ChiTietPhieuNhapKho")
public class ChiTietPhieuNhapKho {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "maPNK")
    private PhieuNhapKho phieuNhapKho;

    @ManyToOne
    @JoinColumn(name = "maSP")
    private SanPham sanPham;

    @Column(nullable = true)
    private Integer soLuong;

    @Column(nullable = true)
    private Double donGia;
}
