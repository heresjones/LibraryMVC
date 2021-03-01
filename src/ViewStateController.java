/*
 * ViewStateController Controls which views are presented to user
 */


public class ViewStateController extends ViewMaster {
    public Librarian theLibrarian;
    ViewAllBooksView viewAllBooksView = new ViewAllBooksView();
    ViewAddBookView viewAddBookView = new ViewAddBookView();
    ViewEditBookView viewEditBookView = new ViewEditBookView();
    ViewSearchBooksView viewSearchBooksView = new ViewSearchBooksView();
    ViewManageBooksView viewManageBooksView = new ViewManageBooksView();



    public ViewStateController(Librarian newLibrarian) throws Exception {
        theLibrarian = newLibrarian;
        theLibrarian.savelibrary();
    }

    /*
     * setView will go through the View Loop
     *
     */
    public void setView(ViewState view) throws Exception {
        switch (view) {
            case MANAGEBOOKS:
                this.setView(viewManageBooksView.viewManageBooksPrompt(this.theLibrarian));
                break;
            case VIEWALLBOOKS:
                this.setView(viewAllBooksView.viewAllBookPrompt(this.theLibrarian));
                break;
            case ADDBOOKS:
                this.setView(viewAddBookView.viewAddBookPrompt(this.theLibrarian));
                break;
            case EDITBOOKS:
                this.setView(viewEditBookView.viewEditBookPrompt(this.theLibrarian));
                break;
            case SEARCHBOOKS:
                this.setView(viewSearchBooksView.viewSearchBooksPrompt(this.theLibrarian));
        }
    }
}
