package com.example.persona.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.envers.Audited;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name ="autor")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Audited
@Builder
public class Autor implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "apellido")
    private String apellido;
    @Column(name = "biografia")
    private String biografia;

    @ManyToMany(mappedBy = "autores")
    @JsonBackReference
    @Builder.Default
    private Set<Libro> libros= new HashSet<>();
}
