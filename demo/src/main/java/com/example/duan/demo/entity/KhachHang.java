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
@Table (name = "KhachHang")
public class KhachHang {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maKH;

    @Column(nullable = true, length = 50)
    private String tenKH;

    @Temporal(TemporalType.DATE)
    private Date ngaySinh;

    @Column(nullable = true, length = 50)
    private String email;

    @Column(nullable = true, length = 50)
    private String sdt;

    @Column(nullable = true)
    private Boolean gioiTinh;

    @ManyToOne
    @JoinColumn(name = "maTK")
    private TaiKhoan taiKhoan;

}
