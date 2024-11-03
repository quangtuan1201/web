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
@Table (name = "NhanVien")
public class NhanVien {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maNV;

    @Column(nullable = true, length = 50)
    private String tenNV;

    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(nullable = true, length = 50)
    private String email;

    @Column(nullable = true, length = 50)
    private String sdt;

    @Column(nullable = true)
    private Boolean gioiTinh;

    @Column(nullable = true)
    private Boolean chucVu;

    @ManyToOne
    @JoinColumn(name = "maTK")
    private TaiKhoan taiKhoan;
}
