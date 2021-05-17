package de.dbubenheim.learning;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class OptionalTest {

    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    public void testIsPresent() {
        Optional<String> optional = Optional.of("123");
        assertThat(optional.isPresent()).isTrue();
        assertThat(optional.get()).isEqualTo("123");
        assertThat(optional).isNotEqualTo(Optional.empty());
    }

    @Test
    public void testOfCreatesNewInstance() {
        Optional<String> optional = Optional.of("123");
        optional.of("345");
        assertThat(optional.get()).isEqualTo("123");
    }

    @Test
    public void testOrElse() {
        Optional<String> optional = Optional.empty();
        assertThat(optional.orElse("Hello")).isEqualTo("Hello");
    }

    @Test
    public void testIfPresent() {
        Consumer<String> s = System.out::println;
        Optional<String> optional = Optional.of("Hello 123");
        optional.ifPresent(s);
        assertThat(outputStreamCaptor.toString().trim()).isEqualTo("Hello 123");
    }

    @Test
    public void testGetThrowsException() {
        Optional<String> optional = Optional.empty();
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, optional::get);
        assertThat(exception.getMessage()).isEqualTo("No value present");
    }

    @Test
    public void testOfNullThrowsException() {
        Exception exception = assertThrows(NullPointerException.class, () -> Optional.of(null));
        assertThat(exception.getMessage()).isNull();
    }

    @Test
    public void testOfNullableIsEmpty() {
        Optional<String> optional = Optional.ofNullable(null);
        assertThat(optional).isEqualTo(Optional.empty());
        NoSuchElementException exception = assertThrows(NoSuchElementException.class, optional::get);
        assertThat(exception.getMessage()).isEqualTo("No value present");
    }

    @Test
    public void testOfNullableThrowsException() {
        Optional<String> optional = Optional.ofNullable("123");
        assertThat(optional.get()).isEqualTo("123");
    }
}
