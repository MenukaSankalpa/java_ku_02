package ui;


import core._2524764_LibrarySystem;
import core._2524764_Book;
import core._2524764_StudentUser;
import core._2524764_FacultyUser;
import core._2524764_GuestUser;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ModernUI extends Application {

    private _2524764_LibrarySystem librarySystem;
    private MainDashboardView dashboardView;

    @Override
    public void start(Stage primaryStage) {
        librarySystem = new _2524764_LibrarySystem();

        // Seed demo data
        seedDemoData();

        dashboardView = new MainDashboardView(librarySystem);

        Scene scene = new Scene(dashboardView.getRoot(), 1100, 650);
        scene.getStylesheets().add(
                getClass().getResource("../css/style.css").toExternalForm()
        );

        primaryStage.setTitle("Smart Library Management System - _2524764");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void seedDemoData() {
        // Add some demo books (4 parameters: bookId, title, author, category)
        librarySystem.addBook(new _2524764_Book("B001", "Java Programming", "John Doe", "Programming"));
        librarySystem.addBook(new _2524764_Book("B002", "Data Structures", "Jane Smith", "Computer Science"));
        librarySystem.addBook(new _2524764_Book("B003", "Algorithms", "Robert Martin", "Computer Science"));

        // Add some demo users
        librarySystem.addUser(new _2524764_StudentUser("U001", "Alice"));
        librarySystem.addUser(new _2524764_FacultyUser("U002", "Dr. Bob"));
        librarySystem.addUser(new _2524764_GuestUser("U003", "Charlie"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
