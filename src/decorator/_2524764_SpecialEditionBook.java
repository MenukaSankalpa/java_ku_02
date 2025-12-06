package decorator;

import core._2524764_Book;

public class _2524764_SpecialEditionBook extends _2524764_BookDecorator {

    public _2524764_SpecialEditionBook(_2524764_Book book) {
        super(book);
    }

    @Override
    public String getDescription() {
        return decoratedBook.getTitle() + " [Special Edition]";
    }
}
