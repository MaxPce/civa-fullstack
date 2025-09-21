package com.civa.buses.busesapi.bus.controller;

import com.civa.buses.busesapi.bus.model.Brand;
import com.civa.buses.busesapi.bus.model.Bus;
import com.civa.buses.busesapi.bus.service.BrandService;
import com.civa.buses.busesapi.bus.service.BusService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Optional;


@RestController
@RequestMapping("/bus")
@CrossOrigin(origins = "http://localhost:3000")
public class BusController {


    private final BusService busService;
    private final BrandService brandService;


    public BusController(BusService busService, BrandService brandService) {
        this.busService = busService;
        this.brandService = brandService;
    }


    // GET /bus -> paginated list
    @GetMapping
    public ResponseEntity<Page<Bus>> getAll(@PageableDefault(size = 10) Pageable pageable) {
        Page<Bus> page = busService.findAll(pageable);
        return ResponseEntity.ok(page);
    }


    // GET /bus/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Bus> getById(@PathVariable Long id) {
        return busService.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }


    @PostMapping
    public ResponseEntity<?> create(@RequestBody Bus bus) {
        if (bus.getBrand() == null || bus.getBrand().getId() == null) {
            return ResponseEntity.badRequest().body("Falta id");
        }


        Optional<Brand> brandOpt = brandService.findById(bus.getBrand().getId());
        if (brandOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Id no encontrado :: " + bus.getBrand().getId());
        }


        bus.setBrand(brandOpt.get());
        Bus saved = busService.save(bus);
        return ResponseEntity.created(URI.create("/bus/" + saved.getId())).body(saved);
    }
}
