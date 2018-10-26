/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tareaprogramada2.datos1.register;

/**
 *
 * @author samoy
 */
public class Patients {
	
	private String Name;
	private String Birthdate;
	private String Details;
	private String Type;
	private String Token;
	private int Phone;
	private boolean Doctor;
	private int Priority;
	private static int size=0;
	
	public Patients(String name, String birthdate, String details, String type, String token, int phone, boolean doctor, int priority) {
		Name = name;
		Birthdate = birthdate;
		Details = details;
		Type = type;
		Token = token;
		Phone = phone;
		Doctor = doctor;
		Priority = priority;
		size++;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getBirthdate() {
		return Birthdate;
	}

	public void setBirthdate(String birthdate) {
		Birthdate = birthdate;
	}

	public String getDetails() {
		return Details;
	}

	public void setDetails(String details) {
		Details = details;
	}

	public String getType() {
		return Type;
	}

	public void setType(String type) {
		Type = type;
	}

	public String getToken() {
		return Token;
	}

	public void setToken(String token) {
		Token = token;
	}

	public int getPhone() {
		return Phone;
	}

	public void setPhone(int phone) {
		Phone = phone;
	}

	public boolean isDoctor() {
		return Doctor;
	}

	public void setDoctor(boolean doctor) {
		Doctor = doctor;
	}

	public int getPriority() {
		return Priority;
	}

	public void setPriority(int priority) {
		Priority = priority;
	}

	@Override
	public String toString() {
		return "Patients [Name=" + Name + ", Birthdate=" + Birthdate + ", Details=" + Details + ", Type=" + Type
				+ ", Token=" + Token + ", Phone=" + Phone + ", Doctor=" + Doctor + ", Priority=" + Priority + "]";
	}

	
}

