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
public class Patient {
	
	private String Name;
	private String Birthdate;
	private String Details;
	private String Type;
	private String Token;
	private int Phone;
	private boolean Doctor;
        private int Tab;
	private int Priority;

    public Patient(String Name, String Birthdate, String Details, String Type, String Token, int Phone, boolean Doctor, int Tab, int Priority) {
        this.Name = Name;
        this.Birthdate = Birthdate;
        this.Details = Details;
        this.Type = Type;
        this.Token = Token;
        this.Phone = Phone;
        this.Doctor = Doctor;
        this.Tab = Tab;
        this.Priority = Priority;
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

    public int getTab() {
        return Tab;
    }

    public void setTab(int Tab) {
        this.Tab = Tab;
    }

    @Override
    public String toString() {
        return "Patient{" + "Name=" + Name + ", Birthdate=" + Birthdate + ", Details=" + Details + ", Type=" + Type + ", Token=" + Token + ", Phone=" + Phone + ", Doctor=" + Doctor + ", Tab=" + Tab + ", Priority=" + Priority + '}';
    }	
}