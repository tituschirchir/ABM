package services;

import avro.Tick;
import dataaccess.DAO.CompanyDao;
import dataaccess.DAO.PriceHistoryDAO;
import dataaccess.models.Company;
import dataaccess.models.PriceHistory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import services.robinhood.*;

import java.util.List;

@Controller
public class ExchangeServiceImpl implements ExchangeService {

    private final PriceHistoryDAO phDao;
    private final CompanyDao companyDao;
    private final InstrumentService instrumentService;

    @Autowired
    public ExchangeServiceImpl(PriceHistoryDAO phDao, CompanyDao companyDao, InstrumentService instrumentService) {
        this.phDao = phDao;
        this.companyDao = companyDao;
        this.instrumentService = instrumentService;
    }

    @RequestMapping(path = "/price", method = RequestMethod.GET)
    @ResponseBody
    public List<PriceHistory> pricesHistoryFor(@RequestParam("ticker") String ticker) {
        return phDao.getHistory(ticker);
    }

    @Override
    @RequestMapping(path = "/companies", method = RequestMethod.GET)
    @ResponseBody
    public List<Company> companies() {
        return companyDao.allCompanies();
    }

    @Override
    @RequestMapping(path = "/company", method = RequestMethod.GET)
    @ResponseBody
    public RHCompany company(@RequestParam("ticker") String ticker) {
        return instrumentService.getCompanyInfo(ticker);
    }

    @Override
    @RequestMapping(path = "/instrument", method = RequestMethod.GET)
    @ResponseBody
    public RHInstrument instrument(@RequestParam("ticker") String ticker) {
        return instrumentService.getInstrumentInfo(ticker);
    }

    @Override
    @RequestMapping(path = "/quote", method = RequestMethod.GET)
    @ResponseBody
    public RHQuote quote(@RequestParam("ticker") String ticker) {
        return instrumentService.getQuote(ticker);
    }

    @Override
    @RequestMapping(path = "/splits", method = RequestMethod.GET)
    @ResponseBody
    public List<RHSplit> splits(@RequestParam("ticker") String ticker) {
        return instrumentService.getSplits(ticker);
    }

    @Override
    @RequestMapping(path = "/iexStock", method = RequestMethod.GET)
    @ResponseBody
    public avro.Company iexStock(@RequestParam("ticker") String ticker) {
        return instrumentService.getIexStock(ticker);
    }
    @Override
    @RequestMapping(path = "/ticks", method = RequestMethod.GET)
    @ResponseBody
    public List<Tick> ticks(@RequestParam("ticker") String ticker) {
        return instrumentService.getTicks(ticker);
    }

}
