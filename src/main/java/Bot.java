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
    public InlineKeyboardButton canada1 = InlineKeyboardButton.builder()
            .text("1838")
            .callbackData("1838")
            .build();
    public InlineKeyboardButton canada2 = InlineKeyboardButton.builder()
            .text("1841")
            .callbackData("1841")
            .build();
    public InlineKeyboardButton canada3 = InlineKeyboardButton.builder()
            .text("1800")
            .callbackData("1800")
            .build();
    private InlineKeyboardMarkup sendQuestionEleven = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(canada1))
            .keyboardRow(List.of(canada2))
            .keyboardRow(List.of(canada3))
            .build();
    public InlineKeyboardButton britishImpire1 = InlineKeyboardButton.builder()
            .text("1000000")
            .callbackData("1000000")
            .build();
    public InlineKeyboardButton britishImpire2 = InlineKeyboardButton.builder()
            .text("1232345567")
            .callbackData("1232345567")
            .build();
    public InlineKeyboardButton britishImpire3 = InlineKeyboardButton.builder()
            .text("31878965")
            .callbackData("31878965")
            .build();
    private InlineKeyboardMarkup sendQuestionTwelve = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(britishImpire1))
            .keyboardRow(List.of(britishImpire2))
            .keyboardRow(List.of(britishImpire3))
            .build();
    public InlineKeyboardButton animation1 = InlineKeyboardButton.builder()
            .text("1901 ")
            .callbackData("1901")
            .build();
    public InlineKeyboardButton animation2 = InlineKeyboardButton.builder()
            .text("1809")
            .callbackData("1809")
            .build();
    public InlineKeyboardButton animation3 = InlineKeyboardButton.builder()
            .text("1934")
            .callbackData("1934_animation3")
            .build();
    private InlineKeyboardMarkup sendQuestionThirteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(animation1))
            .keyboardRow(List.of(animation2))
            .keyboardRow(List.of(animation3))
            .keyboardRow(List.of())
            .build();
    public InlineKeyboardButton egs = InlineKeyboardButton.builder()
            .text("Egs")
            .callbackData("egs")
            .build();
    public InlineKeyboardButton burger = InlineKeyboardButton.builder()
            .text("Hamburger")
            .callbackData("hamburger")
            .build();
    public InlineKeyboardButton tea = InlineKeyboardButton.builder()
            .text("Tea")
            .callbackData("tea")
            .build();
    private InlineKeyboardMarkup sendQuestionFourteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(egs))
            .keyboardRow(List.of(burger))
            .keyboardRow(List.of(tea))
            .build();
    public InlineKeyboardButton nigeria = InlineKeyboardButton.builder()
            .text("1789")
            .callbackData("1789")
            .build();
    public InlineKeyboardButton nigeria2 = InlineKeyboardButton.builder()
            .text("1914")
            .callbackData("1914")
            .build();
    public InlineKeyboardButton nigeria3 = InlineKeyboardButton.builder()
            .text("1920")
            .callbackData("1920")
            .build();
    private InlineKeyboardMarkup sendQuestionFifteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(nigeria))
            .keyboardRow(List.of(nigeria2))
            .keyboardRow(List.of(nigeria3))
            .build();
    public InlineKeyboardButton school1 = InlineKeyboardButton.builder()
            .text("12")
            .callbackData("12")
            .build();
    public InlineKeyboardButton school2 = InlineKeyboardButton.builder()
            .text("20")
            .callbackData("20")
            .build();
    public InlineKeyboardButton school3 = InlineKeyboardButton.builder()
            .text("10")
            .callbackData("10")
            .build();
    private InlineKeyboardMarkup sendQuestionSixteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(school1))
            .keyboardRow(List.of(school2))
            .keyboardRow(List.of(school3))
            .build();
    public InlineKeyboardButton prime = InlineKeyboardButton.builder()
            .text("Prime-minister")
            .callbackData("prime-minister")
            .build();
    public InlineKeyboardButton king = InlineKeyboardButton.builder()
            .text("King")
            .callbackData("king")
            .build();
    public InlineKeyboardButton president = InlineKeyboardButton.builder()
            .text("President")
            .callbackData("president")
            .build();
    private InlineKeyboardMarkup sendQuestionSeventeen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(prime))
            .keyboardRow(List.of(king))
            .keyboardRow(List.of(president))
            .build();
    public InlineKeyboardButton it1 = InlineKeyboardButton.builder()
            .text("£1200-£2345")
            .callbackData("£1200-£2345")
            .build();
    public InlineKeyboardButton it2 = InlineKeyboardButton.builder()
            .text("£23456 - £67890")
            .callbackData("£23456 - £67890")
            .build();
    public InlineKeyboardButton it3 = InlineKeyboardButton.builder()
            .text("£10,000 to £30,000")
            .callbackData("£10,000 to £30,000")
            .build();
    private InlineKeyboardMarkup sendQuestionEighteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(it1))
            .keyboardRow(List.of(it2))
            .keyboardRow(List.of(it3))
            .build();
    public InlineKeyboardButton sport1 = InlineKeyboardButton.builder()
            .text("Football")
            .callbackData("football")
            .build();
    public InlineKeyboardButton sport2 = InlineKeyboardButton.builder()
            .text("Kriket")
            .callbackData("kriket")
            .build();
    public InlineKeyboardButton sport3 = InlineKeyboardButton.builder()
            .text("Tennis")
            .callbackData("tennis")
            .build();
    private InlineKeyboardMarkup sendQuestionNineteen = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(sport1))
            .keyboardRow(List.of(sport2))
            .keyboardRow(List.of(sport3))
            .build();
    public InlineKeyboardButton history1 = InlineKeyboardButton.builder()
            .text("Was blood leader")
            .callbackData("was blood leader")
            .build();
    public InlineKeyboardButton history2 = InlineKeyboardButton.builder()
            .text("He has very much wives")
            .callbackData("he has very much wives")
            .build();
    public InlineKeyboardButton history3 = InlineKeyboardButton.builder()
            .text("On Midsummer's Day in 1509 a 17 year old was crowned king of England.")
            .callbackData("1509")
            .build();
    private InlineKeyboardMarkup sendQuestionTwenty = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(history1))
            .keyboardRow(List.of(history2))
            .keyboardRow(List.of(history3))
            .build();
    public InlineKeyboardButton medicine1 = InlineKeyboardButton.builder()
            .text("£125")
            .callbackData("£125")
            .build();
    public InlineKeyboardButton medicine2 = InlineKeyboardButton.builder()
            .text("£1200")
            .callbackData("£1200")
            .build();
    public InlineKeyboardButton medicine3 = InlineKeyboardButton.builder()
            .text("£1500")
            .callbackData("£1500")
            .build();
    private InlineKeyboardMarkup sendQuestionTwentyOne = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(medicine1))
            .keyboardRow(List.of(medicine2))
            .keyboardRow(List.of(medicine3))
            .build();
    public InlineKeyboardButton profession1 = InlineKeyboardButton.builder()
            .text("Scientist")
            .callbackData("scientist")
            .build();
    public InlineKeyboardButton profession2 = InlineKeyboardButton.builder()
            .text("Doctor")
            .callbackData("doctor")
            .build();
    public InlineKeyboardButton profession3 = InlineKeyboardButton.builder()
            .text("IT")
            .callbackData("iT")
            .build();
    private InlineKeyboardMarkup sendQuestionTwentyTwo = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(profession1))
            .keyboardRow(List.of(profession2))
            .keyboardRow(List.of(profession3))
            .build();
    public InlineKeyboardButton silmarilion1 = InlineKeyboardButton.builder()
            .text("1916")
            .callbackData("1916")
            .build();
    public InlineKeyboardButton silmarilion2 = InlineKeyboardButton.builder()
            .text("1934")
            .callbackData("1934_silmatilion2")
            .build();
    public InlineKeyboardButton silmarilion3 = InlineKeyboardButton.builder()
            .text("1986")
            .callbackData("1986")
            .build();
    private InlineKeyboardMarkup sendQuestionTwentyThree = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(silmarilion1))
            .keyboardRow(List.of(silmarilion2))
            .keyboardRow(List.of(silmarilion3))
            .build();
    public InlineKeyboardButton horrow1 = InlineKeyboardButton.builder()
            .text("Nightmare on Elm Street")
            .callbackData("nightmare")
            .build();
    public InlineKeyboardButton horrow2 = InlineKeyboardButton.builder()
            .text("Scream")
            .callbackData("scream")
            .build();
    public InlineKeyboardButton horrow3 = InlineKeyboardButton.builder()
            .text("Maria Marten")
            .callbackData("maria Marten")
            .build();
    private InlineKeyboardMarkup sendQuestionTwentyFour = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(horrow1))
            .keyboardRow(List.of(horrow2))
            .keyboardRow(List.of(horrow3))
            .build();
    public InlineKeyboardButton buzzkiller = InlineKeyboardButton.builder()
            .text("Душнила")
            .callbackData("душнила")
            .build();
    public InlineKeyboardButton buzzliller2 = InlineKeyboardButton.builder()
            .text("Убийца автобуса")
            .callbackData("убийца автобуса")
            .build();
    public InlineKeyboardButton buzliller3 = InlineKeyboardButton.builder()
            .text("Баз убийца")
            .callbackData("баз убийца")
            .build();
    private InlineKeyboardMarkup sendQuestionTwentyFive = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(buzzkiller))
            .keyboardRow(List.of(buzzliller2))
            .keyboardRow(List.of(buzliller3))
            .build();
    public InlineKeyboardButton fellas1 = InlineKeyboardButton.builder()
            .text("Эльфы")
            .callbackData("эльфы")
            .build();
    public InlineKeyboardButton fellas2 = InlineKeyboardButton.builder()
            .text("Парни")
            .callbackData("парни")
            .build();
    public InlineKeyboardButton fellas3 = InlineKeyboardButton.builder()
            .text("Перья")
            .callbackData("перья")
            .build();
    private InlineKeyboardMarkup sendQuestionTwentySix = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(fellas1))
            .keyboardRow(List.of(fellas2))
            .keyboardRow(List.of(fellas3))
            .build();
    public InlineKeyboardButton impressive1 = InlineKeyboardButton.builder()
            .text("Впечатляющий")
            .callbackData("впечатляющий")
            .build();
    public InlineKeyboardButton impressive2 = InlineKeyboardButton.builder()
            .text("Импресивный")
            .callbackData("импресивный")
            .build();
    public InlineKeyboardButton impressive3 = InlineKeyboardButton.builder()
            .text("Имерсивный")
            .callbackData("имерсивный")
            .build();
    private InlineKeyboardMarkup sendQuestionTwentySeven = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(impressive1))
            .keyboardRow(List.of(impressive2))
            .keyboardRow(List.of(impressive3))
            .build();
    public InlineKeyboardButton augmentation1 = InlineKeyboardButton.builder()
            .text("Аргументация")
            .callbackData("аргументация")
            .build();
    public InlineKeyboardButton augmentation2 = InlineKeyboardButton.builder()
            .text("Аргумент")
            .callbackData("аргумент")
            .build();
    public InlineKeyboardButton augmentation3 = InlineKeyboardButton.builder()
            .text("Увелечение")
            .callbackData("увелечение")
            .build();
    private InlineKeyboardMarkup sendQuestionTwentyEight = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(augmentation1))
            .keyboardRow(List.of(augmentation2))
            .keyboardRow(List.of(augmentation3))
            .build();
    public InlineKeyboardButton differ1 = InlineKeyboardButton.builder()
            .text("Отличаться")
            .callbackData("отличаться")
            .build();
    public InlineKeyboardButton differ2 = InlineKeyboardButton.builder()
            .text("Разный")
            .callbackData("разный")
            .build();
    public InlineKeyboardButton differ3 = InlineKeyboardButton.builder()
            .text("Изменённый")
            .callbackData("изменённый")
            .build();
    private InlineKeyboardMarkup sendQuestionTwentyNine = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(differ1))
            .keyboardRow(List.of(differ2))
            .keyboardRow(List.of(differ3))
            .build();

    public InlineKeyboardButton lever1 = InlineKeyboardButton.builder()
            .text("Уровень")
            .callbackData("уровень")
            .build();
    public InlineKeyboardButton lever2 = InlineKeyboardButton.builder()
            .text("Рычаг")
            .callbackData("рычаг")
            .build();
    public InlineKeyboardButton lever3 = InlineKeyboardButton.builder()
            .text("Экран")
            .callbackData("экран")
            .build();
    private InlineKeyboardMarkup sendQuestionThirty = InlineKeyboardMarkup.builder()
            .keyboardRow(List.of(lever1))
            .keyboardRow(List.of(lever2))
            .keyboardRow(List.of(lever3))
            .build();


    @Override
    public String getBotUsername() {
        return "@english3_27_bot";
    }

    @Override
    public String getBotToken() {
        return "7575819701:AAFwhbqKyN_Ls7guGcDSU5zfzbG7xbDxRoM";
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
            currentUser.setCountBallov(0);
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
                editMessageReplyMarkup.setReplyMarkup(sendQuestionEight);
            } else if (data.equals("memorize")) {
                updateUser.addBall();
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
                editMessageText.setText("When Canada become English colony?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionEleven);
            } else if (data.equals("1955")) {
                updateUser.addBall();
                editMessageText.setText("When Canada become English colony?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionEleven);
            } else if (data.equals("1965")) {
                editMessageText.setText("When Canada become English colony?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionEleven);
            } else if (data.equals("1838")) {
                editMessageText.setText("How much territory kilometers was in British Impire?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwelve);
            } else if (data.equals("1841")) {
                updateUser.addBall();
                editMessageText.setText("How much territory kilometers was in British Impire?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwelve);
            } else if (data.equals("1800")) {
                editMessageText.setText("How much territory kilometers was in British Impire?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwelve);
            } else if (data.equals("1000000")) {
                editMessageText.setText("When appear animation in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionThirteen);
            } else if (data.equals("1232345567")) {
                editMessageText.setText("When appear animation in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionThirteen);
            } else if (data.equals("31878965")) {
                updateUser.addBall();
                editMessageText.setText("When appear animation in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionThirteen);
            } else if (data.equals("1901")) {
                updateUser.addBall();
                editMessageText.setText("Which national food in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFourteen);
            } else if (data.equals("1809")) {
                editMessageText.setText("Which national food in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFourteen);
            } else if (data.equals("1934_animation3")) {
                editMessageText.setText("Which national food in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFourteen);
            } else if (data.equals("egs")) {
                updateUser.addBall();
                editMessageText.setText("When Nigeria become colony?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFifteen);
            } else if (data.equals("hamburger")) {
                editMessageText.setText("When Nigeria become colony?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFifteen);
            } else if (data.equals("tea")) {
                editMessageText.setText("When Nigeria become colony?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionFifteen);
            } else if (data.equals("1789")) {
                editMessageText.setText("How much subjects in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSixteen);
            } else if (data.equals("1914")) {
                updateUser.addBall();
                editMessageText.setText("How much subjects in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSixteen);
            } else if (data.equals("1920")) {
                editMessageText.setText("How much subjects in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSixteen);
            } else if (data.equals("12")) {
                updateUser.addBall();
                editMessageText.setText("Who rules Great Britain?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSeventeen);
            } else if (data.equals("20")) {
                editMessageText.setText("Who rules Great Britain?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSeventeen);
            } else if (data.equals("10")) {
                editMessageText.setText("How much subjects in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionSeventeen);

            } else if (data.equals("prime-minister")) {
                updateUser.addBall();
                editMessageText.setText("How much cost IT in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionEighteen);
            } else if (data.equals("king")) {
                editMessageText.setText("How much cost IT in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionEighteen);
            } else if (data.equals("president")) {
                editMessageText.setText("How much cost IT in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionEighteen);

            } else if (data.equals("£1200-£2345")) {
                editMessageText.setText("Which national sport in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionNineteen);
            } else if (data.equals("£23456 - £67890")) {
                editMessageText.setText("Which national sport in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionNineteen);
            } else if (data.equals("£10,000 to £30,000")) {
                updateUser.addBall();
                editMessageText.setText("Which national sport in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionNineteen);
            } else if (data.equals("football")) {
                editMessageText.setText("Which reform do Genrih 8?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwenty);
            } else if (data.equals("kriket")) {
                updateUser.addBall();
                editMessageText.setText("Which reform do Genrih 8?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwenty);
            } else if (data.equals("tennis")) {
                editMessageText.setText("Which reform do Genrih 8?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwenty);
            } else if (data.equals("was blood leader")) {
                editMessageText.setText("How much cost medicine in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyOne);
            } else if (data.equals("he has very much wives")) {
                editMessageText.setText("How much cost medicine in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyOne);
            } else if (data.equals("1509")) {
                updateUser.addBall();
                editMessageText.setText("How much cost medicine in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyOne);
            } else if (data.equals("£125")) {
                editMessageText.setText("Which profession more popular in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyTwo);
            } else if (data.equals("£1200")) {
                editMessageText.setText("Which profession more popular in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyTwo);
            } else if (data.equals("£1500")) {
                updateUser.addBall();
                editMessageText.setText("Which profession more popular in UK?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyTwo);

            } else if (data.equals("scientist")) {
                editMessageText.setText("When Tolkin begin to write silmarilion?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyThree);
            } else if (data.equals("doctor")) {
                updateUser.addBall();
                editMessageText.setText("When Tolkin begin to write silmarilion?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyThree);
            } else if (data.equals("iT")) {
                editMessageText.setText("When Tolkin begin to write silmarilion?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyThree);
            } else if (data.equals("1916")) {
                updateUser.addBall();
                editMessageText.setText("When was first horrow film?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyFour);
            } else if (data.equals("1934_silmatilion2")) {
                editMessageText.setText("When was first horrow film?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyFour);
            } else if (data.equals("1986")) {
                editMessageText.setText("When was first horrow film?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyFour);

            } else if (data.equals("nightmare")) {
                editMessageText.setText("Как переводится слово buzzkiller?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyFive);
            } else if (data.equals("scream")) {
                editMessageText.setText("Как переводится слово buzzkiller?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyFive);
            } else if (data.equals("maria Marten")) {
                updateUser.addBall();
                editMessageText.setText("Как переводится слово buzzkiller?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyFive);
            } else if (data.equals("душнила")) {
                updateUser.addBall();
                editMessageText.setText("Как переводится слово fellas?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentySix);
            } else if (data.equals("убийца автобуса")) {
                editMessageText.setText("Как переводится слово fellas?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentySix);
            } else if (data.equals("баз убийца")) {
                editMessageText.setText("Как переводится слово fellas?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentySix);
            } else if (data.equals("эльфы")) {
                editMessageText.setText("Как переводится слово impressive?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentySeven);
            } else if (data.equals("парни")) {
                updateUser.addBall();
                editMessageText.setText("Как переводится слово impressive?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentySeven);
            } else if (data.equals("перья")) {
                editMessageText.setText("Как переводится слово impressive?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentySeven);
            } else if (data.equals("впечатляющий")) {
                editMessageText.setText("Как переводится слово augmentation?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyEight);
            } else if (data.equals("импресивный")) {
                updateUser.addBall();
                editMessageText.setText("Как переводится слово augmentation?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyEight);
            } else if (data.equals("имерсивный")) {
                editMessageText.setText("Как переводится слово augmentation?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyEight);
            }

            else if (data.equals("увелечение")) {
                editMessageText.setText("Как переводится слово lever?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyNine);
            } else if (data.equals("аргументация")) {
                updateUser.addBall();
                editMessageText.setText("Как переводится слово lever?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyNine);
            } else if (data.equals("аргумент")) {
                editMessageText.setText("Как переводится слово lever?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionTwentyNine);
            } else if (data.equals("уровень")) {
                updateUser.addBall();
                editMessageText.setText("Как переводится слово differ?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionThirty);
            } else if (data.equals("Как переводится слово lever?")) {
                editMessageText.setText("Как переводится слово differ?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionThirty);
            } else if (data.equals("экран")) {
                editMessageText.setText("Как переводится слово differ?");
                editMessageReplyMarkup.setReplyMarkup(sendQuestionThirty);
            } else if (data.equals("отличаться")) {
                editMessageText.setText(getPercent(updateUser.getCountBallov(), firstName));
            } else if (data.equals("разный")) {
                updateUser.addBall();
                editMessageText.setText(getPercent(updateUser.getCountBallov(), firstName));
            } else if (data.equals("изменённый")) {
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

    private String getPercent(int countBallov, String firstName) {
        User user = listUsers.get(firstName); //listUsers.get(update.getMessage().getFrom().getFirstName());
        int countQuestions = 30;
        int percent = (countBallov * 100) / countQuestions;
        if (percent > 100) {
            percent = 100;
        }
        String response = user.getFirstName() + ", Вы прошли тест и правильно выполнили " + percent + "% заданий!";
//        if (percent == 100) {
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
//            listUsersId.add(user.getId());
//
//            return response + ".\nТеперь Вы можете связаться с заказчиком\nпо его нику в телеграмме - english3_27_bot";
//        } else {
//
//
//            System.out.println("Пользователь \"" + user.getFirstName() + "\" прошёл тест на " + percent + "%.");
//            return response;
//        }
        return response;
    }

}