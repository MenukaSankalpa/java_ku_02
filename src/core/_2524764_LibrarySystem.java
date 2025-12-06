package core;

import state._2524764_AvailableState;
import state._2524764_BorrowedState;
import state._2524764_ReservedState;
import strategy._2524764_FineStrategy;

import java.util.*;

public class _2524764_LibrarySystem {

    private List<_2524764_Book> books = new ArrayList<>();
    private Map<String, _2524764_User> users = new HashMap<>();
    private List<_2524764_BorrowRecord> borrowRecords = new LinkedList<>();
    private Queue<_2524764_Reservation> reservations = new LinkedList<>();

    public void addBook(_2524764_Book book) { books.add(book); }
    public void addUser(_2524764_User user) { users.put(user.getUserId(), user); }

    public List<_2524764_Book> getBooks() { return books; }
    public Collection<_2524764_User> getUsers() { return users.values(); }
    public List<_2524764_BorrowRecord> getBorrowRecords() { return borrowRecords; }

    public _2524764_User getUser(String userId) { return users.get(userId); }
    public _2524764_Book getBook(String bookId) {
        for (_2524764_Book b : books) if (b.getBookId().equals(bookId)) return b;
        return null;
    }

    public void borrowBook(_2524764_User user, _2524764_Book book, int borrowDays) {
        if (!(book.getState() instanceof _2524764_AvailableState)) {
            System.out.println("Book not available.");
            return;
        }
        _2524764_BorrowRecord record = new _2524764_BorrowRecord(user, book, borrowDays);
        borrowRecords.add(record);
        book.setState(new _2524764_BorrowedState(book));
        System.out.println("Borrow successful: " + book.getTitle());
    }

    public void returnBook(_2524764_User user, _2524764_Book book, _2524764_FineStrategy fineCalculator) {
        for (_2524764_BorrowRecord record : borrowRecords) {
            if (record.getBook().equals(book) &&
                    record.getUser().equals(user) &&
                    record.getReturnDate() == null) {

                record.setReturnDate(java.time.LocalDate.now());
                double fine = fineCalculator.calculateFine(record);
                System.out.println("Return successful. Fine = LKR " + fine);

                Optional<_2524764_Reservation> next =
                        reservations.stream().filter(r -> r.getBook().equals(book)).findFirst();

                if (next.isPresent()) {
                    _2524764_Reservation reservation = next.get();
                    reservation.getUser().update("Book available: " + book.getTitle());
                    reservations.remove(reservation);
                    book.setState(new _2524764_ReservedState(book));
                } else {
                    book.setState(new _2524764_AvailableState(book));
                }
                return;
            }
        }
        System.out.println("Record not found.");
    }

    public void reserveBook(_2524764_User user, _2524764_Book book) {
        if (book.getState() instanceof _2524764_BorrowedState) {
            _2524764_Reservation res = new _2524764_Reservation(user, book);
            reservations.add(res);
            user.update("You reserved: " + book.getTitle());
            book.setState(new _2524764_ReservedState(book));
        } else {
            System.out.println("Reservation allowed only when book is borrowed.");
        }
    }
}
