package injectors;

import models.impls.Company;

import java.util.HashMap;
import java.util.Map;

public class Companies {
    private static Companies ourInstance = new Companies();
    private Map<String, Company> companies = new HashMap<>();

    public static Companies getInstance() {
        return ourInstance;
    }

    private Companies() {
    }

    public void add(Company company) {
        companies.putIfAbsent(company.getTicker(), company);
    }

    public static Map<String, Company> getCompanies() {
        return getInstance().companies;
    }

    public static Company get(String ticker){
        return getCompanies().getOrDefault(ticker, null);
    }
}
