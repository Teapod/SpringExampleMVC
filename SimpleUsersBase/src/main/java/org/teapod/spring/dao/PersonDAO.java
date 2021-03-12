package org.teapod.spring.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.teapod.spring.models.Person;

import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;

    private  final JdbcTemplate jdbcTemplate;

    @Autowired
    public PersonDAO(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Person> index() {
        return jdbcTemplate.query("SELECT * FROM Person", new BeanPropertyRowMapper<>(Person.class));
    }

    public Person show(int id) {
        return jdbcTemplate.query("SELECT * FROM Person WHERE id = ?", new Object[]{id}, new BeanPropertyRowMapper<>(Person.class))
                .stream().findAny().orElse(null);
    }

    public void save(Person person) {

        jdbcTemplate.update("INSERT INTO Person VALUES (?, 2, ?, ?)", person.getAge(), person.getName(),
                person.getEmail());
    }

    public void update(int id, Person updatedPerson) {

        jdbcTemplate.update("UPDATE Person SET age = ?, name = ?, email = ? WHERE id = ?", updatedPerson.getAge(), updatedPerson.getName(),
                updatedPerson.getEmail(), id );

    }

    public void delete(int id) {
        jdbcTemplate.update("DELETE FROM Person WHERE id = ?", id);
    }
}
