package model;

/** 
* This is the controller class of the program
* @author Darwin A. Lenis
*/

public class Controller{

	private static final int MAX_WETLANDS = 80;
	
	private Wetland [] wetlands;
	
	
	/** 
	 * Constructor of the class
	 */

	public Controller() {
		
		wetlands = new Wetland[MAX_WETLANDS];
		
	}		

	
	/** 
	 * This method check if the array wetlands has space
	 * @return boolean
	 */
	public boolean hasSpace(){

		boolean emptyPosition= false;
		for (int i=0; i<MAX_WETLANDS && !emptyPosition; i++){

			if(wetlands[i] ==null){
				emptyPosition= true;
			}

		}
		return emptyPosition;
	}

	
	/** 
	 * This method finds the empty space en return the position
	 * @return int
	 */
	public int getEmptyPosition(){
		
		int position= -1;
		boolean emptyposition= false;
		for (int i=0; i<MAX_WETLANDS && !emptyposition;i++){
			
			if (wetlands[i]==null){
	   			position=i;
				emptyposition= true;
			}
		}
		return position;
	}


	
	/** 
	 * This method adds a new wetland in the array of wetlands and returns a message
	 * @param name 
	 * @param ubication 
	 * @param type 
	 * @param url 
	 * @param protectedArea	
	 * @param km2 
	 * @param maintenance 
	 * @param zone 
	 * @return String
	 */
	public String addWetland( String name, String ubication, String type, String url, String protectedArea, double km2, int maintenance, String zone ) {

		String registration;

		int emptyPosition = getEmptyPosition();

		if(emptyPosition == -1) { 

			
			registration = "No se pueden registrar mas humedales";


		}else { 

			wetlands[emptyPosition]= new Wetland(name, ubication ,zone , type, url, protectedArea, km2, maintenance );
        	registration = "Se registro exitosamente el nuevo humedal";

		}

		
		return registration;

	}


	
	/** 
	 * Method to search a wetland in the array of wetlands
	 * @param wetlandName 
	 * @return int
	 */
	public int findWetland(String wetlandName){

		int pos = -1;
		boolean flag= false;
		for(int i=0; i<MAX_WETLANDS && !flag; i++){

			if (wetlands[i]!= null && wetlands[i].getName().equals(wetlandName)){
				flag= true;
				pos = i;
			} 
		}

		return pos;
	}

	
	/** 
	 * Method to add a Specie to the array of species
	 * @param name 
	 * @param cientificName 
	 * @param migratory 
	 * @param specieOption
	 * @param  wetlandName 
	 * @return String
	 */
	public String addSpecie(String name, String cientificName, String migratory, int specieOption, String wetlandName) {

		String registration = "";

		Type speType = null;
		int num = 0;

		switch(specieOption) {
			case 1:
				speType = Type.TERRESTRIAL_FLORA;
				num = 1;
				break;
			case 2:
				speType = Type.AQUATIC_FLORA;
				num = 2;
				break;
			case 3:
				speType = Type.BIRD;
				num = 3;
				break;
			case 4:
				speType = Type.MAMMAL;
				num = 4;
				break;
			case 5:
				speType = Type.AQUATIC;
				num = 5;
				break;

		}

		int position = findWetland(wetlandName);

		Type specieType = speType;

		if(position == -1) { 

			
			registration = "No se pueden registrar mas especies";


		}else { 

			wetlands[position].regisSpecie(name, cientificName, migratory, specieType, wetlandName, num);
        	registration = "Se registro exitosamente la nueva especie";

		}

		return registration;
	}

	
	/** 
	 * This method assign the type of the event to a variable
	 * @param specieOption
	 * @return EventType
	 */
	public EventType addEventType(int specieOption) {

		EventType eventType = null;

		switch(specieOption) {
			case 1:
				eventType = EventType.MAINTENANCE;
				break;
			case 2:
				eventType = EventType.SCHOOL_VISITS;
				break;
			case 3:
				eventType = EventType.IMPROVEMENT_ACTIVITIES;
				break;
			case 4:
				eventType = EventType.CELEBRATIONS;
				break;

		}

		return eventType;
	}

	
	/** 
	 * This method adds a new event to the array of events
	 * @param typeOption
	 * @param day
	 * @param month
	 * @param year
	 * @param eventManager
	 * @param price
	 * @param description
	 * @param wetlandName
	 * @return String
	 */
	public String addEvent( int typeOption, int day, int month, int year, String eventManager, double price, String description, String wetlandName) {

		String registration = "";

		EventType type = addEventType(typeOption);

		int position = findWetland(wetlandName);

		Date dateEvent = new Date(day, month, year);

		if(position == -1) { 

			
			registration = "No se pueden registrar mas eventos";


		} else { 

			wetlands[position].regisEvent( type, dateEvent, eventManager, price, description);
        	registration = "Se registro exitosamente el evento";

		}

		return registration;
	}

	public void getMaintenance() {
		
		for(int i=0;i<MAX_WETLANDS && wetlands[i] != null;i++) {
			
			System.out.println("------Numero de mantenimientos por humedal--------");
			System.out.println(wetlands[i].getName());
			System.out.println("El numero de mantenimientos es" + wetlands[i].getMaintance());	
			System.out.println("");
			
		}
	
	}

	
	/** 
	 * Method to search for a Specie by the name
	 * @param name
	 */
	public void getSpecie(String name) {

		for(int i=0;i<MAX_WETLANDS;i++) {
			
			if(wetlands[i]!=null) {
				
				System.out.println(wetlands[i].searchSpecie(name));	
			}
		
		}

	}

	/** 
	 * Method to show all the wetlands
	 * @param name
	 */

	public void getWetland() {
		
		for(int i=0;i<MAX_WETLANDS;i++) {
			
			if(wetlands[i]!=null) {			
			
				System.out.println(wetlands[i].toString());	
			}
		}
	
	}
	
	
	/** 
	 * Method to search for the wetland with less flora
	 * @return String
	 */
	public String getFlora() {

		String out = "";

		if(wetlands[0]!=null) {			
			
			int flora = wetlands[0].calculateNumFlora();

			out = "El humedal con menos especies de flora es " + wetlands[0].getName() + " con " + flora + " especies";

			for(int i=1; i< MAX_WETLANDS && wetlands[i] != null; i++) {

				System.out.println("variable flora" + flora);
				System.out.println("calculate flora " + i + +wetlands[i].calculateNumFlora());

				if(wetlands[i].calculateNumFlora() < flora) {

					System.out.println("HOLA");

					flora = wetlands[i].calculateNumFlora();

					out = "El humedal con menos especies de flora es " + wetlands[i].getName() + " con " + flora + " especies";
				} 
	
			}



		}

		return out;
	}

	
	/** 
	 * Method to search for the wetland with more animals
	 * @return String
	 */
	public String getFauna() {

		String out = "";

		if(wetlands[0]!=null) {			
			
			int fauna = wetlands[0].calculateNumFauna();

			out = "El humedal con mas especies de fauna es " + wetlands[0].getName() + " con " + fauna + " especies";

			for(int i=0; i< MAX_WETLANDS && wetlands[i] != null; i++) {

				if(wetlands[i].calculateNumFauna() > fauna) {

					fauna = wetlands[i].calculateNumFauna();

					out = "El humedal con mas especies de fauna es " + wetlands[i].getName() + " con " + fauna + " especies";
				}
	
			}

		}

		return out;
	}


	


}