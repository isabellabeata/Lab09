package it.polito.tdp.borders.model;

public class Border {
	
	private Country country1;
	private Country country2;
	private int dyad;
	
	
	
	public Border(Country country1, Country country2, int dyad, int year, int conttype) {
		super();
		this.country1 = country1;
		this.country2 = country2;
		this.dyad = dyad;
		this.year = year;
		this.conttype = conttype;
	}
	public Country getCountry1() {
		return country1;
	}
	public void setCountry1(Country country1) {
		this.country1 = country1;
	}
	public Country getCountry2() {
		return country2;
	}
	public void setCountry2(Country country2) {
		this.country2 = country2;
	}
	public int getDyad() {
		return dyad;
	}
	public void setDyad(int dyad) {
		this.dyad = dyad;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public int getConttype() {
		return conttype;
	}
	public void setConttype(int conttype) {
		this.conttype = conttype;
	}
	private int year;
	private int conttype;
	

}
