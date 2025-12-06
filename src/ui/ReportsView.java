package ui;

import core._2524764_LibrarySystem;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.layout.HBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.text.Text;
import reports._2524764_ReportGenerator;

import java.util.List;

public class ReportsView {

    private VBox root;
    private _2524764_LibrarySystem librarySystem;

    public ReportsView(_2524764_LibrarySystem librarySystem) {
        this.librarySystem = librarySystem;
        initView();
    }

    private void initView() {

        root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getStyleClass().add("content-area");

        Label header = new Label("Reports");
        header.getStyleClass().add("section-title");

        root.getChildren().add(header);

        _2524764_ReportGenerator reportGenerator = new _2524764_ReportGenerator(librarySystem);

        // Create UI cards
        VBox mostBorrowedCard = createReportCard(
                "📘 Most Borrowed Books",
                reportGenerator.getMostBorrowedBooksReport()
        );

        VBox overdueCard = createReportCard(
                "⏳ Overdue Books",
                reportGenerator.getOverdueBooksReport()
        );

        VBox activeBorrowersCard = createReportCard(
                "👤 Active Borrowers",
                reportGenerator.getActiveBorrowersReport()
        );

        root.getChildren().addAll(
                mostBorrowedCard,
                overdueCard,
                activeBorrowersCard
        );
    }

    private VBox createReportCard(String title, List<String> contentLines) {
        VBox card = new VBox(8);
        card.getStyleClass().add("card");
        card.setPadding(new Insets(15));

        Label titleLabel = new Label(title);
        titleLabel.getStyleClass().add("section-subtitle");

        VBox contentBox = new VBox(4);
        for (String line : contentLines) {
            Text text = new Text("• " + line);
            text.getStyleClass().add("report-line");
            contentBox.getChildren().add(text);
        }

        card.getChildren().addAll(titleLabel, contentBox);
        return card;
    }

    public VBox getRoot() {
        return root;
    }
}
