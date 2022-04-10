package ru.job4j.tracker;

import java.util.List;

public class DeleteManyAction  implements UserAction {

    private final Output out;

    public DeleteManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Delete items with name";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Delete items with name(test) ===");
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                tracker.delete(item.getId());
            }
            out.println("Заявки с именем: " + name + " удалены.");
        } else {
            out.println("Заявки с именем: " + name + " не найдены.");
        }
        return true;
    }
}

