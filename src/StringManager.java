/*
 * Resource library of strings.
 */

import java.io.FileNotFoundException;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class StringManager {
    private String bookManagerListHeader;
    private String viewBooks;
    private String addBooks;
    private String editBooks;
    private String searchBooks;
    private String saveAndExit;
    private String chooseNumber;
    private String wordLoaded;
    private String booksIntoTheLibrary;
    private String searchHeader;
    private String searchPrompt;
    private String wordSearch;
    private String searchResultsPrompt;
    private String wordId;
    private String wordTitle;
    private String wordAuthor;
    private String wordDescription;
    private String editBookHeader;
    private String editBookPrompt;
    private String editBookInputPrompt;
    private String editBookSaved;
    private String addBookHeader;
    private String addBookPrompt;
    private String wordBook;
    private String wordSaved;
    private String viewBookHeader;
    private String viewBookDetails;
    private String librarySaved;
    private String isNotValid;
    private String pleaseChooseAgain;
    private String pleaseChooseCorrectValueInteger;
    private String wordEnter;
    private String searchNoResults;

    public StringManager() {
        loadProperties();
    }

    private void loadProperties() {
        Properties resourceFile = new Properties();
        try {
            String resourceName = "stringResources.properties";
            InputStream resourceStream = getClass().getClassLoader().getResourceAsStream(resourceName);
            resourceFile.load(resourceStream);
            setBookManagerListHeader(resourceFile.getProperty("managerHeader"));
            setViewBooks(resourceFile.getProperty("managerViewBooks"));
            setAddBooks(resourceFile.getProperty("managerAddBooks"));
            setEditBooks(resourceFile.getProperty("managerEditBooks"));
            setSearchBooks(resourceFile.getProperty("managerSearchBooks"));
            setSaveAndExit(resourceFile.getProperty("managerSaveAndExit"));
            setChooseNumber(resourceFile.getProperty("managerChooseNumber"));
            setWordLoaded(resourceFile.getProperty("wordLoaded"));
            setBooksIntoTheLibrary(resourceFile.getProperty("booksIntoTheLibrary"));
            setSearchHeader(resourceFile.getProperty("searchHeader"));
            setSearchPrompt(resourceFile.getProperty("searchPrompt"));
            setWordSearch(resourceFile.getProperty("wordSearch"));
            setSearchResultsPrompt(resourceFile.getProperty("searchResultsPrompt"));
            setWordId(resourceFile.getProperty("wordId"));
            setWordTitle(resourceFile.getProperty("wordTitle"));
            setWordAuthor(resourceFile.getProperty("wordAuthor"));
            setWordDescription(resourceFile.getProperty("wordDescription"));
            setEditBookHeader(resourceFile.getProperty("editBookHeader"));
            setEditBookPrompt(resourceFile.getProperty("editBookPrompt"));
            setEditBookInputPrompt(resourceFile.getProperty("editBookInputPrompt"));
            setEditBookSaved(resourceFile.getProperty("editBookSaved"));
            setAddBookHeader(resourceFile.getProperty("addBookHeader"));
            setAddBookPrompt(resourceFile.getProperty("addBookPrompt"));
            setWordBook(resourceFile.getProperty("wordBook"));
            setWordSaved(resourceFile.getProperty("wordSaved"));
            setViewBookHeader(resourceFile.getProperty("viewBookHeader"));
            setViewBookDetails(resourceFile.getProperty("viewBookDetails"));
            setLibrarySaved(resourceFile.getProperty("librarySaved"));
            setIsNotValid(resourceFile.getProperty("isNotValid"));
            setPleaseChooseAgain(resourceFile.getProperty("pleaseChooseAgain"));
            setPleaseChooseCorrectValueInteger(resourceFile.getProperty("pleaseChooseCorrectValueInteger"));
            setWordEnter(resourceFile.getProperty("wordEnter"));
            setSearchNoResults(resourceFile.getProperty("searchNoResults"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getBookManagerListHeader() {
        return bookManagerListHeader;
    }

    private void setBookManagerListHeader(String bookManagerListHeader) {
        this.bookManagerListHeader = bookManagerListHeader;
    }

    public String getViewBooks() {
        return viewBooks;
    }

    private void setViewBooks(String viewBooks) {
        this.viewBooks = viewBooks;
    }

    public String getAddBooks() {
        return addBooks;
    }

    private void setAddBooks(String addBooks) {
        this.addBooks = addBooks;
    }

    public String getEditBooks() {
        return editBooks;
    }

    private void setEditBooks(String editBooks) {
        this.editBooks = editBooks;
    }

    public String getSearchBooks() {
        return searchBooks;
    }

    private void setSearchBooks(String searchBooks) {
        this.searchBooks = searchBooks;
    }

    public String getSaveAndExit() {
        return saveAndExit;
    }

    private void setSaveAndExit(String saveAndExit) {
        this.saveAndExit = saveAndExit;
    }

    public String getChooseNumber() {
        return chooseNumber;
    }

    private void setChooseNumber(String chooseNumber) {
        this.chooseNumber = chooseNumber;
    }

    public String getWordLoaded() {
        return wordLoaded;
    }

    private void setWordLoaded(String wordLoaded) {
        this.wordLoaded = wordLoaded;
    }

    public String getBooksIntoTheLibrary() {
        return booksIntoTheLibrary;
    }

    private void setBooksIntoTheLibrary(String booksIntoTheLibrary) {
        this.booksIntoTheLibrary = booksIntoTheLibrary;
    }

    public String getSearchHeader() {
        return searchHeader;
    }

    private void setSearchHeader(String searchHeader) {
        this.searchHeader = searchHeader;
    }

    public String getSearchPrompt() {
        return searchPrompt;
    }

    private void setSearchPrompt(String searchPrompt) {
        this.searchPrompt = searchPrompt;
    }

    public String getWordSearch() {
        return wordSearch;
    }

    private void setWordSearch(String wordSearch) {
        this.wordSearch = wordSearch;
    }

    public String getSearchResultsPrompt() {
        return searchResultsPrompt;
    }

    private void setSearchResultsPrompt(String searchResultsPrompt) {
        this.searchResultsPrompt = searchResultsPrompt;
    }

    public String getWordId() {
        return wordId;
    }

    private void setWordId(String wordId) {
        this.wordId = wordId;
    }

    public String getWordTitle() {
        return wordTitle;
    }

    private void setWordTitle(String wordTitle) {
        this.wordTitle = wordTitle;
    }

    public String getWordAuthor() {
        return wordAuthor;
    }

    private void setWordAuthor(String wordAuthor) {
        this.wordAuthor = wordAuthor;
    }

    public String getWordDescription() {
        return wordDescription;
    }

    private void setWordDescription(String wordDescription) {
        this.wordDescription = wordDescription;
    }

    public String getEditBookHeader() {
        return editBookHeader;
    }

    private void setEditBookHeader(String editBookHeader) {
        this.editBookHeader = editBookHeader;
    }

    public String getEditBookPrompt() {
        return editBookPrompt;
    }

    private void setEditBookPrompt(String editBookprompt) {
        this.editBookPrompt = editBookprompt;
    }

    public String getEditBookInputPrompt() {
        return editBookInputPrompt;
    }

    private void setEditBookInputPrompt(String editBookInputPrompt) {
        this.editBookInputPrompt = editBookInputPrompt;
    }

    public String getEditBookSaved() {
        return editBookSaved;
    }

    private void setEditBookSaved(String editBookSaved) {
        this.editBookSaved = editBookSaved;
    }

    public String getAddBookHeader() {
        return addBookHeader;
    }

    private void setAddBookHeader(String addBookHeader) {
        this.addBookHeader = addBookHeader;
    }

    public String getAddBookPrompt() {
        return addBookPrompt;
    }

    private void setAddBookPrompt(String addBookPrompt) {
        this.addBookPrompt = addBookPrompt;
    }

    public String getWordBook() {
        return wordBook;
    }

    private void setWordBook(String wordBook) {
        this.wordBook = wordBook;
    }

    public String getWordSaved() {
        return wordSaved;
    }

    private void setWordSaved(String wordSaved) {
        this.wordSaved = wordSaved;
    }

    public String getViewBookHeader() {
        return viewBookHeader;
    }

    private void setViewBookHeader(String viewBookHeader) {
        this.viewBookHeader = viewBookHeader;
    }

    public String getViewBookDetails() {
        return viewBookDetails;
    }

    private void setViewBookDetails(String viewBookDetails) {
        this.viewBookDetails = viewBookDetails;
    }

    public String getLibrarySaved() {
        return librarySaved;
    }

    private void setLibrarySaved(String librarySaved) {
        this.librarySaved = librarySaved;
    }

    public String getIsNotValid() {
        return isNotValid;
    }

    private void setIsNotValid(String isNotValid) {
        this.isNotValid = isNotValid;
    }

    public String getPleaseChooseAgain() {
        return pleaseChooseAgain;
    }

    private void setPleaseChooseAgain(String pleaseChooseAgain) {
        this.pleaseChooseAgain = pleaseChooseAgain;
    }

    public String getPleaseChooseCorrectValueInteger() {
        return pleaseChooseCorrectValueInteger;
    }

    private void setPleaseChooseCorrectValueInteger(String PleaseChooseCorrectValueInteger) {
        this.pleaseChooseCorrectValueInteger = PleaseChooseCorrectValueInteger;
    }

    public String getWordEnter() {
        return wordEnter;
    }

    private void setWordEnter(String wordEnter) {
        this.wordEnter = wordEnter;
    }

    private void setSearchNoResults(String searchNoResults) {
        this.searchNoResults = searchNoResults;
    }

    public String getSearchNoResults() {
        return searchNoResults;
    }
}
