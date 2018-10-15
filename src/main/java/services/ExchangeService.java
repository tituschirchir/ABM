package services;

import dataaccess.models.Company;
import dataaccess.models.PriceHistory;
import org.springframework.stereotype.Service;
import services.robinhood.RHCompany;
import services.robinhood.RHInstrument;
import services.robinhood.RHQuote;
import services.robinhood.RHSplit;

import java.util.List;

@Service
public interface ExchangeService {
    List<PriceHistory> pricesHistoryFor(String ticker);

    List<Company> companies();

    RHCompany company(String ticker);

    RHInstrument instrument(String ticker);

    RHQuote quote(String ticker);

    List<RHSplit> splits(String ticker);
}
