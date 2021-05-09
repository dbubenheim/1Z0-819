package de.dbubenheim.learning;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Currency;
import java.util.Locale;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CurrencyTest {

    @ParameterizedTest
    @CsvSource({
            "de, DE, Euro, €, EUR",
            "en, US, US Dollar, US$, USD",
            "en, GB, British Pound, £, GBP",
            "en, AU, Australian Dollar, A$, AUD",
            "ru, RU, Russian Rouble, RUB, RUB",
            "en, ZA, South African Rand, ZAR, ZAR",
            "cn, CN, Chinese Yuan, CN¥, CNY",
    })
    public void testCurrency(
            final String language,
            final String country,
            final String displayName,
            final String symbol,
            final String currencyCode
    ) {
        final Locale locale = new Locale(language, country);
        final Currency currency = Currency.getInstance(locale);
        assertThat(currency.getDisplayName()).isEqualTo(displayName);
        assertThat(currency.getCurrencyCode()).isEqualTo(currencyCode);
        assertThat(currency.getSymbol()).isEqualTo(symbol);
    }
}
