package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс, выполняющий работу со счетами и пользователями. Основан на классах User и Account
 * @author  Камышенцев Василий
 * @version 1.0
 */
public class BankService {
    /**
     * Храниние данных осуществляется в коллекции типа HashMap, где ключами
     * являются объекты User, а значениями Account.
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод добавляет нового пользователя в коллецию, предварительно проверив, что такого пользователя
     * еще в коллекции нет. Этому пользователю соотносим пустую коллекцию аккаунтов (объект Account)
     * @param user объект пользователя
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    /**
     * Метод ищет по номеру паспорта пользователя в нашей коллекции, и если находит, добавляет
     * ему новый счет
     * @param passport номер паспорта
     * @param account объект счета
     */
    public void addAccount(String passport, Account account) {
        User current = findByPassport(passport);
        if (current != null && !users.get(current).contains(account)) {
            users.get(current).add(account);
        }
    }

    /**
     * Метод ищет пользователя по номеру паспорта. Если такого пользователя не нашлось,
     * возвращается null
     * @param passport номер паспорта
     * @return объект пользователя или null
     */
    public User findByPassport(String passport) {
        for (User user: users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет по номеру. Если не нашлось пользователя с таким счетом или нет такого
     * счета, то возвращается null.
     * @param passport номер паспорта
     * @param requisite номер счета
     * @return объект счета Account или null
     */
    public Account findByRequisite(String passport, String requisite) {
        User current = findByPassport(passport);
        if (current != null) {
            for (Account acc : users.get(current)) {
                if (requisite.equals(acc.getRequisite())) {
                    return acc;
                }
            }
        }
        return null;
    }

    /**
     * Метод осуществляет перевод средств с одного счета на другой. Предварительно проводится
     * проверка, что оба счета существуют в нашей базе и что у отправителя достаточно средств
     * для данного перевода. Возвращает true/false в зависимости от того, проведен ли перевод
     * @param srcPassport номер паспорта отправителя
     * @param srcRequisite номер счета отправителя
     * @param destPassport номер паспорта получателя
     * @param destRequisite номер счета получателя
     * @param amount количество переводимых средств
     * @return true/false в зависимости от успешности операции
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        Account destAcc = findByRequisite(destPassport, destRequisite);
        boolean rsl = srcAcc != null && destAcc != null && srcAcc.getBalance() >= amount;
        if (rsl) {
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
        }
        return rsl;
    }
}
