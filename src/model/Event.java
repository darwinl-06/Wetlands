package model;

public class Event{
	
	private String eventManager;
	private int value;
	private String description;
	
	//Relations
	
	private Date dateEvent;
	
	//Constructor
	
	public Event(String eventManager, int value, String description, Date dateEvent){
		
		this.eventManager = eventManager;
		this.value = value;
		this.description = description;
		this.dateEvent = dateEvent;

	}
	
	
	//Gets
	
	public String getEventManger(){
		return eventManager;
	}
	
	public int getValue(){
		return value;
	}
	
	public String getDescription(){
		return description;
	}
	
	public Date getDateEvent(){
		return dateEvent;
	}
	
	//Sets
	
	public void setEventManager(String pEventManager){
		eventManager = pEventManager;
	}
	
	public void setValue(int pValue){
		value = pValue;
	}
	
	public void setDescription(String pDescription){
		description = pDescription;
	}
	
	public void setDateEvent(Date pDateEvent){
		dateEvent = pDateEvent;
	}
}