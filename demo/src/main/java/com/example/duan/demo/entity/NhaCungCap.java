package com.example.duan.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table (name = "NhaCungCap")
public class NhaCungCap {
     @Id
    @Column(length = 5)
    private String maNCC;

    @Column(nullable = true, length = 50)
    private String tenNCC;

    @Column(nullable = true, length = 50)
    private String email;

    @Column(nullable = true, length = 50)
    private String sdt;

    @Column(nullable = true, length = 255)
    private String diaChi;

}
