package uk.sky;

import uk.sky.csv.CSVParser;
import uk.sky.model.LogLine;

import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;

public class DataFiltererLogLine implements DataFilterer<LogLine> {
    @Override
    public Collection<LogLine> filterByCountry(Reader source, String country) {
        if (country == null || country.isBlank()) return Collections.emptyList();

        return CSVParser.parseLogs(source)
                .stream()
                .filter(e -> isTheSameCountry(e.getCountryCode(), country))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<LogLine> filterByCountryWithResponseTimeAboveLimit(Reader source, String country, long limit) {
        return null;
    }

    @Override
    public Collection<LogLine> filterByResponseTimeAboveAverage(Reader source) {
        return null;
    }

    private boolean isTheSameCountry(String country, String targetCountry) {
        if (country == null || targetCountry == null) return false;
        return country.equalsIgnoreCase(targetCountry);
    }
}
