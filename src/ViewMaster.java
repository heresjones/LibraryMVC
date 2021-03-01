/*
A helper parent class for views
 */

public class ViewMaster {
    private final StringManager systemPrompts = new StringManager();

    void showAllBooks(Librarian theLibrarian) {
        for (Book item : theLibrarian.getBookList()) {
            System.out.println("[" + item.getId() + "] " + item.getTitle());
        }
    }

    void displayBookInformation(String userBookSelection, Librarian theLibrarian) {
        Book result = theLibrarian.getCardCatalog().get(userBookSelection);
        System.out.println(systemPrompts.getWordId() + ": " + result.getId());
        System.out.println(systemPrompts.getWordTitle() + ": " + result.getTitle());
        System.out.println(systemPrompts.getWordAuthor() + ": " + result.getAuthor());
        System.out.println(systemPrompts.getWordDescription() + ": " + result.getDescription());

    }
}
