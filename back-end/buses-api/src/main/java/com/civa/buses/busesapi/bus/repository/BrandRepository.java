package com.civa.buses.busesapi.bus.repository;
import com.civa.buses.busesapi.bus.model.Brand;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BrandRepository extends JpaRepository<Brand, Long>{
    boolean existsByNameIgnoreCase(String name);
}
