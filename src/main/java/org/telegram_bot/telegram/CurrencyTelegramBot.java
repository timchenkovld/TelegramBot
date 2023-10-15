package org.telegram_bot.telegram;

import org.telegram.telegrambots.extensions.bots.commandbot.TelegramLongPollingCommandBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram_bot.bank.CurrencyPrettier;
import org.telegram_bot.bank.CurrencyService;
import org.telegram_bot.bank.impl.CurrencyPrettierImpl;
import org.telegram_bot.bank.impl.PrivateBankCurrencyService;
import org.telegram_bot.telegram.command.HelpCommand;
import org.telegram_bot.bank.Currency;
import org.telegram_bot.telegram.command.StartCommand;

import java.util.List;

public class CurrencyTelegramBot extends TelegramLongPollingCommandBot {
    private CurrencyService currencyService;
    private CurrencyPrettier currencyPrettier;
    public CurrencyTelegramBot() {
        this.currencyService = new PrivateBankCurrencyService();
        this.currencyPrettier = new CurrencyPrettierImpl();
        register(new HelpCommand());
        register(new StartCommand());
    }

    @Override
    public String getBotUsername() {
        return LoginConstants.NAME;
    }

    @Override
    public String getBotToken() {
        return LoginConstants.TOKEN;
    }

    @Override
    public void onUpdatesReceived(List<Update> updates) {
        super.onUpdatesReceived(updates);
//        System.out.println("Update received ");
    }

    @Override
    public void processNonCommandUpdate(Update update) {
        if (update.hasCallbackQuery()) {
            String callbackData = update.getCallbackQuery().getData();

            String rate = getRate(Currency.valueOf(callbackData));

            SendMessage sendMessage = new SendMessage();
            sendMessage.setText(rate);
            sendMessage.setChatId(update.getCallbackQuery().getMessage().getChatId());

            try {
                execute(sendMessage);
            } catch (TelegramApiException e) {
                System.out.println("Error while responding");
            }
        }
        if (update.hasMessage()){
            String msg = "You just wrote + " + update.getMessage().getText();
            System.out.println(msg);
        }
    }

    private String getRate(Currency currency) {
        return currencyPrettier.pretty(currencyService.getRate(currency), currency);
    }
}
