package uk.sky;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import uk.sky.model.LogLine;
import uk.sky.utils.ReadFile;

import java.io.FileReader;
import java.util.Collection;

class DataFiltererLogLineByCountryTest {

    public static final DataFilterer<LogLine> filterer = new DataFiltererLogLine();


    public static final String GB_COUNTRY = "GB";
    public static final String US_COUNTRY = "US";
    public static final String DE_COUNTRY = "DE";

    private static void runFilterCountryTC(
            DataFilterer<LogLine> filterer,
            FileReader file,
            String country,
            int expected
    ) {
        Collection<LogLine> res = filterer.filterByCountry(file, country);

        Assertions.assertEquals(expected, res.size());
    }

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testFilterByCountryNoCountryProvided() {
        runFilterCountryTC(filterer, ReadFile.readEmptyFile(), null, 0);
        runFilterCountryTC(filterer, ReadFile.readEmptyFile(), "", 0);
        runFilterCountryTC(filterer, ReadFile.readEmptyFile(), "    ", 0);
    }

    @Test
    void testFilterByCountryEmptyFile() {
        runFilterCountryTC(filterer, ReadFile.readEmptyFile(), GB_COUNTRY, 0);
        runFilterCountryTC(filterer, ReadFile.readEmptyFile(), US_COUNTRY, 0);
        runFilterCountryTC(filterer, ReadFile.readEmptyFile(), DE_COUNTRY, 0);
    }

    @Test
    void testFilterByCountryHeaderOnlyFile() {
        runFilterCountryTC(filterer, ReadFile.readHeaderOnlyFile(), GB_COUNTRY, 0);
        runFilterCountryTC(filterer, ReadFile.readHeaderOnlyFile(), US_COUNTRY, 0);
        runFilterCountryTC(filterer, ReadFile.readHeaderOnlyFile(), DE_COUNTRY, 0);
    }

    @Test
    void testFilterByCountryOneLineFile() {
        runFilterCountryTC(filterer, ReadFile.readOneLineFile(), GB_COUNTRY, 0);
        runFilterCountryTC(filterer, ReadFile.readOneLineFile(), US_COUNTRY, 1);
        runFilterCountryTC(filterer, ReadFile.readOneLineFile(), DE_COUNTRY, 0);
    }

    @Test
    void testFilterByCountryMultiLineFile() {
        runFilterCountryTC(filterer, ReadFile.readMultiLineFile(), GB_COUNTRY, 1);
        runFilterCountryTC(filterer, ReadFile.readMultiLineFile(), US_COUNTRY, 3);
        runFilterCountryTC(filterer, ReadFile.readMultiLineFile(), DE_COUNTRY, 1);
    }
}
