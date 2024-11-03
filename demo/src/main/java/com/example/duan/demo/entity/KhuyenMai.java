package com.example.duan.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table (name = "KhuyenMai")
public class KhuyenMai {
    @Id
    @Column(length = 5)
    private String maKM;

    @Column(nullable = true, length = 50)
    private String giam;

    @ManyToOne
    @JoinColumn(name = "maSP")
    private SanPham sanPham;
}
