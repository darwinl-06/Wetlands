package model;

public class Date{
	
	private int day;
	private int month;
	private int year;
	
	/** 
	 * Constructor of the class
	 * @param day
	 * @param month
	 * @param year
	 */
	
	public Date(int day, int month, int year){
		
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	//Getters
	
	public int getDay(){
		return day;
	}
	
	public int getMonth(){
		return month;
	}
	
	public int getYear(){
		return year;
	}
	
	//Setters
	
	public void setDay(int pDay){
		day = pDay;
	}
	
	public void setMonth(int pMonth){
		month = pMonth;
	}
	
	public void setYear(int pYear){
		year = pYear;
	}

	
	public String toString() {
		return "day=" + day + 
		"\n, month=" + month + 
		"\n, year=" + year;
	}

	
}