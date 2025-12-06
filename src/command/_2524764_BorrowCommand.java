package command;

import core._2524764_Book;
import core._2524764_LibrarySystem;
import core._2524764_User;

public class _2524764_BorrowCommand implements _2524764_Command {

    private _2524764_LibrarySystem system;
    private _2524764_User user;
    private _2524764_Book book;
    private int borrowDays;

    public _2524764_BorrowCommand(_2524764_LibrarySystem system,
                                  _2524764_User user,
                                  _2524764_Book book,
                                  int borrowDays) {
        this.system = system;
        this.user = user;
        this.book = book;
        this.borrowDays = borrowDays;
    }

    @Override
    public void execute() {
        system.borrowBook(user, book, borrowDays);
    }
}
