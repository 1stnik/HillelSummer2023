package com.telegram.example.telegram;

import com.telegram.example.dto.BotUsersService;
import com.telegram.example.exception.UserNotFoundException;
import java.net.UnknownServiceException;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.ReplyKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.KeyboardRow;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Service
@RequiredArgsConstructor
public class TelegramBot extends TelegramLongPollingBot {

    @Value("${telegram.bot.username}")
    private String username;

    @Value("${telegram.bot.token}")
    private String token;

    private final BotUsersService botUsersService;

    @Override
    public String getBotUsername() {
        return username;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            log.info("receive from bot : {}", messageText);
            Message message = update.getMessage();

            if (message.getText().equals("/start")) {
               if (botUsersService.addUser(message.getChatId())){
                   SendMessage mes = new SendMessage();
                   mes.setChatId(message.getChatId());
                   mes.setText("Hello  " + message.getFrom().getUserName());

                   executeMessage(keyBoard(message));
               };
            } else if (message.getText().startsWith("all:")){
                botUsersService.getUsers().forEach(id -> {
                    String newMessage = message.getText()
                            .replace("all:", message.getFrom().getUserName() + " : ");

                    sendMessage(id, newMessage);
                });
            } else if (message.getText().equals("Button_1")){
                message.setText(botUsersService.getUsers().toString());
                executeMessage(keyBoard1(message));
            } else if(message.getText().equals("Button_2")){
                executeMessage(keyBoard2(message));
            } else {
                executeMessage(keyBoard(message));
            }



//            log.info("------------------------");
//            log.info("User information");
//            log.info("Chat id :{}", message.getChatId().toString());
//            log.info("User id :{}", message.getFrom().getId());
//            log.info("Last Name id :{}",message.getFrom().getLastName());
//            log.info("First Name :{}",message.getFrom().getFirstName());
//            log.info("------------------------");

//            SendMessage mes = new SendMessage();
//            mes.setChatId(message.getChatId());
//            mes.setText("echo: " + messageText);
//
//            executeMessage(mes);

        }
    }

    public void sendMessage(long chatId, String textToSend){
        if (!botUsersService.isUserExist(chatId)){
            throw new UserNotFoundException(String.valueOf(chatId));
        }

        SendMessage message = new SendMessage();
        message.setChatId(String.valueOf(chatId));
        message.setText(textToSend);
        executeMessage(message);
    }

    private void executeMessage(SendMessage message){
        try {
            execute(message);
        } catch (TelegramApiException e) {
            System.out.println(e.getMessage());
        }
    }

    public SendMessage keyBoard(Message message) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("Button_1");
        row1.add("Button_2");
        row1.add("Button_3");
        keyboardRows.add(row1);

        KeyboardRow row2 = new KeyboardRow();
        row2.add("Button_4");
        keyboardRows.add(row2);
        markup.setKeyboard(keyboardRows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Please select");
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }

    public SendMessage keyBoard1(Message message) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("Button_1_1");
        row1.add("Button_2_1");
        row1.add("Button_3_1");
        keyboardRows.add(row1);
        markup.setKeyboard(keyboardRows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("Please select");
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }

    public SendMessage keyBoard2(Message message) {
        ReplyKeyboardMarkup markup = new ReplyKeyboardMarkup();
        List<KeyboardRow> keyboardRows = new ArrayList<KeyboardRow>();

        KeyboardRow row1 = new KeyboardRow();
        row1.add("Button_1_2");
        row1.add("Button_2_2");
        row1.add("Button_3_2");
        keyboardRows.add(row1);
        markup.setKeyboard(keyboardRows);
        markup.setResizeKeyboard(true);
        markup.setOneTimeKeyboard(true);
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message.getText());
        sendMessage.setChatId(String.valueOf(message.getChatId()));
        sendMessage.setReplyMarkup(markup);
        return sendMessage;
    }

}
