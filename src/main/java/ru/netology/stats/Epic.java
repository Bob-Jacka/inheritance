package ru.netology.stats;

public class Epic extends Task {
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id);
        this.subtasks = subtasks;
    }

    public String[] getSubtasks() {
        return subtasks;
    }

    @Override
    public boolean matches(String query) {
        for (String string : subtasks) {
            if (string.equals(query)) {
                return true;
            }
        }
        return false;
    }
}
