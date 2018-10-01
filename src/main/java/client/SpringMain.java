package client;

import models.jdbctest.DAO.PriceHistoryDAO;
import models.jdbctest.PriceHistory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Timestamp;


public class SpringMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring.xml");

        PriceHistoryDAO phDao = ctx.getBean("priceHistoryDao", PriceHistoryDAO.class);

        PriceHistory emp = new PriceHistory();
        emp.setTicker("GS");
        Timestamp time = Timestamp.valueOf("2017-01-04 23:59:00.0");
        emp.setTime(time);
        emp.setValue(224.0);

        //Create
        phDao.save(emp);

        units.PriceHistory gs = phDao.getHistory("GS");
        ctx.close();
    }

}
