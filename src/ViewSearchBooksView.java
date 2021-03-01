
import java.util.ArrayList;
import java.util.Scanner;

public class ViewSearchBooksView extends ViewMaster {

    private final StringManager systemPrompts = new StringManager();
    private final Scanner userInput = new Scanner(System.in);
    public Librarian theLibrarian;
    private ViewState view;
    private boolean isRunning = true;


    public ViewState viewSearchBooksPrompt(Librarian newLibrarian) throws Exception {
        this.theLibrarian = newLibrarian;
        System.out.println(systemPrompts.getSearchHeader() + "\n"
                + systemPrompts.getSearchPrompt() + "\n" + systemPrompts.getWordSearch() + ": ");
        String userSelection = userInput.nextLine();

        //break if user presses enter
        if (userSelection.isEmpty()) {
            return ViewState.MANAGEBOOKS;
        }

        //validate userstring
        if (isSearchResult(userSelection)) {
            return viewSearchResults(userSelection);
        } else {
            System.out.println(systemPrompts.getSearchNoResults());
            return ViewState.SEARCHBOOKS;
        }
    }

    public ViewState viewSearchResults(String userSelection) throws Exception {
        //PERFORM SEARCH
        ArrayList<Book> searchResults = theLibrarian.getKeyWordResults(userSelection);

        //DISPLAY AND SAVE LIST OF ID's WITH BOOKS
        System.out.println(systemPrompts.getSearchResultsPrompt());
        ArrayList<Integer> idList = new ArrayList<>();
        for (Book result : searchResults) {
            System.out.println("[" + result.getId() + "]" + result.getTitle());
            idList.add(result.getId());
        }

        //ENTER THE LOOP
        System.out.print(systemPrompts.getWordBook() + " " + systemPrompts.getWordId() + ": ");
        String userBookIdSelection = userInput.nextLine();
        boolean isBookIdEnabled = true;
        boolean validInput = true;

        while (isBookIdEnabled) {
            //VALIDATE
            if(!isInteger(userBookIdSelection)){
                System.out.println(userBookIdSelection + " " + systemPrompts.getIsNotValid());
                System.out.println(systemPrompts.getPleaseChooseAgain());
                System.out.print(systemPrompts.getWordBook() + " " + systemPrompts.getWordId() + ": ");
                userBookIdSelection = userInput.nextLine();
            }

            if (!(userBookIdSelection.isEmpty())) {
                if (idList.contains(Integer.valueOf(String.valueOf(userBookIdSelection)))) {
                    super.displayBookInformation(userBookIdSelection, this.theLibrarian); //show book result
                } else {
                    System.out.println(userBookIdSelection + " " + systemPrompts.getIsNotValid());
                    System.out.println(systemPrompts.getPleaseChooseAgain());
                }
            } else {
                isBookIdEnabled = false;
            }
            System.out.print(systemPrompts.getWordBook() + " " + systemPrompts.getWordId() + ": ");
            userBookIdSelection = userInput.nextLine();
        }
        return ViewState.MANAGEBOOKS;
    }

    public boolean isInteger( String input ) {
        try {
            Integer.parseInt( input );
            return true;
        }
        catch( Exception ex) {
            return false;
        }
    }

    private boolean isSearchResult(String userSelection) {
        ArrayList<Book> searchResults = theLibrarian.getKeyWordResults(userSelection);
        if (searchResults.size() >= 1) {
            return true;
        }
        return false;
    }

}
