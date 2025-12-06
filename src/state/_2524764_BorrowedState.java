package state;

import core._2524764_Book;

public class _2524764_BorrowedState implements _2524764_BookState {

    private _2524764_Book book;

    public _2524764_BorrowedState(_2524764_Book book) {
        this.book = book;
    }

    @Override
    public void borrowBook(_2524764_Book book) {
        System.out.println("Cannot borrow. Book is already borrowed.");
    }

    @Override
    public void returnBook(_2524764_Book book) {
        book.setState(new _2524764_AvailableState(book));
        System.out.println("Book returned: " + book.getTitle());
    }

    @Override
    public void reserveBook(_2524764_Book book) {
        book.setState(new _2524764_ReservedState(book));
        System.out.println("Book reserved successfully: " + book.getTitle());
    }

    @Override
    public String getStateName() {
        return "Borrowed";
    }
}
