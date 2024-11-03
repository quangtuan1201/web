package com.example.duan.demo.entity;

import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
@SuppressWarnings("serial")
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Loaihang")
public class LoaiHang implements Serializable {
	@Id
	private String maLH;

	private String tenLH;

    @JsonIgnore
    @OneToMany(mappedBy = "loaihang")
    private List<SanPham> sanpham;
}

