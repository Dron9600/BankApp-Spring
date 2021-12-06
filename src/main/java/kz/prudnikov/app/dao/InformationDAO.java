package kz.prudnikov.app.dao;

import kz.prudnikov.app.entity.Information;
import kz.prudnikov.app.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class InformationDAO {

    private final JdbcTemplate jdbcTemplate;

    public Information information = new Information();

    @Autowired
    public InformationDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Information> indexIn() {
        return jdbcTemplate.query("SELECT * FROM authorities", new BeanPropertyRowMapper<>(Information.class));
    }

    public Information showInfo(int id) {
        return jdbcTemplate.query("SELECT * FROM authorities WHERE id=?", new Object[]{id}, new BeanPropertyRowMapper<>(Information.class))
                .stream().findAny().orElse(null);
    }

    public int findByCustomerName(String name) {
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String sql = "SELECT id FROM users WHERE username=?";
        int idNum = (Integer) jdbcTemplate.queryForObject(
                sql, new Object[]{name}, Integer.class);
        information.setNumber(idNum);
        return idNum;
    }

    public void saveInfo(Information information) {
        information.setUsername(lastValue());
        jdbcTemplate.update("INSERT INTO authorities( username, authority, name, surname, email, age) VALUES(?, ?, ?, ?, ?, ?)",
                information.getUsername(), information.getAuthority(),
                information.getName(), information.getSurname(),
                information.getEmail(),information.getAge());
    }

    public String lastValue() {
        String sql = "SELECT username FROM users WHERE id=(SELECT max(id) FROM users)";
        String lastName = (String) jdbcTemplate.queryForObject(
                sql, String.class);
        return lastName;
    }

}
