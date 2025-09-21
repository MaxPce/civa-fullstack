package com.civa.buses.busesapi.bus.service;

import com.civa.buses.busesapi.bus.model.Bus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface BusService {
    Page<Bus> findAll(Pageable pageable);
    Optional<Bus> findById(Long id);
    Bus save(Bus bus);
}

