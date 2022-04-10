package ru.job4j.tracker;

public class CreateManyAction implements UserAction {

    private final Output out;

    public CreateManyAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Add many new Items";
    }

    @Override
    public boolean execute(Input input, Store tracker) {
        out.println("=== Create many new Items(test) ===");
        String name = input.askStr("Enter name: ");
        int count = input.askInt("Enter how many Items you want to create: ");
        for (int i = 0; i < count; i++) {
            Item item = new Item(name);
            tracker.add(item);
        }
        out.println("Добавленo заявок: " + count);
        return true;
    }
}
