package uk.sky;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.sky.model.LogLine;
import uk.sky.utils.ReadFile;

import java.io.FileReader;
import java.util.Collection;

class DataFiltererLogLineByAboveAvgLimitTest {

    public static final DataFilterer<LogLine> filterer = new DataFiltererLogLine();

    private static void runFilterCountryTC(
            DataFilterer<LogLine> filterer,
            FileReader file,
            int expected
    ) {
        Collection<LogLine> res = filterer.filterByResponseTimeAboveAverage(file);

        Assertions.assertEquals(expected, res.size());
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }


    @Test
    void testFilterByAboveAvgLimitEmptyFile() {
        runFilterCountryTC(filterer, ReadFile.readEmptyFile(), 0);
    }

    @Test
    void testFilterByAboveAvgLimitHeaderOnlyFile() {
        runFilterCountryTC(filterer, ReadFile.readHeaderOnlyFile(), 0);
    }

    @Test
    void testFilterByAboveAvgLimitOneLineFile() {
        runFilterCountryTC(filterer, ReadFile.readOneLineFile(), 0);
    }

    @Test
    void testFilterByAboveAvgLimitMultiLineFile() {
        runFilterCountryTC(filterer, ReadFile.readMultiLineFile(), 3);
    }
}
