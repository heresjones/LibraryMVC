/*
* Manage Books manages the main list view Loop
*
 */

import java.util.Scanner;

public class ViewManageBooksView extends ViewMaster {
    private final StringManager systemPrompts = new StringManager();
    private final Scanner userInput = new Scanner(System.in);
    public Librarian theLibrarian;
    private boolean isRunning = true;
    private ViewState view;


    public ViewState viewManageBooksPrompt(Librarian newLibrarian) throws Exception {
        this.theLibrarian = newLibrarian;
        System.out.println(systemPrompts.getBookManagerListHeader() + "\n"
                + systemPrompts.getViewBooks() + "\n" + systemPrompts.getAddBooks() + "\n"
                + systemPrompts.getEditBooks() + "\n" + systemPrompts.getSearchBooks() + "\n"
                + systemPrompts.getSaveAndExit() + "\n" + systemPrompts.getChooseNumber() + ":\n");

        while (isRunning) {
            String userSelection = userInput.nextLine();
            switch (userSelection) {
                case ("1") :
                    view = ViewState.VIEWALLBOOKS;
                    break;
                case ("2") :
                    view = ViewState.ADDBOOKS;
                    break;
                case ("3") :
                    view = ViewState.EDITBOOKS;
                    break;
                case ("4"):
                    view = ViewState.SEARCHBOOKS;
                    break;
                case ("5"):
                    { theLibrarian.savelibrary();
                    System.out.println(systemPrompts.getLibrarySaved());
                    isRunning = false;
                    System.exit(0);
                }
                default :
                    System.out.println("Your input " + userSelection + " " + systemPrompts.getIsNotValid() + "\n" + systemPrompts.getPleaseChooseCorrectValueInteger() + "\n\n=================");
            }
            return view;
        }
        return view;
    }

    /*
     * Displays all Books in prompt
     *
     */
    public void viewAllBookPrompt() throws Exception {
        System.out.println(systemPrompts.getViewBookHeader());
        for (Book item : theLibrarian.getBookList()) {
            System.out.println("[" + item.getId() + "] " + item.getTitle());
        }
        System.out.println(systemPrompts.getViewBookDetails());
        System.out.print(systemPrompts.getWordBook() + " " + systemPrompts.getWordId() + ": ");
        String userSelection = userInput.nextLine();
        returnBookResult(userSelection);
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
                    viewAllBookPrompt(); //revisit the caller function
                    System.out.println("HERE WE ARE AGAIN");
                }
                super.displayBookInformation(userSelection, theLibrarian);
                userSelection = userInput.nextLine();
                // ASK AGAIN
                if (userSelection.isEmpty()) {
                    return ViewState.MANAGEBOOKS;
                } else {
                    viewAllBookPrompt();
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return ViewState.MANAGEBOOKS;
    }


}
