package dataaccess.DAO;

import dataaccess.helpers.ObjectMapper;
import dataaccess.models.PriceHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.sql.Timestamp;
import java.util.List;

@Controller
public class PriceHistoryDAO extends AbstractDao<PriceHistory> {
    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PriceHistoryDAO(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public void save(PriceHistory ph) {
        String query = String.format("insert into price (ticker, time, value) values('%s','%s','%s')",
                ph.getTicker(), ph.getTime(), ph.getValue());
        try {
            jdbcTemplate.execute(query);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }


    public PriceHistory getById(Timestamp time, String ticker) {
        String query = "SELECT * FROM price WHERE time=? and ticker=?";
        List<PriceHistory> priceHistories = jdbcTemplate.query(query, (rs, rowNum) -> ObjectMapper.invoke(rs, PriceHistory.class));
        return priceHistories == null ? null : priceHistories.get(0);
    }


    public List<PriceHistory> getHistory(String ticker) {
        String query = String.format("SELECT * FROM price WHERE ticker='%s'", ticker);
        return jdbcTemplate.query(query, (rs, rowNum) -> ObjectMapper.invoke(rs, PriceHistory.class));
    }


    public void update(PriceHistory ph) {

    }


    public void deleteById(int id) {

    }


    @Override
    public String tableName() {
        return "abm_price_history";
    }

    @Override
    public Class<PriceHistory> getClazz() {
        return PriceHistory.class;
    }
}
