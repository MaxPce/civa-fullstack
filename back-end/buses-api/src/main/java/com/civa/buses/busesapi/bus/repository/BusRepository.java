package com.civa.buses.busesapi.bus.repository;
import com.civa.buses.busesapi.bus.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BusRepository extends JpaRepository<Bus,Long> {
    Page<Bus> findAll(Pageable pageable);
}
