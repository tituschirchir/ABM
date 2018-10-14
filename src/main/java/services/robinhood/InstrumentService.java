package services.robinhood;

import dataaccess.models.Quote;
import dataaccess.models.RHTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class InstrumentService {
    private final RestTemplate restTemplate;

    @Autowired
    public InstrumentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public RHCompany getCompanyInfo(String ticker) {
        String url = String.format("https://api.robinhood.com/fundamentals/%s/", ticker.toUpperCase());
        ResponseEntity<RHCompany> rhi = restTemplate.getForEntity(url, RHCompany.class);
        RHCompany company = rhi.getBody();
        company.setRhInstrument("http://localhost:1212/instrument?ticker=" + ticker);
        company.setSplits("http://localhost:1212/splits?ticker=" + ticker);
        company.setQuote("http://localhost:1212/quote?ticker=" + ticker);
        return company;
    }

    public RHInstrument getInstrumentInfo(String ticker) {
        RHCompany company = getCompanyInfo(ticker);
        ResponseEntity<RHInstrument> instrumentResponseEntity = restTemplate.getForEntity(company.getInstrument(), RHInstrument.class);
        return instrumentResponseEntity.getBody();
    }

    public RHQuote getQuote(String ticker) {
        String url = String.format("https://api.robinhood.com/quotes/%s/", ticker.toUpperCase());
        ResponseEntity<RHQuote> rhi = restTemplate.getForEntity(url, RHQuote.class);
        if (rhi == null) return null;
        RHQuote quote = rhi.getBody();
        Quote quoted = RHTransformer.TO_QUOTE.apply(quote);
        return quote;
    }

    public List<RHSplit> getSplits(String ticker) {
        RHSplitList forObject = restTemplate.getForObject(getInstrumentInfo(ticker).getSplits(),
                RHSplitList.class);
        return forObject.getResults();
    }
}
