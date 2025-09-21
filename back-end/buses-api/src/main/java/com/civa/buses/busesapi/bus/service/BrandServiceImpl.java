package com.civa.buses.busesapi.bus.service;

import com.civa.buses.busesapi.bus.model.Brand;
import com.civa.buses.busesapi.bus.repository.BrandRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class BrandServiceImpl implements BrandService {


    private final BrandRepository brandRepository;


    public BrandServiceImpl(BrandRepository brandRepository) {
        this.brandRepository = brandRepository;
    }


    @Override
    public List<Brand> findAll() {
        return brandRepository.findAll();
    }


    @Override
    public Optional<Brand> findById(Long id) {
        return brandRepository.findById(id);
    }


    @Override
    public Brand save(Brand brand) {
        if (brand.getName() != null && brandRepository.existsByNameIgnoreCase(brand.getName())) {
            throw new IllegalArgumentException("Marca ya existente : " + brand.getName());
        }
        return brandRepository.save(brand);
    }
}