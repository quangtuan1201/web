package com.example.duan.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table (name = "TaiKhoan")
public class TaiKhoan {
     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long maTK;

    @Column(nullable = true, length = 50)
    private String username;

    @Column(nullable = true, length = 50)
    private String password;

    @Column(nullable = true)
    private Boolean vaiTro;
}
