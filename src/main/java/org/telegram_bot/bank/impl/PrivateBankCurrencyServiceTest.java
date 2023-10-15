package org.telegram_bot.bank.impl;

import org.telegram_bot.bank.Currency;
import org.telegram_bot.bank.CurrencyPrettier;
import org.telegram_bot.bank.CurrencyService;

public class PrivateBankCurrencyServiceTest {
    public static void main(String[] args) {
        CurrencyService privateBankCurrencyService = new PrivateBankCurrencyService();
        double rate = privateBankCurrencyService.getRate(Currency.USD);
        System.out.println("privateBankCurrencyService.getRate(Currency.USD) = " + rate);

        CurrencyPrettier currencyPrettier = new CurrencyPrettierImpl();
        System.out.println("currencyPrettier.pretty(rate, Currency.USD) = " +
                currencyPrettier.pretty(rate, Currency.USD));
    }
}