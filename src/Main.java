/*
 * The entry-point into the library
 */
public class Main {


    public static <T> void main(String[] args) throws Exception {
        //Set datasource, pass to 1Library
        String dataSource = "BookStoreLibrary.txt";
        Librarian newLibrarian = new Librarian(dataSource);


        //Prompt first-time users with onLoad message
        StringManager systemPrompts = new StringManager();
        System.out.println(systemPrompts.getWordLoaded() + " " + newLibrarian.getLibrarySize() + " " + systemPrompts.getBooksIntoTheLibrary());

        //Set Up View State Controller
        ViewStateController viewStateController = new ViewStateController(newLibrarian);

        //First view

        ViewState view = ViewState.MANAGEBOOKS;
        viewStateController.setView(view);
    }


}
