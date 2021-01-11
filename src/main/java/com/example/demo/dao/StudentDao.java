package com.example.demo.dao;

import com.example.demo.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class StudentDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    class StudentRowMapper implements RowMapper<Student>{
        @Override
        public Student mapRow(ResultSet resultSet, int i) throws SQLException {
            Student student=new Student();
            student.setRoll(resultSet.getInt("roll"));
            student.setName(resultSet.getString("name"));
            student.setEmail(resultSet.getString("email"));
            return student;
        }
    }
    public List<Student> findAll(){
        List<Student> studentList= jdbcTemplate.query("select * from student",new StudentRowMapper());
        return  studentList;
    }
    public int insert(Student student) {
        return jdbcTemplate.update("insert into student (roll,name,email)"+" values(?, ?, ?)",
                student.getRoll(), student.getName(), student.getEmail());
    }

    public int deleteById(long roll) {
        return jdbcTemplate.update("delete from student where roll=?", roll);
    }

    public int update(Student student){
        return jdbcTemplate.update("update student set name=?,email=? where roll=?",
                student.getName(),student.getEmail(),student.getRoll());
    }
}
