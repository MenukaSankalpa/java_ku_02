package core;

public class _2524764_Librarian {

    private String librarianId;
    private String name;

    public _2524764_Librarian(String id, String name) {
        this.librarianId = id;
        this.name = name;
    }

    public String getLibrarianId() { return librarianId; }

    public String getName() { return name; }

    @Override
    public String toString() {
        return name + " (" + librarianId + ")";
    }
}
