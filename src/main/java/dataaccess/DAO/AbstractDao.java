package dataaccess.DAO;

import dataaccess.helpers.DbObject;
import dataaccess.helpers.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

public abstract class AbstractDao<T extends DbObject> {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<T> getAll() {
        return jdbcTemplate.query("SELECT * FROM " + tableName(), rowMapper());
    }

    public RowMapper<T> rowMapper() {
        return (rs, rowNum) -> ObjectMapper.invoke(rs, getClazz());
    }

    public abstract String tableName();

    public abstract Class<T> getClazz();
}
