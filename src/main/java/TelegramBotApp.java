import ua.goit.telegrambot.api.dto.MonoBankApi;
import ua.goit.telegrambot.feature.currency.*;
import ua.goit.telegrambot.feature.currency.dto.Currency;

import java.util.List;

import static ua.goit.telegrambot.api.dto.Currency.UAH;
import static ua.goit.telegrambot.api.dto.Currency.USD;

public class TelegramBotApp {
    public static void main(String[] args) {

        FileUpdate fileUpdate = new FileUpdate();
        fileUpdate.start();

        /*//Test NBU
        CurrencyService currencyServiceNBU = new NBUCurrencyService();
        List<Double> nbuRate = currencyServiceNBU.getRate(Currency.USD);
        System.out.println("NBU buy USD = " + nbuRate.get(0) + "\n");


        //Test Privat
        CurrencyService currencyServicePrivat = new PrivateBankCurrencyService();
        List<Double> privateRate = currencyServicePrivat.getRate(Currency.USD);
        System.out.println("Privat buy USD = " + privateRate.get(0));
        System.out.println("Privat sale USD = " + privateRate.get(1) + "\n");*/

        /*//Test Mono
        CurrencyService currencyServiceMono = new MonoCurrencyService();
        *//*System.out.println(currencyServiceMono.getRate(Currency.USD).get(0));
        System.out.println(currencyServiceMono.getRate(Currency.USD).get(1));
        System.out.println(currencyServiceMono.getRate(Currency.USD).get(0));*//*
        List<Double> monoRate = currencyServiceMono.getRate(Currency.USD);
        *//*System.out.println("Mono buy USD = " + monoRate.get(0));
        System.out.println("Mono sale USD = " + monoRate.get(1));
        System.out.println("Mono buy EUR = " + monoRate.get(2));
        System.out.println("Mono sale EUR = " + monoRate.get(3));*//*
        System.out.println("Mono buy GBP = " + monoRate.get(4));
        System.out.println("Mono sale GBP = " + monoRate.get(5));*/
    }

}
