package Dao;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import Model.Animal;
public class AnimalDAO {
	
private SessionFactory factory;

	public AnimalDAO() {
		factory= new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Animal.class).buildSessionFactory();
	}
	
	public void saveAnimal(Animal animal) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.save(animal);
		session.getTransaction().commit();
	}
	public Animal getAnimal(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Animal animal = session.get(Animal.class, id);
		session.getTransaction().commit();
		return animal;
	}
	public void updateAnimal(Animal animal) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		session.update(animal);
		session.getTransaction().commit();
	}
	public void deleteAnimal(int id) {
		Session session = factory.getCurrentSession();
		session.beginTransaction();
		Animal animal = session.get(Animal.class, id);
		session.delete(animal);
		session.getTransaction().commit();
	}
	public void closeDAO() {
		Session session = factory.getCurrentSession();
		session.close();
	}
}
