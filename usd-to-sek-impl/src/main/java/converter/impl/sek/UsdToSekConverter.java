package converter.impl.sek;

import converter.spi.CurrencyConverter;
import converter.spi.ConverterName;

@ConverterName("USD till SEK")
public class UsdToSekConverter implements CurrencyConverter {
    @Override
    public double convert(double amount) {
        return amount * 10.95; // Exempelväxelkurs
    }
}
