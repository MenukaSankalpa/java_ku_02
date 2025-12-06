package reports;

import core._2524764_Book;
import core._2524764_BorrowRecord;
import core._2524764_LibrarySystem;
import core._2524764_User;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.stream.Collectors;

public class _2524764_ReportGenerator {

    private final _2524764_LibrarySystem system;

    public _2524764_ReportGenerator(_2524764_LibrarySystem system) {
        this.system = system;
    }

    // ------------------------------------------------------------
    // Most Borrowed Books (UI Friendly)
    // ------------------------------------------------------------
    public List<String> getMostBorrowedBooksReport() {

        Map<String, Integer> borrowCount = new HashMap<>();

        for (_2524764_BorrowRecord record : system.getBorrowRecords()) {
            String bookId = record.getBook().getBookId();
            borrowCount.put(bookId, borrowCount.getOrDefault(bookId, 0) + 1);
        }

        return borrowCount.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(entry -> {
                    _2524764_Book book = system.getBook(entry.getKey());
                    return book.getTitle() + " — " + entry.getValue() + " times";
                })
                .collect(Collectors.toList());
    }

    // ------------------------------------------------------------
    // Overdue Books (UI Friendly)
    // ------------------------------------------------------------
    public List<String> getOverdueBooksReport() {

        List<_2524764_BorrowRecord> overdueList = system.getBorrowRecords()
                .stream()
                .filter(_2524764_BorrowRecord::isOverdue)
                .collect(Collectors.toList());

        List<String> result = new ArrayList<>();

        for (_2524764_BorrowRecord record : overdueList) {
            long daysLate = ChronoUnit.DAYS.between(
                    record.getDueDate(),
                    record.getReturnDate() != null ? record.getReturnDate() : LocalDate.now()
            );

            result.add(
                    record.getBook().getTitle() + " — "
                            + record.getUser().getName() + " (" + daysLate + " days late)"
            );
        }

        return result.isEmpty()
                ? List.of("No overdue books")
                : result;
    }

    // ------------------------------------------------------------
    // Active Borrowers (UI Friendly)
    // ------------------------------------------------------------
    public List<String> getActiveBorrowersReport() {

        Map<String, Integer> count = new HashMap<>();

        for (_2524764_BorrowRecord record : system.getBorrowRecords()) {
            String userId = record.getUser().getUserId();
            count.put(userId, count.getOrDefault(userId, 0) + 1);
        }

        return count.entrySet()
                .stream()
                .sorted((a, b) -> b.getValue() - a.getValue())
                .map(entry -> {
                    _2524764_User user = system.getUser(entry.getKey());
                    return user.getName() + " — " + entry.getValue() + " books";
                })
                .collect(Collectors.toList());
    }
}
