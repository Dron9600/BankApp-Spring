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
public class UsersDAO {
    private final JdbcTemplate jdbcTemplate;

    public Users users = new Users();

    @Autowired
    public UsersDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void saveUsers(Users users) {
        jdbcTemplate.update("INSERT INTO users(username, password, enabled) VALUES(?, ?, 1)",
                users.getUsername(), users.getPassword());
    }
}