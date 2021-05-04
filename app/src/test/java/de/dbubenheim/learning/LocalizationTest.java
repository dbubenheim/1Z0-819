package de.dbubenheim.learning;

import org.junit.jupiter.api.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static org.assertj.core.api.Assertions.assertThat;

public class LocalizationTest {

    @Test
    public void testGerman() {
        var locale = Locale.GERMAN;
        var resourceBundle = ResourceBundle.getBundle("bundle", locale);
        var key1 = resourceBundle.getString("key1");
        assertThat(key1).isEqualTo("Guten Tag");
    }


    @Test
    public void testEnglish() {
        var locale = Locale.ENGLISH;
        var resourceBundle = ResourceBundle.getBundle("bundle", locale);
        var key1 = resourceBundle.getString("key1");
        assertThat(key1).isEqualTo("Good day");
    }

    @Test
    public void testFrench() {
        var locale = Locale.FRENCH;
        var resourceBundle = ResourceBundle.getBundle("bundle", locale);
        var key1 = resourceBundle.getString("key1");
        assertThat(key1).isEqualTo("Bonjour");
    }
}
