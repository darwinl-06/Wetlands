package model;

public class Specie{
	
	private String name;
	private String cientificName;
	private Type specieType;
	private String migratory;
	private String wetland;
	
	//Constructor
	
	public Specie(String name, String cientificName, Type specieType, String migratory, String wetland){
		
		this.name = name;
		this.cientificName = cientificName;
		this.specieType = specieType;
		this.migratory = migratory;
		this.wetland = wetland;
	}
	
	//Gets
	
	public String getName(){
		return name;
	}
	
	public String getCientificName(){
		return cientificName;
	}
	
	public Type getSpecieType(){
		return specieType;
	}
	
	public String getMigratory(){
		return migratory;
	}
	
	public String getWetland() {
		return wetland;
	}

	//Sets
	
	

	public void setWetland(String wetland) {
		this.wetland = wetland;
	}

	public void setName(String pName){
		name = pName;
	}
	
	public void setCientificName(String pCientificName){
		cientificName = pCientificName;
	}
	
	public void setSpecieType(Type pSpecieType){
		specieType = pSpecieType;
	}
	
	public void setMigratory(String pMigratory){
		migratory = pMigratory;
	}
	

	
	public String toString() {
		return "\n" +
		"------ Datos de la especie -------" +
		"\n- Nombre cienitifico: " + cientificName + 
		"\n- Nombre: " + name + 
		"\n- Migratoria: " + migratory + 
		"\n- Tipo: " + specieType + 
		"\n- Humedal: " + wetland;
	}

	
}