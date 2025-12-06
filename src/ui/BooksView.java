package ui;

import core._2524764_Book;
import core._2524764_LibrarySystem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.layout.*;

public class BooksView {

    private BorderPane root;
    private TableView<_2524764_Book> table;
    private ObservableList<_2524764_Book> bookData;

    private _2524764_LibrarySystem librarySystem;

    public BooksView(_2524764_LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        initView();
    }

    private void initView() {
        root = new BorderPane();
        root.setPadding(new Insets(10));

        Label header = new Label("Book Management");
        header.getStyleClass().add("section-title");
        root.setTop(header);
        BorderPane.setMargin(header, new Insets(0,0,10,0));

        // Table
        table = new TableView<>();
        TableColumn<_2524764_Book, String> idCol = new TableColumn<>("Book ID");
        idCol.setCellValueFactory(data -> data.getValue().bookIdProperty());

        TableColumn<_2524764_Book, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(data -> data.getValue().titleProperty());

        TableColumn<_2524764_Book, String> authorCol = new TableColumn<>("Author");
        authorCol.setCellValueFactory(data -> data.getValue().authorProperty());

        TableColumn<_2524764_Book, String> categoryCol = new TableColumn<>("Category");
        categoryCol.setCellValueFactory(data -> data.getValue().categoryProperty());

        table.getColumns().addAll(idCol, titleCol, authorCol, categoryCol);

        bookData = FXCollections.observableArrayList(librarySystem.getBooks());
        table.setItems(bookData);

        root.setCenter(table);

        // Form on the right
        VBox form = new VBox(8);
        form.setPadding(new Insets(10));
        form.getStyleClass().add("form-card");

        TextField idField = new TextField();
        idField.setPromptText("Book ID");

        TextField titleField = new TextField();
        titleField.setPromptText("Title");

        TextField authorField = new TextField();
        authorField.setPromptText("Author");

        TextField categoryField = new TextField();
        categoryField.setPromptText("Category");

        Button addBtn = new Button("Add Book");
        Button updateBtn = new Button("Update Selected");
        Button deleteBtn = new Button("Delete Selected");

        addBtn.getStyleClass().add("primary-button");
        updateBtn.getStyleClass().add("secondary-button");
        deleteBtn.getStyleClass().add("danger-button");

        addBtn.setOnAction(e -> {
            _2524764_Book book = new _2524764_Book(
                    idField.getText(),
                    titleField.getText(),
                    authorField.getText(),
                    categoryField.getText()
            );
            librarySystem.addBook(book);
            bookData.setAll(librarySystem.getBooks());
            clearFields(idField, titleField, authorField, categoryField);
        });

        updateBtn.setOnAction(e -> {
            _2524764_Book selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setTitle(titleField.getText());
                selected.setAuthor(authorField.getText());
                selected.setCategory(categoryField.getText());
                table.refresh();
            }
        });

        deleteBtn.setOnAction(e -> {
            _2524764_Book selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                librarySystem.getBooks().remove(selected);
                bookData.setAll(librarySystem.getBooks());
            }
        });

        form.getChildren().addAll(
                new Label("Book Details"),
                idField, titleField, authorField, categoryField,
                addBtn, updateBtn, deleteBtn
        );

        root.setRight(form);
    }

    private void clearFields(TextField... fields) {
        for (TextField f : fields) f.clear();
    }

    public BorderPane getRoot() {
        return root;
    }
}
