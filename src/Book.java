/*
Our Book Data Model
 */

public class Book {
    private int Id;
    private String Title;
    private String Author;
    private String Description;

    public Book() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int bookId) {
        this.Id = bookId;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getAuthor() {
        return Author;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    @Override
    public String toString() {
        return Integer.toString(getId());
    }
}
