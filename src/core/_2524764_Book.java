package core;

import observer._2524764_Subject;
import observer._2524764_Observer;
import state._2524764_AvailableState;
import state._2524764_BookState;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import java.util.ArrayList;
import java.util.List;

public class _2524764_Book implements _2524764_Subject {

    private StringProperty bookId;
    private StringProperty title;
    private StringProperty author;
    private StringProperty category;

    private _2524764_BookState state;
    private List<_2524764_Observer> observers = new ArrayList<>();

    public _2524764_Book(String bookId, String title, String author, String category) {
        this.bookId = new SimpleStringProperty(bookId);
        this.title = new SimpleStringProperty(title);
        this.author = new SimpleStringProperty(author);
        this.category = new SimpleStringProperty(category);
        this.state = new _2524764_AvailableState(this);
    }

    // JavaFX Properties for TableView
    public StringProperty bookIdProperty() { return bookId; }
    public StringProperty titleProperty() { return title; }
    public StringProperty authorProperty() { return author; }
    public StringProperty categoryProperty() { return category; }

    public String getBookId() { return bookId.get(); }
    public String getTitle() { return title.get(); }
    public String getAuthor() { return author.get(); }
    public String getCategory() { return category.get(); }

    public void setTitle(String title) { this.title.set(title); }
    public void setAuthor(String author) { this.author.set(author); }
    public void setCategory(String category) { this.category.set(category); }

    public _2524764_BookState getState() { return state; }
    public void setState(_2524764_BookState state) { this.state = state; }

    // Observer pattern
    @Override
    public void registerObserver(_2524764_Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(_2524764_Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers(String message) {
        for (_2524764_Observer ob : observers) {
            ob.update(message);
        }
    }

    @Override
    public String toString() {
        return title.get() + " (" + bookId.get() + ")";
    }
}
