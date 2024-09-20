import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.AnswerCallbackQuery;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageReplyMarkup;
import org.telegram.telegrambots.meta.api.methods.updatingmessages.EditMessageText;
import org.telegram.telegrambots.meta.api.objects.Message;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.InlineKeyboardMarkup;
import org.telegram.telegrambots.meta.api.objects.replykeyboard.buttons.InlineKeyboardButton;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Bot extends TelegramLongPollingBot {
//        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
//            .configure("hibernate.cfg.xml").build();
//    Metadata metadata = new MetadataSources(registry)
//            .getMetadataBuilder().build();
//    SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
//
//    Session session = sessionFactory.openSession();
//    Transaction transaction = session.beginTransaction();
    private Set<Long> listUsersId = new HashSet<>();
    private HashMap<String, User> listUsers = new HashMap<>();
    String firstName;
    public InlineKeyboardButton sendForStartTest = InlineKeyboardButton.builder()
            .text("Send for start test")
            .callbackData("send for start test")
            .build();
    public InlineKeyboardButton planeQuestionOne = InlineKeyboardButton.builder()
            .text("Plane")
            .callbackData("plane")
            .build();
    public InlineKeyboardButton trainQuestionOne = InlineKeyboardButton.builder()
            .text("Train")
            .callbackData("train")
            .build();
    public InlineKeyboardButton carQuestionOne = InlineKeyboardButton.builder()
            .text("Car")
            .callbackData("car")
            .build();


    private InlineKeyboardMarkup sendQuestionOne = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(planeQuestionOne))
            .keyboardRow(List.of(carQuestionOne))
            .keyboardRow(List.of(trainQuestionOne))
            .build();

    private InlineKeyboardMarkup keyboardM1 = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(sendForStartTest))
            .build();
    public InlineKeyboardButton englandQuestionTwo = InlineKeyboardButton.builder()
            .text("UK")
            .callbackData("uK")
            .build();
    public InlineKeyboardButton france = InlineKeyboardButton.builder()
            .text("France")
            .callbackData("france")
            .build();
    public InlineKeyboardButton germany = InlineKeyboardButton.builder()
            .text("Germany")
            .callbackData("germany")
            .build();
    private InlineKeyboardMarkup sendQuestionTwo = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(englandQuestionTwo))
            .keyboardRow(List.of(france))
            .keyboardRow(List.of(germany))
            .build();
    public InlineKeyboardButton anaesthetist = InlineKeyboardButton.builder()
            .text("Anaesthetist")
            .callbackData("anaesthetist")
            .build();
    public InlineKeyboardButton anaesthetist1 = InlineKeyboardButton.builder()
            .text("Anaesthewerdst")
            .callbackData("anaesthewerdst")
            .build();
    public InlineKeyboardButton word3 = InlineKeyboardButton.builder()
            .text("Anearesrtyre")
            .callbackData("anearesrtyre")
            .build();
    private InlineKeyboardMarkup sendQuestionThree = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(anaesthetist))
            .keyboardRow(List.of(anaesthetist1))
            .keyboardRow(List.of(word3))
            .build();
    public InlineKeyboardButton wire1 = InlineKeyboardButton.builder()
            .text("Соединение")
            .callbackData("соединение")
            .build();
    public InlineKeyboardButton wire2 = InlineKeyboardButton.builder()
            .text("Провод")
            .callbackData("провод")
            .build();
    public InlineKeyboardButton wire3 = InlineKeyboardButton.builder()
            .text("Огонь")
            .callbackData("огонь")
            .build();
    private InlineKeyboardMarkup sendQuestionFour = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(wire1))
            .keyboardRow(List.of(wire2))
            .keyboardRow(List.of(wire3))
            .build();
    public InlineKeyboardButton charlesDickens = InlineKeyboardButton.builder()
            .text("Charles Dickens")
            .callbackData("charles Dickens")
            .build();
    public InlineKeyboardButton joan = InlineKeyboardButton.builder()
            .text("Joan Rouling")
            .callbackData("joan Rouling")
            .build();
    public InlineKeyboardButton oruel = InlineKeyboardButton.builder()
            .text("John Oruel")
            .callbackData("john Oruel")
            .build();
    private InlineKeyboardMarkup sendQuestionFive = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(charlesDickens))
            .keyboardRow(List.of(joan))
            .keyboardRow(List.of(oruel))
            .build();
    public InlineKeyboardButton Alphred = InlineKeyboardButton.builder()
            .text("Alphred Greatest")
            .callbackData("alphred Greatest")
            .build();
    public InlineKeyboardButton Athelstan = InlineKeyboardButton.builder()
            .text("Athelstan")
            .callbackData("athelstan")
            .build();
    public InlineKeyboardButton Cherchil = InlineKeyboardButton.builder()
            .text("Cherchil")
            .callbackData("cherchil")
            .build();
    private InlineKeyboardMarkup sendQuestionSix = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(Alphred))
            .keyboardRow(List.of(Athelstan))
            .keyboardRow(List.of(Cherchil))
            .build();
    public InlineKeyboardButton memorize1 = InlineKeyboardButton.builder()
            .text("Memoreze")
            .callbackData("memoreze")
            .build();
    public InlineKeyboardButton memorize2 = InlineKeyboardButton.builder()
            .text("Memorize")
            .callbackData("memorize")
            .build();
    public InlineKeyboardButton memorize3 = InlineKeyboardButton.builder()
            .text("Mimeroze")
            .callbackData("mimeroze")
            .build();
    private InlineKeyboardMarkup sendQuestionSeven = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(memorize1))
            .keyboardRow(List.of(memorize2))
            .keyboardRow(List.of(memorize3))
            .build();
    public InlineKeyboardButton sharlota = InlineKeyboardButton.builder()
            .text("Sharlota Bronte")
            .callbackData("sharlota Bronte")
            .build();
    public InlineKeyboardButton charlz = InlineKeyboardButton.builder()
            .text("Charlz Dicens")
            .callbackData("charlz Dicens")
            .build();

    public InlineKeyboardButton emily = InlineKeyboardButton.builder()
            .text("Emily Bronte")
            .callbackData("emily Bronte")
            .build();
    private InlineKeyboardMarkup sendQuestionEight = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(sharlota))
            .keyboardRow(List.of(charlz))
            .keyboardRow(List.of(emily))
            .build();
    public InlineKeyboardButton year1 = InlineKeyboardButton.builder()
            .text("1745")
            .callbackData("1745")
            .build();
    public InlineKeyboardButton year2 = InlineKeyboardButton.builder()
            .text("1896")
            .callbackData("1896")
            .build();
    public InlineKeyboardButton year3 = InlineKeyboardButton.builder()
            .text("1930")
            .callbackData("1930")
            .build();
    private InlineKeyboardMarkup sendQuestionNine = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(year1))
            .keyboardRow(List.of(year2))
            .keyboardRow(List.of(year3))
            .build();
    public InlineKeyboardButton lordOfRings = InlineKeyboardButton.builder()
            .text("1940")
            .callbackData("1940")
            .build();
    public InlineKeyboardButton lordOfRings2 = InlineKeyboardButton.builder()
            .text("1955")
            .callbackData("1955")
            .build();
    public InlineKeyboardButton lordOfRings3 = InlineKeyboardButton.builder()
            .text("1965")
            .callbackData("1965")
            .build();
    private InlineKeyboardMarkup sendQuestionTen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(lordOfRings))
            .keyboardRow(List.of(lordOfRings2))
            .keyboardRow(List.of(lordOfRings3))
            .build();


    @Override
    public String getBotUsername() {
        return "@english1209bot";
    }

    @Override
    public String getBotToken() {
        return "7515587275:AAEC7ziBiXxHydgVR2inE6F5d2D1d9ZB3xE";
    }

    @Override
    public void onUpdateReceived(Update update) {
        String[] arrayUpdate = String.valueOf(update).split(",+");
        for (String str : arrayUpdate) {
            if (str.contains("firstName")) {
                firstName = str.replace(" firstName=", "");
                System.out.println("First name: " + firstName);
                break;
            }
        }
        buttonTab(update, firstName);
        isCommand(update.getMessage());

    }

    public void isCommand(Message message) {
        String text = message.getText();
        // && !listUsersId.contains(message.getFrom().getId())
        if (text.equals("/start_test")) {

            User currentUser = new User();
            currentUser.setCountBallov(10);
            currentUser.setId(message.getFrom().getId());
            currentUser.setFirstName(message.getFrom().getFirstName());
            currentUser.setUserName(message.getFrom().getUserName());
            listUsers.put(currentUser.getFirstName(), currentUser);
            System.out.println("User \"" + listUsers.get(currentUser.getFirstName()) + "\" added!");

            sendMenu(message.getFrom().getId(), "<b>Go to the start test</b>", keyboardM1);
        }
    }

    public void sendMenu(Long who, String txt, InlineKeyboardMarkup km) {
        SendMessage sm = SendMessage.builder()
                .chatId(who.toString())
                .parseMode("HTML")
                .text(txt)
                .replyMarkup(km)
                .build();

        try {
            execute(sm);
        } catch (TelegramApiException tae) {
            throw new RuntimeException(tae);
        }
    }

    public void buttonTab(Update update, String firstName) {
        if (update.hasCallbackQuery()) {
            String idUser = update.getCallbackQuery().getMessage().getChatId().toString();
            int idMessage = update.getCallbackQuery().getMessage().getMessageId();
            String data = update.getCallbackQuery().getData();
            String queryId = update.getCallbackQuery().getId();

            EditMessageText editMessageText = EditMessageText.builder()
                    .chatId(idUser)
                    .messageId(idMessage)
                    .text("")
                    .build();

            EditMessageReplyMarkup editMessageReplyMarkup = EditMessageReplyMarkup.builder()
                    .chatId(idUser.toString())
                    .messageId(idMessage)
                    .build();


            User updateUser = listUsers.get(firstName); //listUsers.get(update.getMessage().getFrom().getFirstName());
            System.out.println("Get user: " + updateUser);


            if (data.equals("send for start test")) {
                editMessageText.setText("What transport create first in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionOne);
            } else if (data.equals("car")) {
                updateUser.addBall();
                editMessageText.setText("When begin history of origin English language?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwo);
            } else if (data.equals("plane")) {
                editMessageText.setText("When begin history of origin English language?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwo);
            } else if (data.equals("train")) {
                editMessageText.setText("When begin history of origin English language?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwo);
            } else if (data.equals("uK")) {
                updateUser.addBall();
                editMessageText.setText("Как пишется на английском языке слово Анестезиолог?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionThree);
            } else if (data.equals("france")) {
                editMessageText.setText("Как пишется на английском языке слово Анестезиолог?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionThree);
            } else if (data.equals("germany")) {
                editMessageText.setText("Как пишется на английском языке слово Анестезиолог?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionThree);
            } else if (data.equals("anaesthetist")) {
                updateUser.addBall();
                editMessageText.setText("Как переводится слово wire?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFour);
            } else if (data.equals("anaesthewerdst")) {
                editMessageText.setText("Как переводится слово wire?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFour);
            } else if (data.equals("anearesrtyre")) {
                editMessageText.setText("Как переводится слово wire?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFour);
            } else if (data.equals("Соединение")) {
                editMessageText.setText("Who write Oliver Twist?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFive);
            } else if (data.equals("провод")) {
                updateUser.addBall();
                editMessageText.setText("Who write Oliver Twist?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFive);
            } else if (data.equals("огонь")) {
                editMessageText.setText("Who write Oliver Twist?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFive);
            } else if (data.equals("charles Dickens")) {
                updateUser.addBall();
                editMessageText.setText("Who was the first king of UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSix);
            } else if (data.equals("joan Rouling")) {
                editMessageText.setText("Who was first king of UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSix);
            } else if (data.equals("john Oruel")) {
                editMessageText.setText("Who was the first king of UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSix);
            } else if (data.equals("alphred Greatest")) {
                updateUser.addBall();
                editMessageText.setText("Как по английски пишется слово выучить наизусть?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSeven);
            } else if (data.equals("athelstan")) {
                editMessageText.setText("Как по английски пишется слово выучить наизусть?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSeven);
            } else if (data.equals("cherchil")) {
                editMessageText.setText("Как по английски пишется слово выучить наизусть?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSeven);
            } else if (data.equals("memoreze")) {
                editMessageText.setText("Who write Jane Eir?");
                updateUser.addBall();
                editMessageReplyMarkup.setReplyMarkup(sendQuestionEight);
            } else if (data.equals("memorize")) {
                editMessageText.setText("Who write Jane Eir?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionEight);
            } else if (data.equals("mimeroze")) {
                editMessageText.setText("Who write Jane Eir?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionEight);
            } else if (data.equals("sharlota Bronte")) {
                editMessageText.setText("When appear the first cinema in UK");
                updateUser.addBall();
                editMessageReplyMarkup.setReplyMarkup(sendQuestionNine);
            } else if (data.equals("charlz Dicens")) {
                editMessageText.setText("When appear the first cinema in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionNine);
            } else if (data.equals("emily Bronte")) {
                editMessageText.setText("When appear the first cinema in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionNine);
            } else if (data.equals("1745")) {
                editMessageText.setText("When was published all the part Lord of The Rings?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTen);
            } else if (data.equals("1896")) {
                updateUser.addBall();
                editMessageText.setText("When was published all the part Lord of The Rings?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTen);
            } else if (data.equals("1930")) {
                editMessageText.setText("When was published all the part Lord of The Rings?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTen);


            } else if (data.equals("1940")) {
                editMessageText.setText(getPercent(updateUser.getCountBallov(), firstName));
            } else if (data.equals("1955")) {
                updateUser.addBall();
                editMessageText.setText(getPercent(updateUser.getCountBallov(), firstName));
            } else if (data.equals("1965")) {
                editMessageText.setText(getPercent(updateUser.getCountBallov(), firstName));
            }


                AnswerCallbackQuery answerCallbackQuery = AnswerCallbackQuery.builder()
                        .callbackQueryId(queryId)
                        .build();

                try {
                    execute(answerCallbackQuery);
                    execute(editMessageText);
                    execute(editMessageReplyMarkup);
                } catch (Exception ex) {
                    ex.getMessage();
                }
            }
        }
        private String getPercent ( int countBallov, String firstName){
            User user = listUsers.get(firstName); //listUsers.get(update.getMessage().getFrom().getFirstName());
            int countQuestions = 10;
            int percent = (countBallov * 100) / countQuestions;
            if(percent >= 100){
                percent =100;
            }
            String response = user.getFirstName() + ", Вы прошли тест и правильно выполнили " + percent + "% заданий!";
            if (percent == 100) {
//            metadata = new MetadataSources(registry)
//                    .getMetadataBuilder().build();
//            sessionFactory = metadata.getSessionFactoryBuilder().build();
//            session = sessionFactory.openSession();
//            transaction = session.beginTransaction();
//            System.out.println("Пользователь \"" + user.getFirstName() + "\" прошёл тест на " + percent + "%.");
//            user.setCountBallov(percent);
//            session.save(user);
//            session.flush();
//            session.clear();
//            transaction.commit();
//            sessionFactory.close();
                listUsersId.add(user.getId());

                return response + ".\nТеперь Вы можете связаться с заказчиком\nпо его нику в телеграмме - @ogarJavaDev";
            }
            System.out.println("Пользователь \"" + user.getFirstName() + "\" прошёл тест на " + percent + "%.");
            return response;
        }

    }