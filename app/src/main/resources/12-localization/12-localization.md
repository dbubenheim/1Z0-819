# Localization

## Locale
A Locale object represents a specific geographical, political, or cultural region.

## Locale methods
- `Locale.getDefault()`
- `getDisplayCountry()`
- `getDisplayLanguage()`
- `getDisplayVariant()`
- `getDisplayName()`
- `getLanguage()`
- `getCountry()`
- `getVariant()`

`Locale.setDefault(Locale.US)`
`Locale.setDefault(Locale.Category.FORMAT, Locale.US)`

## Locale.Category
- `FORMAT`
- `DISPLAY`

## Locale.Builder

- `Locale.Builder().setLanguage("de").setCountry("DE").build()`


## ResourceBundle

- `ResourceBundle.getBundle("someName", locale)`

## Resource Bundle Properties File

```
my.msg = Hello
another.key = Bye
```

Name File | Key | Value
------ | ------ | --------
Bundle.properties      | my.msg | Hello   
Bundle_fr.properties   | my.msg | Bonjour   
Bundle_de.properties   | my.msg | Hallo   
Bundle_en.properties   | my.msg | Hello   

## Currency

```
Locale locale = Locale.getDefault();
Locale locale = new Locale("en", "US");
Currency currency = Currency.getInstance(locale);
String symbol = currency.getSymbol();
String code = currency.getCurrencyCode();
//val displayName = currency.getDisplayName();
//val a = getAvailableCurrencies();
```

## Formatting

### Text 
The text style is determined based on the number of pattern letters used. Less than 4 pattern letters will use the short form. Exactly 4 pattern letters will use the full form. Exactly 5 pattern letters will use the narrow form. Pattern letters 'L', 'c', and 'q' specify the stand-alone form of the text styles.

### Number
If the count of letters is one, then the value is output using the minimum number of digits and without padding. Otherwise, the count of digits is used as the width of the output field, with the value zero-padded as necessary. The following pattern letters have constraints on the count of letters. Only one letter of 'c' and 'F' can be specified. Up to two letters of 'd', 'H', 'h', 'K', 'k', 'm', and 's' can be specified. Up to three letters of 'D' can be specified.

### Number/Text
If the count of pattern letters is 3 or greater, use the Text rules above. Otherwise use the Number rules above.

### Short form
Short text, typically an abbreviation. For example, day-of-week Monday might output "Mon".

### Full form
Full text, typically the full description. For example, day-of-week Monday might output "Monday".

### Narrow form
Narrow text, typically a single letter. For example, day-of-week Monday might output "M".
