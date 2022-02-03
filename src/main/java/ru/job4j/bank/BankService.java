package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<>());
    }

    public void addAccount(String passport, Account account) {
        User current = findByPassport(passport);
        if (current != null && !users.get(current).contains(account)) {
            users.get(current).add(account);
        }
    }

    public User findByPassport(String passport) {
        for (User user: users.keySet()) {
            if (passport.equals(user.getPassport())) {
                return user;
            }
        }
        return null;
    }

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

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account srcAcc = findByRequisite(srcPassport, srcRequisite);
        boolean rsl = srcAcc.getBalance() >= amount;
        if (rsl) {
            Account destAcc = findByRequisite(destPassport, destRequisite);
            srcAcc.setBalance(srcAcc.getBalance() - amount);
            destAcc.setBalance(destAcc.getBalance() + amount);
        }
        return rsl;
    }
}
