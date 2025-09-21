package com.civa.buses.busesapi.bus.model;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "brands")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Brand {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(nullable = false, unique = true)
    private String name;
}