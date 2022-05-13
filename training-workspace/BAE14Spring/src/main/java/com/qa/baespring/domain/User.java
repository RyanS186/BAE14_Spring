package com.qa.baespring.domain;

//Importing necessary packages
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class User {
	
	@Id // This sets the column as the Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // This makes the column auto-increment
	private long id;
	/* The meaning of Encapsulation, is to make sure that "sensitive" data is hidden from users. To achieve this, you must:

    - declare class variables/attributes as private
    - provide public get and set methods to access and update the value of a private variable */
	
	// Declaring variables as private
	
	// Creates a column called "first_name" by default. 
	// We can use the @Column(name) tag to set custom table names
	// @Column(name = "firstname") 
	// This column can NOT be null due to the @Column(nullable) tag.
	@Column(nullable = false)	
	private String firstName;
	
	// Creates a column called "last_name"
	@Column(nullable = false)
	private String lastName;
	
	// Creates a column called "age"
	@Column(nullable = false)
	private int age;
	
	// Creates a column called "username".
	@Column(unique = true, nullable = false)
	private String username;
	
	// Creates a column called "email_address"
	@Column(unique = true, nullable = false)
	private String emailAddress;
	
	
	// Default constructor
	public User() {}
	
	// Source -> Generate Constructor using fields
	
	// Used for creating/inserting
	public User(String firstName, String lastName, int age, String username, String emailAddress) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.username = username;
		this.emailAddress = emailAddress;
	}
	
	// Used for reading/selecting (and testing)
	public User(long id, String firstName, String lastName, int age, String username, String emailAddress) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.username = username;
		this.emailAddress = emailAddress;
	}

	// Source -> Generate getters and setters
	
	// Providing public get and set methods to access and update the value of the private variables
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmailAddress() {
		return emailAddress;
	}
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age + ", username=" + username + ", emailAddress=" + emailAddress + "]";
	}

	// Source -> Generate hashCode() and equals()
	
	// The equals method allows us to compare objects much more intelligently.
	// If we were to compare Object1 and Object2 using == notation, it would only return true if they were the same object in memory.
	// By using equals() we can define the values we want to compare and return true if they match.

	@Override
	public int hashCode() {
		return Objects.hash(age, emailAddress, firstName, id, lastName, username);
	}

	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		return age == other.age && Objects.equals(emailAddress, other.emailAddress) && Objects.equals(firstName, other.firstName) && id == other.id && Objects.equals(lastName, other.lastName) && Objects.equals(username, other.username);
	}

	
}
