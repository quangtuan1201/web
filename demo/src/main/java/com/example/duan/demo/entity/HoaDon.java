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
@Table (name = "HoaDon")
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maHD;

    @Column(nullable = true, length = 50)
    private String pttt;

    @Column(nullable = true, length = 50)
    private String trangThaiTT;

    @Column(nullable = true, length = 50)
    private String trangThaiNH;

    @Column(nullable = true)
    private Double tongTien;

    @ManyToOne
    @JoinColumn(name = "maGH")
    private GioHang gioHang;

    @ManyToOne
    @JoinColumn(name = "maKH")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "maNV")
    private NhanVien nhanVien;

}
