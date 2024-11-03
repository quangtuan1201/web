package com.example.duan.demo.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.duan.demo.dao.LoaiHangDAO;
import com.example.duan.demo.entity.LoaiHang;

import ch.qos.logback.core.model.Model;
@RestController
@CrossOrigin("*")
public class LoaiHangRestController {
	@Autowired LoaiHangDAO dao;
	
	@GetMapping("/rest/LoaiHang")
	public ResponseEntity<List<LoaiHang>> getAll() {
	    List<LoaiHang> list = dao.findAll();
	    System.out.println(list); // In ra kết quả để kiểm tra
	    if (list.isEmpty()) {
	        return ResponseEntity.noContent().build();
	    }
	    return ResponseEntity.ok(list);
	}

}
