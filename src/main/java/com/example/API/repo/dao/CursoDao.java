package com.example.API.repo.dao;


import com.example.API.modelo.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoDao {
    List<Curso> obtenerTodosCursos();

    Optional<Curso> obtenerPorId(int id);

    void eliminar(int id);

    void guardar(Curso curso);
}
