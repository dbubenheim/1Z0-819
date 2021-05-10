package de.dbubenheim.learning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DateAndTimeFormatterTest {

    @ParameterizedTest
    @CsvSource({
            "eeee d'st day of' MMMM yyyy, Monday 21st day of January 2019",
            "eee d'st day of' MMM yyyy, Mon 21st day of Jan 2019",
            "eeeee d'st day of' MMMMM yyyy, M 21st day of J 2019",
    })
    public void testDateFormatting(final String pattern, final String result) {
        LocalDate now = LocalDate.of(2019, 1, 21);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(pattern);
        assertThat(dtf1.format(now)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "dd.MM.YYYY, de, DE, 02.02.2022",
            "dd. MMM YYYY, de, DE, 02. Feb. 2022",
            "dd. MMMM YYYY, de, DE, 02. Februar 2022",
            "dd. MMMM YYYY, en, GB, 02. February 2022",
            "dd. MMMM YYYY, it, IT, 02. febbraio 2022",
            "dd/MMMMM/YYYY, en, US, 02/F/2022",
            "dd/MMMMM/YYYYY, en, US, 02/F/02022",
            "d/MMMMM/YY, en, US, 2/F/22",
    })
    public void testDateFormattingWithLocale(final String pattern, final String language, final String country, final String result) {
        Locale locale = new Locale(language, country);
        LocalDate now = LocalDate.of(2022, 2, 2);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(pattern, locale);
        assertThat(dtf1.format(now)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "hh:mm:ss:nnn, 08:15:32:865",
            "HH:mm:ss:nnn, 20:15:32:865",
            "kk:mm:ss:nnn, 20:15:32:865",
            "HH:mm:ss:nnnnnn, 20:15:32:000865",
            "HH:mm:ss:nnn, 20:15:32:000865",
    })
    public void testTimeFormattingWithLocale(final String pattern, final String result) {
        LocalTime now = LocalTime.of(20, 15, 32, 865);
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern(pattern);
        assertThat(dtf1.format(now)).isEqualTo(result);
    }
}
