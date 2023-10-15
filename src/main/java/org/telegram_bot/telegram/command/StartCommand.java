package org.telegram_bot.telegram.command;

import org.telegram.telegrambots.extensions.bots.commandbot.commands.BotCommand;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Chat;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.bots.AbsSender;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.Arrays;
import java.util.Collections;

public class StartCommand extends BotCommand {


    public StartCommand() {
        super("start", "start description");
    }

    @Override
    public void execute(AbsSender absSender, User user, Chat chat, String[] strings) {
        String mainText = "Select currency you want to get rate XD";
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(mainText);
        sendMessage.setChatId(chat.getId());

        InlineKeyboardButton usdButton = InlineKeyboardButton.builder()
                .text("USD rate (доляры)")
                .callbackData("USD")
                .build();
        InlineKeyboardButton eurButton = InlineKeyboardButton.builder()
                .text("EUR rate (еврики)")
                .callbackData("EUR")
                .build();

        InlineKeyboardMarkup inlineKeyboardMarkup = InlineKeyboardMarkup.builder()
                .keyboard(Collections.singletonList(Arrays.asList(usdButton, eurButton)))
                .build();
        sendMessage.setReplyMarkup(inlineKeyboardMarkup);

        try {
            absSender.execute(sendMessage);
        } catch (TelegramApiException e) {
            System.out.println("Error during start command");
        }
    }
}
