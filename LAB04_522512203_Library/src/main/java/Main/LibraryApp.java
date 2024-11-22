package Main;
import Dao.BookDAO;
import Model.Book;

public class LibraryApp {
    public static void main(String[] args) {
        // Create a Book object
        Book book = new Book();
        book.setAuthor("T.K. Sen");
        book.setAvailabilityStatus(true);
        book.setTitle("MyJournal");
        book.setIsbn("523-25525");

        // Create DAO object
        BookDAO bookDAO = new BookDAO();

        // Save the book
        bookDAO.saveBook(book);
        System.out.println("Book Added: " +  book.getTitle());
        
        // Retrieve a book
        Book retrievedBook = bookDAO.getBook(book.getBookID());
        System.out.println("Retrieved Book: " + retrievedBook.getTitle());

        // Update the book
        retrievedBook.setAuthor("T.K. Senavirathna (Updated)");
        bookDAO.updateBook(retrievedBook);
        System.out.println("Book Updated: " +  retrievedBook.getTitle());

        // Delete the book
        bookDAO.deleteBook(retrievedBook.getBookID());
        System.out.println("Book Deleted: " + retrievedBook.getTitle());

        // Close the DAO
        bookDAO.close();
    }
}
