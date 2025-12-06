package ui;

import command._2524764_BorrowCommand;
import command._2524764_CommandInvoker;
import command._2524764_ReturnCommand;
import core._2524764_Book;
import core._2524764_LibrarySystem;
import core._2524764_User;
import core._2524764_StudentUser;
import core._2524764_FacultyUser;
import core._2524764_GuestUser;
import javafx.collections.FXCollections;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class BorrowReturnView {

    private VBox root;
    private _2524764_LibrarySystem librarySystem;
    private _2524764_CommandInvoker invoker = new _2524764_CommandInvoker();

    public BorrowReturnView(_2524764_LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        initView();
    }

    private void initView() {
        root = new VBox(10);
        root.getStyleClass().add("content-area");

        Label header = new Label("Borrow / Return");
        header.getStyleClass().add("section-title");

        ComboBox<_2524764_User> userCombo = new ComboBox<>();
        userCombo.setItems(FXCollections.observableArrayList(librarySystem.getUsers()));

        ComboBox<_2524764_Book> bookCombo = new ComboBox<>();
        bookCombo.setItems(FXCollections.observableArrayList(librarySystem.getBooks()));

        Button borrowBtn = new Button("Borrow Book");
        Button returnBtn = new Button("Return Book");
        Button undoBtn = new Button("Undo Last Action");

        borrowBtn.getStyleClass().add("primary-button");
        returnBtn.getStyleClass().add("secondary-button");
        undoBtn.getStyleClass().add("danger-button");

        borrowBtn.setOnAction(e -> {
            _2524764_User user = userCombo.getValue();
            _2524764_Book book = bookCombo.getValue();
            if (user != null && book != null) {

                // Determine borrow days using instanceof
                int borrowDays;
                if (user instanceof _2524764_StudentUser) {
                    borrowDays = 14;
                } else if (user instanceof _2524764_FacultyUser) {
                    borrowDays = 30;
                } else if (user instanceof _2524764_GuestUser) {
                    borrowDays = 7;
                } else {
                    borrowDays = 14; // default
                }

                _2524764_BorrowCommand cmd = new _2524764_BorrowCommand(librarySystem, user, book, borrowDays);
                invoker.executeCommand(cmd);
            }
        });

        returnBtn.setOnAction(e -> {
            _2524764_User user = userCombo.getValue();
            _2524764_Book book = bookCombo.getValue();
            if (user != null && book != null) {
                _2524764_ReturnCommand cmd = new _2524764_ReturnCommand(librarySystem, user, book);
                invoker.executeCommand(cmd);
            }
        });

        undoBtn.setOnAction(e -> {
            System.out.println("Undo feature not implemented yet.");
        });

        root.getChildren().addAll(
                header,
                new Label("Select User:"), userCombo,
                new Label("Select Book:"), bookCombo,
                new HBox(10, borrowBtn, returnBtn, undoBtn)
        );
    }

    public VBox getRoot() {
        return root;
    }
}
