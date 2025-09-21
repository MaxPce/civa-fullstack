package com.civa.buses.busesapi.bus.service;

import com.civa.buses.busesapi.bus.model.Brand;

import java.util.*;

public interface BrandService {
    List<Brand> findAll();
    Optional<Brand> findById(Long id);
    Brand save(Brand brand);
}
