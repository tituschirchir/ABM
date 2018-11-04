package services;

import avro.Company;
import avro.Tick;
import dataaccess.models.PriceHistory;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
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


    avro.Company iexStock(String ticker);


    List<Tick> ticks(String ticker);

    avro.Company companies(@RequestParam("ticker") String ticker);
}
