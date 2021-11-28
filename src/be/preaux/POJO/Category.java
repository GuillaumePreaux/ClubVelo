package be.preaux.POJO;

public abstract class Category {
	
	protected int IDCategory;
	protected String Name;
	//RajouterCalendrier
	
	public int getIDCategory() {
		return IDCategory;
	}
	public void setIDCategory(int iDCategory) {
		IDCategory = iDCategory;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public Category() {
		super();
	}
	public Category(int iDCategory, String name) {
		super();
		IDCategory = iDCategory;
		Name = name;
	}
	
	
}
