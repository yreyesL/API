package com.example.API.web;

import com.example.API.modelo.Curso;
import com.example.API.servicio.CursoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/cursos")
public class CursoController {

    private CursoServicio cursoServicio;

    @Autowired
    public CursoController(CursoServicio cursoServicio) {
        this.cursoServicio = cursoServicio;
    }

    @GetMapping("/todo")
    public List<Curso> obtenerTodosCursos() {
        return cursoServicio.obtenerTodosCursos();
    }

    @GetMapping("/{id}")
    public Optional<Curso> obtenerPorId(@PathVariable int id) {
        return cursoServicio.obtenerPorId(id);
    }

    @PostMapping("/guardar")
    public void guardar(@RequestBody Curso curso) {

        cursoServicio.guardar(curso);
    }

    @DeleteMapping("/eliminar/{id}")
    public void eliminar(@PathVariable int id) {
        cursoServicio.eliminar(id);
    }

}
