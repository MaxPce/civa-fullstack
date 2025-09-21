package com.civa.buses.busesapi.bus.model;

import jakarta.persistence.*;
import lombok.*;


import java.time.Instant;


@Entity
@Table(name = "buses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bus {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "bus_number", nullable = false)
    private String number;


    @Column(nullable = false, unique = true)
    private String plate;


    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;


    @Column(columnDefinition = "text")
    private String features;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;


    @Column(nullable = false)
    private boolean active = true;


    @PrePersist
    public void prePersist() {
        this.createdAt = Instant.now();
    }
}