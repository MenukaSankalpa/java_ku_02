package command;

import core._2524764_LibrarySystem;
import core._2524764_User;
import core._2524764_Book;

public class _2524764_ReserveCommand implements _2524764_Command {

    private _2524764_LibrarySystem system;
    private String userId;
    private String bookId;

    public _2524764_ReserveCommand(_2524764_LibrarySystem system, String userId, String bookId) {
        this.system = system;
        this.userId = userId;
        this.bookId = bookId;
    }

    @Override
    public void execute() {
        _2524764_User user = system.getUser(userId);   // fetch user object
        _2524764_Book book = system.getBook(bookId);   // fetch book object
        if (user != null && book != null) {
            system.reserveBook(user, book);
        } else {
            System.out.println("Invalid user or book ID.");
        }
    }
}
