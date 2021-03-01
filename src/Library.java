/*
 * Library/Driver holds data models
 */

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.util.ArrayList;
import java.util.HashMap;

public class Library {
    private final ArrayList<Book> bookList = new ArrayList<>();
    private final HashMap<String, Book> cardCatalog = new HashMap<>();
    private final HashMap<String, ArrayList<Book>> keyCatalog = new HashMap<>();
    private String dataSource;
    private Boolean isConnectionOpen;

    public Library() {
    }

    /*
     * Add a new book
     */
    public void addBook(Book newBook) {
        bookList.add(newBook);
        cardCatalog.put(Integer.toString(newBook.getId()), newBook);
        updateKeyCatalog(newBook);
    }

    /*
     * Accepts Data Source
     * Enables Connection
     * Stocks Library from data source
     */
    public void stockLibrary(String dataSource) throws Exception {
        this.dataSource = dataSource;
        this.enableConnection(true);
        this.updateLibrary();
    }

    /*
     * helps stock library from datasource
     */
    public void updateLibrary() throws Exception {
        clearLibrary();
        if (isConnectionOpen) {
            try (Reader reader = new FileReader(this.dataSource)) {
                Gson gson = new Gson();
                Book[] features = gson.fromJson(reader, Book[].class);
                for (Book newBook : features) {
                    bookList.add(newBook); //update the booklist
                    cardCatalog.put(Integer.toString(newBook.getId()), newBook);
                    updateKeyCatalog(newBook);
                }
            } catch (Exception ex) {
                throw new Exception("Connection Open But Cannot Retrieve Data");
            }
        }
    }

    /*
     * Saves the library to the database
     */
    public void saveLibrary() throws Exception {
        Gson gson = new Gson();
        String saveList = gson.toJson(this.getBookList());
        FileWriter file = new FileWriter(this.dataSource);
        file.write(saveList);
        file.close();
        this.enableConnection(false);
    }

    /*
    Sets up a new connection
     */
    public void enableConnection(Boolean enableConnection) throws Exception {
        this.isConnectionOpen = enableConnection;
        if (enableConnection) {
            try {
                DataConnection.getInstance().setDataStream(this.dataSource);
            } catch (Exception ex) {
                throw new Exception("Data Connection Problem", ex);
            }
        } else {
            DataConnection.getInstance().setDataStream(null);
        }
    }

    public void updateKeyCatalog(Book newBook) {
        String[] keyWords = newBook.getDescription().split(" ");
        // if keyword exists, add Book reference to key Catalog
        // else add new keyword to catalog
        for (String kWord : keyWords) {
            if (keyCatalog.containsKey(kWord.toUpperCase())) {
                keyCatalog.get(kWord.toUpperCase()).add(newBook);
            } else {
                ArrayList<Book> newBookList = new ArrayList<Book>();
                newBookList.add(newBook);
                keyCatalog.put(kWord.toUpperCase(), newBookList);
            }
        }
    }

    public void clearLibrary() {
        bookList.clear(); //clear the list of books
        cardCatalog.clear(); //clear the card catalog
        keyCatalog.clear(); //clear keyCatalog
    }

    public HashMap<String, ArrayList<Book>> getKeyCatalog() {
        return this.keyCatalog;
    }

    public ArrayList<Book> getBookList() {
        return bookList;
    }

    public HashMap<String, Book> getCardCatalog() {
        return cardCatalog;
    }

    public int getLibrarySize() {
        return bookList.size();
    }
}