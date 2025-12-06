package ui;

import core.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

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

        // ----------------------
        // TOP BAR WITH ADD BUTTON
        // ----------------------
        Button addUserBtn = new Button("Add User");
        addUserBtn.getStyleClass().add("primary-button");
        addUserBtn.setOnAction(e -> openAddUserWindow());

        Button historyBtn = new Button("View Borrowed History");
        historyBtn.getStyleClass().add("secondary-button");
        historyBtn.setOnAction(e -> openHistoryWindow());

        HBox topBar = new HBox(10, header, addUserBtn, historyBtn);
        root.setTop(topBar);
        BorderPane.setMargin(topBar, new Insets(0, 0, 10, 0));

        // ----------------------
        // USER TABLE
        // ----------------------
        table = new TableView<>();

        TableColumn<_2524764_User, String> idCol = new TableColumn<>("User ID");
        idCol.setCellValueFactory(new PropertyValueFactory<>("userId"));

        TableColumn<_2524764_User, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<_2524764_User, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(new PropertyValueFactory<>("userType"));

        table.getColumns().addAll(idCol, nameCol, typeCol);

        userData = FXCollections.observableArrayList(librarySystem.getUsers());
        table.setItems(userData);

        root.setCenter(table);
    }

    // =========================
    // ADD USER POPUP WINDOW
    // =========================
    private void openAddUserWindow() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Add New User");

        VBox box = new VBox(10);
        box.setPadding(new Insets(15));

        TextField idField = new TextField();
        idField.setPromptText("User ID");

        TextField nameField = new TextField();
        nameField.setPromptText("User Name");

        ComboBox<String> typeCombo = new ComboBox<>();
        typeCombo.getItems().addAll("Student", "Faculty", "Guest");
        typeCombo.setPromptText("Select User Type");

        Button saveBtn = new Button("Save");
        saveBtn.getStyleClass().add("primary-button");

        saveBtn.setOnAction(e -> {
            String id = idField.getText().trim();
            String name = nameField.getText().trim();
            String type = typeCombo.getValue();

            if (id.isEmpty() || name.isEmpty() || type == null) {
                showAlert("Error", "Please fill all fields.");
                return;
            }

            _2524764_User newUser;
            switch (type) {
                case "Student": newUser = new _2524764_StudentUser(id, name); break;
                case "Faculty": newUser = new _2524764_FacultyUser(id, name); break;
                default:        newUser = new _2524764_GuestUser(id, name); break;
            }

            librarySystem.addUser(newUser);
            userData.add(newUser); // refresh table

            window.close();
        });

        box.getChildren().addAll(
                new Label("Add User"),
                idField,
                nameField,
                typeCombo,
                saveBtn
        );

        Scene scene = new Scene(box, 300, 250);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

    // =========================
    // VIEW BORROW HISTORY
    // =========================
    private void openHistoryWindow() {
        _2524764_User selected = table.getSelectionModel().getSelectedItem();
        if (selected == null) {
            showAlert("Error", "Please select a user.");
            return;
        }

        Stage window = new Stage();
        window.setTitle("Borrow History - " + selected.getName());
        window.initModality(Modality.APPLICATION_MODAL);

        VBox box = new VBox(10);
        box.setPadding(new Insets(15));

        ListView<String> list = new ListView<>();
        list.setPrefHeight(300);

        librarySystem.getBorrowHistory(selected.getUserId())
                .forEach(record -> list.getItems().add(
                        record.getBook().getTitle() +
                                " | Due: " + record.getDueDate() +
                                " | Returned: " + (record.getReturnDate() == null ? "Not yet" : record.getReturnDate())
                ));

        box.getChildren().addAll(new Label("Borrowed Books:"), list);

        Scene scene = new Scene(box, 400, 350);
        scene.getStylesheets().add(getClass().getResource("/styles.css").toExternalForm());
        window.setScene(scene);
        window.show();
    }

    private void showAlert(String title, String msg) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(msg);
        alert.show();
    }

    public BorderPane getRoot() {
        return root;
    }
}
