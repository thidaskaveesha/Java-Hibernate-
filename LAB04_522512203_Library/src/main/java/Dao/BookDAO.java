package Dao;

import Model.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BookDAO {
    private SessionFactory factory;

    public BookDAO() {
        factory = new Configuration().configure("hibernate.cfg.xml")
                .addAnnotatedClass(Book.class).buildSessionFactory();
    }

    public void saveBook(Book book) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.save(book);
        session.getTransaction().commit();
    }

    public Book getBook(int bookId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Book book = session.get(Book.class, bookId);
        session.getTransaction().commit();
        return book;
    }

    public void updateBook(Book book) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        session.update(book);
        session.getTransaction().commit();
    }

    public void deleteBook(int bookId) {
        Session session = factory.getCurrentSession();
        session.beginTransaction();
        Book book = session.get(Book.class, bookId);
        session.delete(book);
        session.getTransaction().commit();
    }

    public void close() {
        factory.close();
    }
}
