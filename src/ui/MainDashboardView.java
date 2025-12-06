package ui;

import core._2524764_LibrarySystem;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

public class MainDashboardView {

    private BorderPane root;
    private VBox sidebar;
    private StackPane contentArea;

    private _2524764_LibrarySystem librarySystem;

    public MainDashboardView(_2524764_LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        initLayout();
    }

    private void initLayout() {
        root = new BorderPane();

        // Top bar
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(15));
        topBar.setStyle("-fx-background-color: #222831;");
        Label title = new Label("Smart Library Management System");
        title.getStyleClass().add("app-title");
        topBar.getChildren().add(title);
        root.setTop(topBar);

        // Sidebar
        sidebar = new VBox(10);
        sidebar.setPadding(new Insets(15));
        sidebar.setPrefWidth(220);
        sidebar.getStyleClass().add("sidebar");

        Button booksBtn = new Button("Books");
        Button usersBtn = new Button("Users");
        Button borrowReturnBtn = new Button("Borrow / Return");
        Button reportsBtn = new Button("Reports");

        booksBtn.getStyleClass().add("nav-button");
        usersBtn.getStyleClass().add("nav-button");
        borrowReturnBtn.getStyleClass().add("nav-button");
        reportsBtn.getStyleClass().add("nav-button");

        sidebar.getChildren().addAll(booksBtn, usersBtn, borrowReturnBtn, reportsBtn);
        root.setLeft(sidebar);

        // Content area
        contentArea = new StackPane();
        contentArea.setPadding(new Insets(15));
        contentArea.getStyleClass().add("content-area");
        root.setCenter(contentArea);

        // Default view
        showBooksView();

        // Button actions
        booksBtn.setOnAction(e -> showBooksView());
        usersBtn.setOnAction(e -> showUsersView());
        borrowReturnBtn.setOnAction(e -> showBorrowReturnView());
        reportsBtn.setOnAction(e -> showReportsView());
    }

    private void showBooksView() {
        BooksView view = new BooksView(librarySystem);
        contentArea.getChildren().setAll(view.getRoot());
    }

    private void showUsersView() {
        UsersView view = new UsersView(librarySystem);
        contentArea.getChildren().setAll(view.getRoot());
    }

    private void showBorrowReturnView() {
        BorrowReturnView view = new BorrowReturnView(librarySystem);
        contentArea.getChildren().setAll(view.getRoot());
    }

    private void showReportsView() {
        ReportsView view = new ReportsView(librarySystem);
        contentArea.getChildren().setAll(view.getRoot());
    }

    public BorderPane getRoot() {
        return root;
    }
}
