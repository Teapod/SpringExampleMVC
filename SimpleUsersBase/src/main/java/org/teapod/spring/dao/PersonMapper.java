package org.teapod.spring.dao;

import org.springframework.jdbc.core.RowMapper;
import org.teapod.spring.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

// Don't used because it's just an example!!!

// instead in DAO we will use default mapper - BeanPropertyRowMapper

public class PersonMapper implements RowMapper <Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
       Person person = new Person();

        person.setId(resultSet.getInt("id"));
        person.setAge(resultSet.getInt("age"));
        person.setName(resultSet.getString("name"));
        person.setEmail(resultSet.getString("email"));

        return person;
    }
}
