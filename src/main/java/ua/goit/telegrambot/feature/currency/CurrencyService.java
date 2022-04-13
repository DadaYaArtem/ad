package ua.goit.telegrambot.feature.currency;

import ua.goit.telegrambot.feature.currency.dto.Currency;

import java.util.List;

public interface CurrencyService {
    List<Double> getRate(Currency currency);
}
