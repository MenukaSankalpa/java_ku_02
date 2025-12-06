package decorator;

import core._2524764_Book;

// Abstract Decorator
public abstract class _2524764_BookDecorator extends _2524764_Book {

    protected _2524764_Book decoratedBook;

    // Decorator constructor: pass the original book and its properties
    public _2524764_BookDecorator(_2524764_Book book) {
        super(book.getBookId(), book.getTitle(), book.getAuthor(), book.getCategory());
        this.decoratedBook = book;
    }

    // Delegate methods to the decorated book
    @Override
    public String getBookId() { return decoratedBook.getBookId(); }

    @Override
    public String getTitle() { return decoratedBook.getTitle(); }

    @Override
    public String getAuthor() { return decoratedBook.getAuthor(); }

    @Override
    public String getCategory() { return decoratedBook.getCategory(); }

    @Override
    public void setTitle(String title) { decoratedBook.setTitle(title); }

    @Override
    public void setAuthor(String author) { decoratedBook.setAuthor(author); }

    @Override
    public void setCategory(String category) { decoratedBook.setCategory(category); }

    // ✅ Abstract method for subclasses to implement
    public abstract String getDescription();
}
