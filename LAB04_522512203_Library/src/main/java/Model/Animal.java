package Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity 
@Table(name="Animal")
public class Animal {
@Id 
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int ID;
private String name;
private int Age;

public int getID() {
	return ID;
}
public void setID(int iD) {
	ID = iD;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getAge() {
	return Age;
}
public void setAge(int age) {
	Age = age;
}

}
