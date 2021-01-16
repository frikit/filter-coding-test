package uk.sky;

import uk.sky.csv.CSVParser;
import uk.sky.model.LogLine;

import java.io.Reader;
import java.util.Collection;
import java.util.Collections;
import java.util.stream.Collectors;
import static java.util.stream.Collectors.averagingLong;

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
        return filterByCountry(source, country)
                .stream()
                .filter(e -> isInTheLimit(e.getResponseTime(), limit))
                .collect(Collectors.toList());
    }

    @Override
    public Collection<LogLine> filterByResponseTimeAboveAverage(Reader source) {
        Collection<LogLine> logLines = CSVParser.parseLogs(source);
        if (logLines.isEmpty()) return Collections.emptyList();

        double avgTime = avgTime(logLines);

        return logLines
                .stream()
                .filter(e -> isAboveLimit(e.getResponseTime(), avgTime))
                .collect(Collectors.toList());
    }

    private boolean isTheSameCountry(String country, String targetCountry) {
        if (country == null || targetCountry == null) return false;
        return country.equalsIgnoreCase(targetCountry);
    }

    private boolean isInTheLimit(long resp, long limit) {
        return resp <= limit;
    }

    private boolean isAboveLimit(long resp, double limit) {
        return resp > limit;
    }

    private double avgTime(Collection<LogLine> lines) {
        return lines.stream()
                .collect(averagingLong(LogLine::getResponseTime));
    }

}
