package com.example.duan.demo.entity;

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
@Table (name = "GioHang")
public class GioHang {
   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maGH;

    @ManyToOne
    @JoinColumn(name = "maKH")
    private KhachHang khachHang;
}
