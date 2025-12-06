package decorator;

import core._2524764_Book;

public class _2524764_FeaturedBook extends _2524764_BookDecorator {

    private String featureDescription;

    public _2524764_FeaturedBook(_2524764_Book book, String featureDescription) {
        super(book);
        this.featureDescription = featureDescription;
    }

    // Implement abstract method from BookDecorator
    @Override
    public String getDescription() {
        return decoratedBook.getTitle() + " [Featured: " + featureDescription + "]";
    }

    // New method specific to featured books (optional)
    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String featureDescription) {
        this.featureDescription = featureDescription;
    }

    // Optionally override other methods
    @Override
    public String getTitle() {
        return decoratedBook.getTitle() + " (Featured)";
    }
}
