package state;

import core._2524764_Book;

public class _2524764_ReservedState implements _2524764_BookState {

    private _2524764_Book book;

    public _2524764_ReservedState(_2524764_Book book) {
        this.book = book;
    }

    @Override
    public void borrowBook(_2524764_Book book) {
        System.out.println("Cannot borrow. Book is reserved.");
    }

    @Override
    public void returnBook(_2524764_Book book) {
        book.setState(new _2524764_AvailableState(book));
        System.out.println("Book returned and available: " + book.getTitle());
    }

    @Override
    public void reserveBook(_2524764_Book book) {
        System.out.println("Book already reserved.");
    }

    @Override
    public String getStateName() {
        return "Reserved";
    }
}
