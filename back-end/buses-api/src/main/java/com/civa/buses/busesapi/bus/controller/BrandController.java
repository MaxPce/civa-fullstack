package com.civa.buses.busesapi.bus.controller;

import com.civa.buses.busesapi.bus.model.Brand;
import com.civa.buses.busesapi.bus.service.BrandService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.net.URI;
import java.util.List;


@RestController
@RequestMapping("/brand")
@CrossOrigin(origins = "http://localhost:3000")
public class BrandController {


    private final BrandService brandService;


    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }


    @GetMapping
    public ResponseEntity<List<Brand>> getAll() {
        return ResponseEntity.ok(brandService.findAll());
    }


    @PostMapping
    public ResponseEntity<Brand> create(@RequestBody Brand brand) {
        Brand saved = brandService.save(brand);
        return ResponseEntity.created(URI.create("/brand/" + saved.getId())).body(saved);
    }
}