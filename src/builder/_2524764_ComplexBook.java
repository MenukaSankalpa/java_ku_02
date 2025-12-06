package builder;

public class _2524764_ComplexBook {

    private String bookId;
    private String title;
    private String author;
    private String publisher;
    private int year;
    private String category;
    private int pages;
    private String isbn;

    public _2524764_ComplexBook(_2524764_BookBuilder builder) {
        this.bookId = builder.bookId;
        this.title = builder.title;
        this.author = builder.author;
        this.publisher = builder.publisher;
        this.year = builder.year;
        this.category = builder.category;
        this.pages = builder.pages;
        this.isbn = builder.isbn;
    }

    @Override
    public String toString() {
        return "Complex Book: {" +
                "ID='" + bookId + '\'' +
                ", Title='" + title + '\'' +
                ", Author='" + author + '\'' +
                ", Publisher='" + publisher + '\'' +
                ", Year=" + year +
                ", Category='" + category + '\'' +
                ", Pages=" + pages +
                ", ISBN='" + isbn + '\'' +
                '}';
    }

    // Getters (Optional if needed elsewhere)
    public String getBookId() { return bookId; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getPublisher() { return publisher; }
    public int getYear() { return year; }
    public String getCategory() { return category; }
    public int getPages() { return pages; }
    public String getIsbn() { return isbn; }
}
