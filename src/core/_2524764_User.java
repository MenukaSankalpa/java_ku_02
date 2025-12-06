package core;

import observer._2524764_Observer;
import strategy._2524764_FineStrategy;

public abstract class _2524764_User implements _2524764_Observer {
    protected String userId;
    protected String name;
    protected _2524764_FineStrategy fineStrategy;

    public _2524764_User(String userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getUserId() { return userId; }
    public String getName() { return name; }
    public _2524764_FineStrategy getFineStrategy() { return fineStrategy; }

    public abstract String getUserType();

    @Override
    public void update(String message) {
        System.out.println("Notification for " + name + ": " + message);
    }

    // For JavaFX TableView (optional)
    public javafx.beans.property.StringProperty userIdProperty() {
        return new javafx.beans.property.SimpleStringProperty(userId);
    }
    public javafx.beans.property.StringProperty nameProperty() {
        return new javafx.beans.property.SimpleStringProperty(name);
    }
    public javafx.beans.property.StringProperty typeProperty() {
        return new javafx.beans.property.SimpleStringProperty(getUserType());
    }
}
