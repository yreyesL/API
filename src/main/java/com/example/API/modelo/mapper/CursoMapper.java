package com.example.API.modelo.mapper;


import com.example.API.modelo.Curso;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CursoMapper  implements RowMapper<Curso> {
    @Override
    public Curso mapRow(ResultSet rs, int rowNum) throws SQLException {
        Curso curso = new Curso();
        curso.setCurId(rs.getInt("id"));
        curso.setDescripcion(rs.getString("descripcion"));
        curso.setMatriculados(rs.getInt("matriculados"));
        curso.setVacantes(rs.getInt("vacantes"));
        return curso;
    }
}
