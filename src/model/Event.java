package model;

public class Event{
	
	private String eventManager;
	private double value;
	private String description;
	private EventType type;
	
	//Relations
	
	private String dateEvent;
	
	//Constructor
	
	public Event(EventType type, String dateEvent, String eventManager, double value, String description){
		
		this.eventManager = eventManager;
		this.value = value;
		this.description = description;
		this.dateEvent = dateEvent;

	}
	
	
	//Gets
	
	public String getEventManger(){
		return eventManager;
	}
	
	public EventType getType() {
		return type;
	}

	public double getValue(){
		return value;
	}
	
	public String getDescription(){
		return description;
	}
	
	public String getDateEvent(){
		return dateEvent;
	}
	
	//Sets
	
	public void setEventManager(String pEventManager){
		eventManager = pEventManager;
	}

	public void setType(EventType type) {
		this.type = type;
	}

	public void setValue(int pValue){
		value = pValue;
	}
	
	public void setDescription(String pDescription){
		description = pDescription;
	}
	
	public void setDateEvent(String pDateEvent){
		dateEvent = pDateEvent;
	}

	public String toString() {
		return "\n" +
		"------ Datos de evento -------" +
		"\n- Fecha del evento" + dateEvent + 
		"\n- Descicion: " + description + 
		"\n- Tipo de evento: " + type + 
		"\n- Realizador: " + eventManager+ 
		"\n- Precio: " + value;
	}

	
}