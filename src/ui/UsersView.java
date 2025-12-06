package ui;

import core._2524764_LibrarySystem;
import core._2524764_User;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;

public class UsersView {

    private BorderPane root;
    private TableView<_2524764_User> table;
    private ObservableList<_2524764_User> userData;

    private _2524764_LibrarySystem librarySystem;

    public UsersView(_2524764_LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        initView();
    }

    private void initView() {
        root = new BorderPane();
        root.setPadding(new Insets(10));

        Label header = new Label("User Management");
        header.getStyleClass().add("section-title");
        root.setTop(header);
        BorderPane.setMargin(header, new Insets(0, 0, 10, 0));

        // Table
        table = new TableView<>();

        TableColumn<_2524764_User, String> idCol = new TableColumn<>("User ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("userId")); // uses getUserId()

        TableColumn<_2524764_User, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name")); // uses getName()

        TableColumn<_2524764_User, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("userType")); // uses getUserType()

        table.getColumns().addAll(idCol, nameCol, typeCol);

        userData = FXCollections.observableArrayList(librarySystem.getUsers());
        table.setItems(userData);

        root.setCenter(table);
    }

    public BorderPane getRoot() {
        return root;
    }
}
