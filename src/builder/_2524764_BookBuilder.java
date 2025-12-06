package builder;

public class _2524764_BookBuilder {

    String bookId;
    String title;
    String author;

    // Optional values
    String publisher;
    int year;
    String category;
    int pages;
    String isbn;

    public _2524764_BookBuilder(String bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
    }

    public _2524764_BookBuilder setPublisher(String publisher) {
        this.publisher = publisher;
        return this;
    }

    public _2524764_BookBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public _2524764_BookBuilder setCategory(String category) {
        this.category = category;
        return this;
    }

    public _2524764_BookBuilder setPages(int pages) {
        this.pages = pages;
        return this;
    }

    public _2524764_BookBuilder setIsbn(String isbn) {
        this.isbn = isbn;
        return this;
    }

    public _2524764_ComplexBook build() {
        return new _2524764_ComplexBook(this);
    }
}
