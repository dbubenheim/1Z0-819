package de.dbubenheim.learning;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CollectorsJoiningTest {

    @ParameterizedTest
    @CsvSource(delimiter = '|', value = {
            ",|-|+|-a,b,c,d,e,f+",
            "_|_|_|_a_b_c_d_e_f_",
            "|||abcdef",
            "_|@|@|@a_b_c_d_e_f@",
    })
    public void test(final String delimiter, final String prefix, final String suffix, final String result) {
        Stream<String> stream = Stream.of("a", "b", "c", "d", "e", "f");
        Collector<CharSequence, ?, String> collector;
        if (delimiter == null) {
            collector = Collectors.joining();
        }
        else {
            collector = Collectors.joining(delimiter, prefix, suffix);
        }
        String string = stream.collect(collector);
        assertThat(string).isEqualTo(result);
    }
}
