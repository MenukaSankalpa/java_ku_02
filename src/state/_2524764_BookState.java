package state;

import core._2524764_Book;

public interface _2524764_BookState {

    void borrowBook(_2524764_Book book);
    void returnBook(_2524764_Book book);
    void reserveBook(_2524764_Book book);

    String getStateName();
}
