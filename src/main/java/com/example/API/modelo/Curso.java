package com.example.API.modelo;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "CURSO", schema = "dbo")
public class Curso {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer curId;

    private String descripcion;

    private Integer matriculados;

    private Integer vacantes;

    @Override
    public String toString() {
        return "Curso{" +
                "curId=" + curId +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Curso curso = (Curso) o;
        return curId.equals(curso.curId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(curId);
    }
}
