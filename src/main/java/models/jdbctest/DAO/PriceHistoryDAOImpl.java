package models.jdbctest.DAO;

import models.jdbctest.PriceHistory;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class PriceHistoryDAOImpl implements PriceHistoryDAO {
    private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public void save(PriceHistory ph) {
        String query = "insert into abm_price_history (ticker, time, value) values(?,?,?)";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, ph.getTicker());
            ps.setTimestamp(2, ph.getTime());
            ps.setDouble(3, ph.getValue());
            ps.executeUpdate();
            System.out.println("Saved successfully");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public PriceHistory getById(Timestamp time, String ticker) {
        String query = "SELECT * FROM abm_price_history WHERE time=? and ticker=?";
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(2, ticker);
            ps.setTimestamp(1, time);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next()) {
                PriceHistory ph = new PriceHistory();
                ph.setValue(resultSet.getDouble("value"));
                ph.setTime(resultSet.getTimestamp("time"));
                ph.setTicker(resultSet.getString("ticker"));
                return ph;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public units.PriceHistory getHistory(String ticker) {
        String query = "SELECT * FROM abm_price_history WHERE ticker=?";
        units.PriceHistory ph = new units.PriceHistory();
        try (Connection con = dataSource.getConnection();
             PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, ticker);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                ph.addValue(resultSet.getDouble("value"), resultSet.getTimestamp("time").toLocalDateTime());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ph;
    }

    @Override
    public void update(PriceHistory ph) {

    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public List<PriceHistory> getAll() {
        return null;
    }
}
