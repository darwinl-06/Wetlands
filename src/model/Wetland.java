package model;

public class Wetland{

	private static final int MAX_SPECIES = 50;
	private static final int MAX_EVENTS = 50;
	
	private int numTerrestrial_Flora;
	private int numAquatic_Flora;
	private int num_Bird;
	private int num_Mammal;
	private int num_Aquatic;
	
	private String name;
	private String ubication;
	private String type;
	private String url;
	private String protectedArea;
	private double km2;
	private int maintance;
	private String zone;

	private Specie [] species;
	private Event [] events;
	
	/** 
	 * Constructor of the class
	 * @param name
	 * @param ubication
	 * @param zone
	 * @param type
	 * @param url
	 * @param protectedArea
	 * @param km2
	 * @param maintenance
	 */
	
	public Wetland(String name, String ubication, String zone, String type, String url, String protectedArea, double km2, int maintance){
		
		this.name = name;
		this.ubication = ubication;
		this.type = type;
		this.url = url;
		this.protectedArea = protectedArea;
		this.km2 = km2;
		this.maintance = maintance;
		this.zone = zone;

		species = new Specie[MAX_SPECIES];
		events = new Event[MAX_EVENTS];
	}
	
	
	/** 
	 * Method to chech if the array species has space
	 * @return boolean
	 */
	public boolean hasSpace(){

		boolean emptyPosition= false;
		for (int i=0; i<MAX_SPECIES && !emptyPosition; i++){

			if(species[i] ==null){
				emptyPosition= true;
			}

		}
		return emptyPosition;
	}

	
	/** 
	 * Method to find the empty position of the array species
	 * @return int
	 */
	public int getEmptyPosition(){
		
		int position= -1;
		boolean emptyposition= false;
		for (int i=0; i<MAX_SPECIES && !emptyposition;i++){
			
			if (species[i]==null){
	    position=i;
		emptyposition= true;
			}
		}
		return position;
	}

	
	/** 
	 * Method to register a new specie
	 * @param name
	 * @param cientificName 
	 * @param migratory
	 * @param specieType 
	 * @param wetlandName 
	 * @param num 
	 * @return String
	 */
	public String regisSpecie( String name, String cientificName, String migratory, Type specieType, String wetlandName, int num) {

		String registration = "";

		switch(num) {
			case 1:
				numTerrestrial_Flora++;
				break;
			case 2:
				numAquatic_Flora++;
				break;
			case 3:
				num_Bird++;
				break;
			case 4:
				num_Mammal++;
				break;
			case 5:
				num_Aquatic++;
				break;

		}

		int emptyPosition = getEmptyPosition();

		if(emptyPosition == -1) { 

			
			registration = "No se pueden registrar mas especies";


		}else { 

			species[emptyPosition]= new Specie(name, cientificName, specieType, migratory, wetlandName);
        	registration = "Se registro exitosamnete la especie";

		}

		return registration;

	}

	
	/** 
	 * Method to calculate the number of flora of a wetland
	 * @return int
	 */
	public int calculateNumFlora() {

		int numFlora = numTerrestrial_Flora+numAquatic_Flora;

		return numFlora;
	}

	
	/** 
	 * Method to calculate the number of fauna of a wetland
	 * @return int
	 */
	public int calculateNumFauna() {

		int numFauna = num_Aquatic+num_Bird+num_Mammal;

		return numFauna;
	}

	
	/** 
	 * Method to check if the array events has space
	 * @return boolean
	 */
	public boolean eventhasSpace(){

		boolean emptyPosition= false;
		for (int i=0; i<MAX_EVENTS && !emptyPosition; i++){

			if(events[i] ==null){
				emptyPosition= true;
			}

		}
		return emptyPosition;
	}

	
	/** 
	 * Mehtod to find the empty space of the array events
	 * @return int
	 */
	public int getEventEmptyPosition(){
		
		int position= -1;
		boolean emptyposition= false;
		for (int i=0; i<MAX_EVENTS && !emptyposition;i++){
			
			if (events[i]==null){
	   			position=i;
				emptyposition= true;
			}
		}
		return position;
	}

	
	/** 
	 * This method is to register a new event
	 * @param type
	 * @param dataEvent
	 * @param eventManager
	 * @param price
	 * @param description
	 * @return String
	 */
	public String regisEvent( EventType type, Date dataEvent, String eventManager, double price, String description) {

		String registration = "";

		int emptyPosition = getEventEmptyPosition();


		if(emptyPosition == -1) { 

			
			registration = "No se pueden registrar mas eventos";


		}else { 

			events[emptyPosition]= new Event(type, dataEvent, eventManager, price, description);
        	registration = "Se registro exitosamente el evento";

		}

		return registration;

	}

	
	/** 
	 * Method to search for the position in the array of a specie by the name 
	 * @param name
	 * @return int
	 */
	public int findSpecie(String name){

		int pos = -1;
		boolean flag= false;
		for(int i=0; i<MAX_SPECIES && !flag; i++){

			if (species[i]!= null && species[i].getName().equals(name)){
				flag= true;
				pos = i;
			}
		}

		return pos;

	}
	
	
	/** 
	 * Method to print the specie found
	 * @param name
	 * @return String
	 */
	public String searchSpecie(String name) {

		String registration = "";

		int pos = findSpecie(name);

		if(pos == -1) { 

			
			registration = "No se encontro la especie";


		}else { 

			System.out.println(species[pos].toString());

		}

		return registration;

	}

	//Getters
	
	public Specie[] getSpecie() {
		return species;
	}

	public String getName(){
		return name;
	}
	
	public String getZone() {
		return zone;
	}

	public int getMaintance() {
		return maintance;
	}

	public String getUbication(){
		return ubication;
	}
	
	public String getType(){
		return type;
	}
	
	public String getUrl(){
		return url;
	}
	
	public String getProtectedArea(){
		return protectedArea;
	}
	
	public double getKm2(){
		return km2;
	}
	
	//Setters
	
	public void setName(String pName){
		name = pName;
	}

	public void setZone(String zone) {
		this.zone = zone;
	}
	
	public void setUbication(String pUbication){
		ubication = pUbication;
	}

	public void setMaintance(int maintance) {
		this.maintance = maintance;
	}
	
	public void setType(String pType){
		type = pType;
	}
	
	public void setUrl(String pUrl){
		url = pUrl;
	}
	
	public void setProtectedArea(String pProtectedArea){
		protectedArea = pProtectedArea;
	}
	
	public void setKm2(double pKm2){
		km2 = pKm2;
	}

	public String toString() {
		return  "\n" +
		"------ Datos de los humedales -------" +
		"\n- Nombre: " + name + 
		"\n- Tipo de proteccion: " + protectedArea + 
		"\n- Publico o privado: " + type + 
		"\n- Ubicacion: " + ubication + 
		"\n- Zona: " + zone +
		"\n- Mantenimientos: " + maintance +
		"\n- Url: " + url + 
		"\n- Kiometros: " + km2;
		
	}

	
	

	
}