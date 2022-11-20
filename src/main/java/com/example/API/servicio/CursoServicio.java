package com.example.API.servicio;

import com.example.API.modelo.Curso;
import com.example.API.repo.crud.cursoCrud;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CursoServicio {

    //private CursoDao cursoDao;

    private cursoCrud cursoCrud;

    @Autowired
    public CursoServicio(//CursoDao cursoDao
                         cursoCrud cursoCrud) {
        // this.cursoDao = cursoDao;
        this.cursoCrud = cursoCrud;
    }

    public List<Curso> obtenerTodosCursos() {
        //return cursoDao.obtenerTodosCursos();
        return (List<Curso>) cursoCrud.findAll();
    }

    public Optional<Curso> obtenerPorId(int id) {
        //return cursoDao.obtenerPorId(id);

        return cursoCrud.findById(id);
    }


    public void eliminar(int id) {
        //cursoDao.eliminar(id);

        cursoCrud.deleteById(id);
    }

    public void guardar(Curso curso) {
        //cursoDao.guardar(curso);

        cursoCrud.save(curso);
    }
}
