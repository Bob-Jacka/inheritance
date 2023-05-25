package ru.netology.stats;

public class Meeting extends Task {
    protected String title;
    protected String topic;
    protected String project;
    protected String start;


    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    public Meeting(int id, String title, String topic, String project, String start) {
        super(id);
        this.title = title;
        this.topic = topic;
        this.project = project;
        this.start = start;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public boolean matches(String query) {
        if (topic.contains(query)) {
            return true;
        }
        return project.contains(query);
    }
}
