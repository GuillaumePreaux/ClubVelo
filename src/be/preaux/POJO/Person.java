package be.preaux.POJO;

public abstract class Person {
	protected int IDPerson;
	protected String name;
	protected String surname;
	protected String telephone;
	protected String nickname;
	protected String password;
	
	public Person() {
	}
	
	

	public Person(int IDPerson, String name, String surname, String telephone, String nickname, String password) {
		this.IDPerson = IDPerson;
		this.name = name;
		this.surname = surname;
		this.telephone = telephone;
		this.nickname = nickname;
		this.password = password;
	}



	public int getIDPerson() {
		return IDPerson;
	}



	public void setIDPerson(int iDPerson) {
		IDPerson = iDPerson;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
