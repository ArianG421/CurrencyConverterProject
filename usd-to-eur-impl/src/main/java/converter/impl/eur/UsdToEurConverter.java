package converter.impl.eur;

import converter.spi.CurrencyConverter;
import converter.spi.ConverterName;

@ConverterName("USD till EUR")
public class UsdToEurConverter implements CurrencyConverter {
    @Override
    public double convert(double amount) {
        return amount * 0.92; // Exempelväxelkurs
    }
}
