package de.dbubenheim.learning;

import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class DateAndTimeTest {

    @Test
    public void testLocalDateTime() {

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTime = LocalDateTime.of(2020, 1, 10, 21, 55, 33, 123);
        assertThat(localDateTime.getNano()).isEqualTo(123);
        assertThat(localDateTime.getSecond()).isEqualTo(33);
        assertThat(localDateTime.getMinute()).isEqualTo(55);
        assertThat(localDateTime.getHour()).isEqualTo(21);
        assertThat(localDateTime.getDayOfMonth()).isEqualTo(10);
        assertThat(localDateTime.getMonthValue()).isEqualTo(1);
        assertThat(localDateTime.getYear()).isEqualTo(2020);

        LocalDateTime ldt1 = LocalDateTime.of(2020, 1, 1, 1, 1, 1, 1);
        LocalDateTime ldt2 = LocalDateTime.of(2020, 1, 1, 1, 1, 1, 2);
        assertThat(ldt1.isAfter(ldt2)).isFalse();
        assertThat(ldt2.isAfter(ldt1)).isTrue();
        assertThat(ldt2.isEqual(ldt1)).isFalse();
        assertThat(ldt1.isEqual(ldt1)).isTrue();
    }

    @Test
    public void testLocalDate() {
        LocalDate localDate = LocalDate.of(2021, 5, 9);
        assertThat(localDate.getYear()).isEqualTo(2021);
        assertThat(localDate.getMonthValue()).isEqualTo(5);
        assertThat(localDate.getDayOfWeek().getValue()).isEqualTo(7);
        assertThat(localDate.getDayOfMonth()).isEqualTo(9);
        assertThat(localDate.getDayOfYear()).isEqualTo(129);

        LocalDate l1 = LocalDate.of(2020, 1, 1);
        LocalDate l2 = LocalDate.of(2020, 1, 2);
        assertThat(l1.isAfter(l2)).isFalse();
        assertThat(l1.isBefore(l2)).isTrue();
        assertThat(l1.isEqual(l2)).isFalse();
    }

    @Test
    public void testLocalTime() {
        LocalTime localTime = LocalTime.of(20, 15);
        assertThat(localTime.getHour()).isEqualTo(20);
        assertThat(localTime.getMinute()).isEqualTo(15);
        assertThat(localTime.minus(10, ChronoUnit.MINUTES)).isEqualTo(LocalTime.of(20, 5));
        assertThat(localTime.plusHours(2)).isEqualTo(LocalTime.of(22, 15));
        assertThat(localTime.minus(Duration.of(23, ChronoUnit.DAYS))).isEqualTo(LocalTime.of(20, 15));
        assertThat(localTime.minus(12, ChronoUnit.HOURS)).isEqualTo(LocalTime.of(8, 15));
        assertThat(localTime.minusMinutes(19)).isEqualTo(LocalTime.of(19, 56));
    }
}
