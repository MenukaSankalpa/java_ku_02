package decorator;

import core._2524764_Book;

public class _2524764_RecommendedBook extends _2524764_BookDecorator {

    private String recommendationNote;

    public _2524764_RecommendedBook(_2524764_Book book, String recommendationNote) {
        super(book);
        this.recommendationNote = recommendationNote;
    }

    // Implement abstract method from BookDecorator
    @Override
    public String getDescription() {
        return decoratedBook.getTitle() + " [Recommended: " + recommendationNote + "]";
    }

    // New method specific to recommended books (optional)
    public String getRecommendationNote() {
        return recommendationNote;
    }

    public void setRecommendationNote(String recommendationNote) {
        this.recommendationNote = recommendationNote;
    }

    // Optionally override other methods
    @Override
    public String getTitle() {
        return decoratedBook.getTitle() + " (Recommended)";
    }
}
