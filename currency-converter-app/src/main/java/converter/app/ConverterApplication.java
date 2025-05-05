package converter.app;

import converter.spi.ConverterName;
import converter.spi.CurrencyConverter;

import java.util.*;

public class ConverterApplication {
    public static void main(String[] args) {
        ServiceLoader<CurrencyConverter> loader = ServiceLoader.load(CurrencyConverter.class);
        List<CurrencyConverter> converters = new ArrayList<>();
        Map<Integer, CurrencyConverter> menuMap = new HashMap<>();

        int index = 1;
        System.out.println("Välj valutakonverterare:\n");

        for (CurrencyConverter converter : loader) {
            ConverterName annotation = converter.getClass().getAnnotation(ConverterName.class);
            String name = annotation != null ? annotation.value() : converter.getClass().getSimpleName();
            System.out.println(index + ". " + name);
            menuMap.put(index, converter);
            converters.add(converter);
            index++;
        }

        if (menuMap.isEmpty()) {
            System.out.println("Inga valutakonverterare hittades.");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("\nDitt val: ");
        int choice = scanner.nextInt();

        CurrencyConverter selectedConverter = menuMap.get(choice);
        if (selectedConverter == null) {
            System.out.println("Ogiltigt val!");
            return;
        }

        System.out.print("Ange belopp i USD: ");
        double amount = scanner.nextDouble();

        double result = selectedConverter.convert(amount);
        System.out.println("Konverterat belopp: " + result);
    }
}
