package dataaccess.DAO;

import dataaccess.helpers.ObjectMapper;
import dataaccess.models.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompanyDao extends AbstractDao<Company> {
    private static final String GENERIC_SELECT = "SELECT * FROM COMPANIES LEFT JOIN sectors s2 on companies.sector_id = s2.sector_id";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Company> allCompanies() {
        return jdbcTemplate.query(GENERIC_SELECT, (rs, rowNum) -> ObjectMapper.invoke(rs, Company.class));
    }

    public Company company(String ticker) {
        List<Company> company = jdbcTemplate.query(GENERIC_SELECT + " WHERE TICKER='" + ticker + "'", (rs, i) -> ObjectMapper.invoke(rs, Company.class));
        return company.isEmpty() ? null : company.get(0);
    }
}
