package ua.goit.telegrambot.feature.currency;

import ua.goit.telegrambot.feature.currency.dto.Currency;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class FileUpdate extends Thread {
    private static final String ABSOLUTE_PATH = "src\\main\\resources\\Currency_rates.txt";

    //update file with currency every 6 min
    @Override
    public void run() {

        while (true) {

            try {
                CurrencyService currencyServiceNBU = new NBUCurrencyService();
                List<Double> nbuRateUSD = currencyServiceNBU.getRate(Currency.USD);
                List<Double> nbuRateEUR = currencyServiceNBU.getRate(Currency.EUR);
                List<Double> nbuRateGBP = currencyServiceNBU.getRate(Currency.GBP);

                CurrencyService currencyServicePrivat = new PrivateBankCurrencyService();
                List<Double> privateRateUSD = currencyServicePrivat.getRate(Currency.USD);
                List<Double> privateRateEUR = currencyServicePrivat.getRate(Currency.EUR);

                CurrencyService currencyServiceMono = new MonoCurrencyService();
                List<Double> monoRateUSD = currencyServiceMono.getRate(Currency.USD);

                File file = new File(ABSOLUTE_PATH);

                if (!file.exists()) {
                    file.getParentFile().mkdirs();

                    try {
                        file.createNewFile();
                    } catch (IOException e) {
                        System.err.println(e.getMessage());
                    }
                }

                try (FileWriter writer = new FileWriter(file)) {
                    writer.write("bank NBU" +
                            "\nbuyUSD " + nbuRateUSD.get(0) +
                            "\nbuyEUR " + nbuRateEUR.get(0) +
                            "\nbuyGBP " + nbuRateGBP.get(0) +
                            "\nbank Privat" +
                            "\nbuyUSD " + privateRateUSD.get(0) +
                            "\nsaleUSD " + privateRateUSD.get(1) +
                            "\nbuyEUR " + privateRateEUR.get(0) +
                            "\nsaleEUR " + privateRateEUR.get(1) +
                            "\nbank Mono" +
                            "\nbuyUSD " + monoRateUSD.get(0) +
                            "\nsaleUSD " + monoRateUSD.get(1) +
                            "\nbuyEUR " + monoRateUSD.get(2) +
                            "\nsaleEUR " + monoRateUSD.get(3));
                } catch (IOException e) {
                    System.err.println(e.getMessage());
                }

            } catch (IllegalStateException e){
                System.err.println(e.getMessage());
            }
            finally {
                //delay 6 min
                try {
                    TimeUnit.SECONDS.sleep(360);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}