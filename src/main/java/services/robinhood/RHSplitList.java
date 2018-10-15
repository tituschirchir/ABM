package services.robinhood;

import java.util.ArrayList;
import java.util.List;

public class RHSplitList {
    private List<RHSplit> results;

    public RHSplitList() {
        results = new ArrayList<>();
    }

    public List<RHSplit> getResults() {
        return results;
    }

    public void setResults(List<RHSplit> results) {
        this.results = results;
    }
}
