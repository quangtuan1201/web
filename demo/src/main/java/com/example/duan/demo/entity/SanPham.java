package com.example.duan.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
@SuppressWarnings("serial")
@Entity
@Data
@Table(name = "sanpham")
public class SanPham implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer masp;
    private String tensp;
    private String xuatxu;
    private String donvitinh;
    private Double dongia;
    private Integer luotban;
    private Integer soluong;
    private String mota;

    @ManyToOne
    @JoinColumn(name = "malh") 
    private LoaiHang loaihang; 
    
    @JsonManagedReference
    @OneToMany(mappedBy = "sanpham")
    private List<AnhSanPham> anhsanpham;

}


