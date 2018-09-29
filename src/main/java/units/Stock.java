package units;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Stock {
    Stack<Price> prices = new Stack<>();

    public List<Double> getTsReturns() {
        List<Double> vals = prices.stream()
                .sorted(Comparator.comparing(Price::getTime))
                .map(Price::getValue).collect(Collectors.toList());
        return IntStream.range(1, vals.size())
                .mapToObj(x -> (vals.get(x) - vals.get(x - 1)) / vals.get(x - 1))
                .collect(Collectors.toList());
    }

    public void pushPrice(Price... p) {
        Arrays.asList(p).forEach(x -> prices.push(x));
    }
}
