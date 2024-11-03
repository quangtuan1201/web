package com.example.duan.demo.RestController;

import com.example.duan.demo.dao.SanPhamDAO;
import com.example.duan.demo.entity.SanPham;

import ch.qos.logback.core.model.Model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
public class SanPhamRestController {
    @Autowired 
    SanPhamDAO dao;
    
    @GetMapping("/rest/SanPham")
    public ResponseEntity<List<SanPham>> getAll() {
        List<SanPham> products = dao.findAll();
        products.forEach(product -> product.getAnhsanpham().size()); 
        return ResponseEntity.ok(products); 
    }
}

   


