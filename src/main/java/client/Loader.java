package client;

import injectors.Companies;
import models.impls.Company;
import models.products.Stock;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class Loader {
    public static void loadDb(String stocks, String companies) {
        try (Stream<String> companyStream = Files.lines(Paths.get(companies));
             Stream<String> stockStream = Files.lines(Paths.get(stocks))) {
            companyStream.map(x -> x.split(","))
                    .forEach(c -> Companies.getInstance().add(Company.create(c[0], c[1], c[2])));

            stockStream.map(x -> x.split(","))
                    .forEach(s -> Companies.get(s[0]).withStock(new Stock(Double.valueOf(s[1]))));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
