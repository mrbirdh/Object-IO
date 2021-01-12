package ObjectPractice.Data;

import java.io.Serializable;

public class Human implements Serializable{
	private String name;
	private int age;
	private String phoneNumber;
	
	public Human(String name, int age, String phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.phoneNumber = phoneNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "Human [name=" + name + ", age=" + age + ", phoneNumber=" + phoneNumber + "]";
	}
	
	
}
