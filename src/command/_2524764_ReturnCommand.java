package command;

import core._2524764_Book;
import core._2524764_LibrarySystem;
import core._2524764_User;
import strategy._2524764_FineStrategy;

public class _2524764_ReturnCommand implements _2524764_Command {

    private _2524764_LibrarySystem system;
    private _2524764_User user;
    private _2524764_Book book;

    public _2524764_ReturnCommand(_2524764_LibrarySystem system,
                                  _2524764_User user,
                                  _2524764_Book book) {
        this.system = system;
        this.user = user;
        this.book = book;
    }

    @Override
    public void execute() {
        // Use the user's fine strategy; for now you can pass a default strategy
        _2524764_FineStrategy strategy = user.getFineStrategy();
        system.returnBook(user, book, strategy);
    }
}
