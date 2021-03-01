import java.util.Scanner;

public class ViewAddBookView {
    private final StringManager systemPrompts = new StringManager();
    private final Scanner userInput = new Scanner(System.in);
    public Librarian theLibrarian;

    public ViewState viewAddBookPrompt(Librarian newLibrarian) throws Exception {
        this.theLibrarian = newLibrarian;
        System.out.println(systemPrompts.getAddBookHeader());
        System.out.println(systemPrompts.getAddBookPrompt());

        Book newBook = new Book();
        System.out.print(systemPrompts.getWordTitle() + ": ");
        String newTitle = userInput.nextLine();
        newBook.setTitle(newTitle);

        System.out.print(systemPrompts.getWordAuthor() + ": ");
        String newAuthor = userInput.nextLine();
        newBook.setAuthor(newAuthor);

        System.out.print(systemPrompts.getWordDescription() + ": ");
        String newDescription = userInput.nextLine();
        newBook.setDescription(newDescription);

        //GENERATE new ID
        int newId = generateNewId();

        newBook.setId(newId);
        theLibrarian.addBook(newBook);
        theLibrarian.savelibrary();
        System.out.println(systemPrompts.getLibrarySaved());
        return ViewState.MANAGEBOOKS;
    }

    public int generateNewId(){
        int id = 0; //default value
        for (int i = 1; i < theLibrarian.getLibrarySize() + 1; i++) {
            id = i;
            if (!(theLibrarian.getCardCatalog().containsKey(Integer.toString(i)))) {

                return i;
            }
        }
        return id;
    }
}
