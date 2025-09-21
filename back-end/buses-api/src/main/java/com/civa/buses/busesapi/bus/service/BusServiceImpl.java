package com.civa.buses.busesapi.bus.service;

import com.civa.buses.busesapi.bus.model.Bus;
import com.civa.buses.busesapi.bus.repository.BusRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BusServiceImpl implements BusService {


    private final BusRepository busRepository;


    public BusServiceImpl(BusRepository busRepository) {
        this.busRepository = busRepository;
    }


    @Override
    public Page<Bus> findAll(Pageable pageable) {
        return busRepository.findAll(pageable);
    }


    @Override
    public Optional<Bus> findById(Long id) {
        return busRepository.findById(id);
    }


    @Override
    public Bus save(Bus bus) {
        return busRepository.save(bus);
    }
}