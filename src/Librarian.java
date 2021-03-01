/*
* The librarian is the interface layer the Library
* Data from the library comes through Librarian.
* In case of multiple libraries: modify this class
* The Librarian could also be modified with API endpoints
*/

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;

public class Librarian{
    private Library theLibrary = new Library();

    public Librarian(String dataSource) throws Exception {
        initializeLibrary(dataSource);
    }

    public void initializeLibrary(String dataSource) throws Exception {
        theLibrary.stockLibrary(dataSource);
    }

    public int getLibrarySize(){
        return theLibrary.getLibrarySize();
    }

    public ArrayList<Book> getBookList(){
        return theLibrary.getBookList();
    }

    public HashMap<String,Book> getCardCatalog(){
        return theLibrary.getCardCatalog();
    }

    public void savelibrary () throws Exception {
        theLibrary.saveLibrary();
    }

    public ArrayList<Book> getKeyWordResults(String keyWordInput){
        ArrayList<Book> keyWordResults = theLibrary.getKeyCatalog().get(keyWordInput.toUpperCase());
        if (keyWordResults != null) {
            return keyWordResults;
        }
        //if no search results: return a 0 length array
        return new ArrayList<Book>();
    }

    public void addBook(Book newBook){
        theLibrary.addBook(newBook);
    }

    public Book getBookByID(String id){
        return theLibrary.getCardCatalog().get(id);
    }



}
