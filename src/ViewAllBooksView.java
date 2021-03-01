import java.util.Scanner;


public class ViewAllBooksView extends ViewMaster {
    private final StringManager systemPrompts = new StringManager();
    private final Scanner userInput = new Scanner(System.in);
    public Librarian theLibrarian;
    private ViewState view;
    private boolean isRunning = true;


    public ViewAllBooksView() {

    }

    public ViewState viewAllBookPrompt(Librarian newLibrarian) throws Exception {
        this.theLibrarian = newLibrarian;
        System.out.println(systemPrompts.getViewBookHeader());
        for (Book item : theLibrarian.getBookList()) {
            System.out.println("[" + item.getId() + "] " + item.getTitle());
        }
        System.out.println(systemPrompts.getViewBookDetails());
        System.out.print(systemPrompts.getWordBook() + " " + systemPrompts.getWordId() + ": ");
        String userSelection = userInput.nextLine();
        return returnBookResult(userSelection);
    }

    /*
     * viewAllBookPrompt helper Function
     */
    public ViewState returnBookResult(String userSelection) throws Exception {
        try {
            if (!(userSelection.isEmpty())) {
                //Validate User Input
                if (theLibrarian.getCardCatalog().get(userSelection) == null) {
                    System.out.println(userSelection + " " + systemPrompts.getIsNotValid());
                    viewAllBookPrompt(this.theLibrarian); //revisit the caller function
                    System.out.println("HERE WE ARE AGAIN");
                }
                super.displayBookInformation(userSelection, theLibrarian);
                userSelection = userInput.nextLine();
                // ASK AGAIN
                if (userSelection.isEmpty()) {
                    return ViewState.MANAGEBOOKS;
                } else {
                    viewAllBookPrompt(this.theLibrarian);
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ViewState.MANAGEBOOKS;
    }
}
