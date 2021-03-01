import java.util.Scanner;

public class ViewEditBookView extends ViewMaster {
    private final StringManager systemPrompts = new StringManager();
    private final Scanner userInput = new Scanner(System.in);
    public Librarian theLibrarian;

    public ViewState viewEditBookPrompt(Librarian newLibrarian) throws Exception {
        this.theLibrarian = newLibrarian;
        System.out.println(systemPrompts.getEditBookHeader());
        super.showAllBooks(theLibrarian);
        System.out.print(systemPrompts.getWordBook() + " " + systemPrompts.getWordId() + ": ");
        String userSelection = userInput.nextLine();

        if (!(userSelection.isEmpty())) {
            super.displayBookInformation(userSelection, this.theLibrarian); //show book result
        } else {
            return ViewState.MANAGEBOOKS;
        }

        //Prompt user with book to be changed
        System.out.println(systemPrompts.getEditBookPrompt());
        Book result = theLibrarian.getCardCatalog().get(userSelection);

        //Edit Title
        System.out.print(systemPrompts.getWordTitle() + "[" + result.getTitle() + "]: ");
        String newTitle = userInput.nextLine();
        if (!newTitle.isEmpty()) {
            theLibrarian.getCardCatalog().get(userSelection).setTitle(newTitle);
        }

        //Edit Author
        System.out.print(systemPrompts.getWordAuthor() + "[" + result.getAuthor() + "]: ");
        String newAuthor = userInput.nextLine();
        if (!newAuthor.isEmpty()) {
            theLibrarian.getCardCatalog().get(userSelection).setTitle(newAuthor);
        }

        //Edit Description
        System.out.print(systemPrompts.getWordDescription() + "[" + result.getAuthor() + "]: ");
        String newDescription = userInput.nextLine();
        if (!newDescription.isEmpty()) {
            theLibrarian.getCardCatalog().get(userSelection).setTitle(newTitle);
        }

        //save library
        theLibrarian.savelibrary();
        System.out.println(systemPrompts.getWordBook() + " " + systemPrompts.getWordSaved());
        return ViewState.EDITBOOKS;
    }


}
