package core;

import java.time.LocalDate;

public class _2524764_BorrowRecord {

    private _2524764_User user;
    private _2524764_Book book;
    private LocalDate borrowDate;
    private LocalDate dueDate;
    private LocalDate returnDate;

    public _2524764_BorrowRecord(_2524764_User user, _2524764_Book book, int borrowDays) {
        this.user = user;
        this.book = book;
        this.borrowDate = LocalDate.now();
        this.dueDate = borrowDate.plusDays(borrowDays);
    }

    public _2524764_User getUser() { return user; }
    public _2524764_Book getBook() { return book; }
    public LocalDate getBorrowDate() { return borrowDate; }
    public LocalDate getDueDate() { return dueDate; }
    public LocalDate getReturnDate() { return returnDate; }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isOverdue() {
        return returnDate != null && returnDate.isAfter(dueDate);
    }
}
