package hust.soict.globalict.aims;

public class DigitalVideoDisc {
	private String title;
	private String category;
	private String director;
	private int lenghth;
	private float cost;
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public int getLenghth() {
		return lenghth;
	}
	public void setLenghth(int lenghth) {
		this.lenghth = lenghth;
	}
	public float getCost() {
		return cost;
	}
	public void setCost(float cost) {
		this.cost = cost;
	}
	public DigitalVideoDisc(String title) {
	    this.title = title;
	}
	public DigitalVideoDisc(String category, String title, float cost) {
	    this.category = category;
	    this.title = title;
	    this.cost = cost;
	}
	public DigitalVideoDisc(String director, String category, String title, float cost) {
	    this.director = director;
	    this.category = category;
	    this.title = title;
	    this.cost = cost;
	}
	public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
	    this.title = title;
	    this.category = category;
	    this.director = director;
	    this.lenghth = length;
	    this.cost = cost;
	}




}
