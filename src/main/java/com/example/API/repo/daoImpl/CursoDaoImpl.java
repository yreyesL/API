package com.example.API.repo.daoImpl;

import com.example.API.modelo.Curso;
import com.example.API.modelo.mapper.CursoMapper;
import com.example.API.repo.dao.CursoDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CursoDaoImpl implements CursoDao {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public CursoDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<Curso> obtenerTodosCursos() {
        return jdbcTemplate.query("SELECT * FROM CURSO", new CursoMapper());
    }

    @Override
    public Optional<Curso> obtenerPorId(int id) {
        return jdbcTemplate.query("" + "SELECT * FROM CURSO WHERE id = ?", BeanPropertyRowMapper.newInstance(Curso.class), id)
                .stream().findFirst();
    }

    @Override
    public void guardar(Curso curso){
        jdbcTemplate.update("insert into CURSO (descripcion, matriculados, vacantes) values (?, ?, ?)",
                curso.getDescripcion(),
                curso.getMatriculados(),
                curso.getVacantes());
    }

    @Override
    public void eliminar(int id) {
        String SQL = "delete from CURSO where id = ?";
        jdbcTemplate.update(SQL, id);
    }
}
