package uk.sky.csv;

import uk.sky.model.LogLine;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Collection;
import java.util.Objects;
import java.util.stream.Collectors;

public class CSVParser {

    public static Collection<LogLine> parseLogs(Reader reader) {
        try (BufferedReader bufferedReader = new BufferedReader(reader)) {
            String headerLine = bufferedReader.readLine();

            System.out.println("----- Start HEADER line is ----");
            System.out.println(headerLine);
            System.out.println("----- End HEADER line is ----");


            //parse data rows
            return bufferedReader.lines()
                    .filter(Objects::nonNull)
                    .filter(e -> !e.isBlank())
                    .map(row -> {
                        String[] columnsData = row.split(",");
                        return new LogLine(
                                Long.parseLong(columnsData[0]),
                                columnsData[1],
                                Long.parseLong(columnsData[2])
                        );
                    })
                    .collect(Collectors.toList());

        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
