package org.telegram_bot.bank;

public interface CurrencyPrettier {
    String pretty(double rate, Currency currency);
}
