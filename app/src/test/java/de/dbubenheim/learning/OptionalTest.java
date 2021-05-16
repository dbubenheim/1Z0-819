package de.dbubenheim.learning;

import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class OptionalTest {

    @Test
    public void test() {

        Optional<String> optional = Optional.of("123");
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional.get()).isEqualTo("123");
        assertThat(optional).isNotEqualTo(Optional.empty());

    }
}
