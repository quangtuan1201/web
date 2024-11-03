//package com.example.duan.demo.service;
//
//import com.example.duan.demo.dao.SanPhamDAO;
//import com.example.duan.demo.entity.SanPham;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class SanPhamService {
//    @Autowired
//    private SanPhamDAO dao;
//
//    public List<SanPham> getAllSanPhams() {
//        List<SanPham> sanPhams = dao.findAll();
//        System.out.println("Số sản phẩm lấy được: " + sanPhams.size());
//        return sanPhams;
//    }
//    
//    public SanPham getSanPhamById(int id) {
//        return dao.findById(id).orElse(null);
//    }
//
//
//}
//
