package model;

public class Specie{
	
	private String name;
	private String cientificName;
	private String specieType;
	private boolean migratory;
	
	//Constructor
	
	public Specie(String name, String cientificName, String specieType, boolean migratory){
		
		this.name = name;
		this.cientificName = cientificName;
		this.specieType = specieType;
		this.migratory = migratory;
	}
	
	//Gets
	
	public String getName(){
		return name;
	}
	
	public String getCientificName(){
		return cientificName;
	}
	
	public String getSpecieType(){
		return specieType;
	}
	
	public boolean getMigratory(){
		return migratory;
	}
	
	//Sets
	
	public void setName(String pName){
		name = pName;
	}
	
	public void setCientificName(String pCientificName){
		cientificName = pCientificName;
	}
	
	public void setSpecieType(String pSpecieType){
		specieType = pSpecieType;
	}
	
	public void setMigratory(boolean pMigratory){
		migratory = pMigratory;
	}
}