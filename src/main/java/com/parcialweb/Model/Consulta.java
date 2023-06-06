package com.parcialweb.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "consultas")
public class Consulta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String nombre;

    @Column(unique = true, nullable = false)
    private String email;

//    @Column(unique = true, nullable = false)
//    private Long celular;

    private String descripcion;
}
