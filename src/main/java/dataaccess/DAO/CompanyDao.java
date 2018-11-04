package dataaccess.DAO;

import avro.Company;
import dataaccess.helpers.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class CompanyDao extends AbstractDao<Company> {
    private static final String GENERIC_SELECT = "SELECT * FROM COMPANIES";
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<Company> allCompanies() {
        return jdbcTemplate.query(GENERIC_SELECT, rowMapper());
    }

    public Company company(String ticker) {
        List<Company> company = jdbcTemplate.query(GENERIC_SELECT + " WHERE TICKER='" + ticker + "'", (rs, i) -> ObjectMapper.invoke(rs, getClazz()));
        return company.isEmpty() ? null : company.get(0);
    }

    public void insert(Company company) {
        boolean alreadyThere = allCompanies().stream().anyMatch(x -> x.getSymbol().equals(company.getSymbol()));
        if (!alreadyThere) {
            String[] COLS = "symbol, company_name, exchange, industry, website, description, ceo, issue_type, sector".split(", ");
            jdbcTemplate.update("INSERT INTO companies (COLS) " +
                            "VALUES (?,?,?,?,?,?,?,?,?)",
                    company.getSymbol(),
                    company.getCompanyName(),
                    company.getExchange(),
                    company.getIndustry(),
                    company.getWebsite(),
                    company.getDescription(),
                    company.getCeo(),
                    company.getIssueType(),
                    company.getSector());
        }
    }


    @Override
    public String tableName() {
        return "companies";
    }

    @Override
    public Class<Company> getClazz() {
        return Company.class;
    }
}
