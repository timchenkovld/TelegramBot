package org.telegram_bot.bank.impl;

import org.telegram_bot.bank.Currency;
import org.telegram_bot.bank.CurrencyPrettier;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class CurrencyPrettierImpl implements CurrencyPrettier {

    public static final String FORMAT = "Курс валюти %s до %s = %s";
    @Override
    public String pretty(double rate, Currency currency) {
        DecimalFormat decimalFormat = new DecimalFormat("#.##");
        decimalFormat.setRoundingMode(RoundingMode.CEILING);
        String formattedRate = decimalFormat.format(rate);
        return String.format(FORMAT, currency, Currency.UAH, formattedRate);
    }
}
