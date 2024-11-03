package com.example.duan.demo.dao;

import java.util.List;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.duan.demo.entity.SanPham;

public interface SanPhamDAO extends JpaRepository<SanPham, Integer> {
}
