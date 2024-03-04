package com.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class StudentRepository {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public  void  save(Student dto) {
        String sql = "insert into student(name,surname,created_date) values('%s','%s','%s')";
        sql = String.format(sql, dto.getName(), dto.getSurname(), dto.getCreatedDate());
        jdbcTemplate.update(sql);
    }
        public void createTable() {
            String sql = "create table if not exists student(" +
                    " id serial primary key," +
                    " name varchar(25)," +
                    " surname varchar(25)," +
                    " created_date timestamp)";
            jdbcTemplate.execute(sql);
        }
    public void saveWithPrepareStatement(Student dto) {
        String sql = "insert into student(name,surname,created_date) values(?,?,?)";
        jdbcTemplate.update(sql, dto.getName(), dto.getSurname(), dto.getCreatedDate());
    }
    public List<Student> getAll() {
        String sql = "select * from student";
        List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return list;
    }
    public List<Student>  getId(Integer id){
        String sql = "select * from student where id="+id;
        List<Student> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Student.class));
        return list;
    }



}

