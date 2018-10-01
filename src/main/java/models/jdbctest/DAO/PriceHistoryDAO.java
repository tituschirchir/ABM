package models.jdbctest.DAO;

import models.jdbctest.PriceHistory;

import java.sql.Timestamp;
import java.util.List;

public interface PriceHistoryDAO {

    //Create
    void save(PriceHistory ph);
    //Read
    PriceHistory getById(Timestamp time, String ticker);
    units.PriceHistory getHistory(String ticker);
    //Update
    void update(PriceHistory ph);
    //Delete
    void deleteById(int id);
    //Get All
    List<PriceHistory> getAll();
}
