package de.dbubenheim.learning;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ToXXXFunctionTest {

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "123, 123",
            "99999, 99999"
    })
    public void testToIntFunction(final String input, final int result) {
        ToIntFunction<String> toIntFunction = Integer::parseInt;
        assertThat(toIntFunction.applyAsInt(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1.0",
            "123, 123.0",
            "999.99, 999.99"
    })
    public void testToDoubleFunction(final String input, final double result) {
        ToDoubleFunction<String> toDoubleFunction = Double::parseDouble;
        assertThat(toDoubleFunction.applyAsDouble(input)).isEqualTo(result);
    }

    @ParameterizedTest
    @CsvSource({
            "1, 1",
            "123, 123",
            "99999, 99999"
    })
    public void testToLongFUnction(final String input, final long result) {
        ToLongFunction<String> toDoubleFunction = Long::parseLong;
        assertThat(toDoubleFunction.applyAsLong(input)).isEqualTo(result);
    }
}
