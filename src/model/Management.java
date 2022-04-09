package model;

public class Management{
	
	private int maintance;
	private int restauration;
	private int conservation;
	
	//Constructor
	
	public Management(int maintance, int restauration, int conservation){
		
		this.maintance = maintance;
		this.restauration = restauration;
		this.conservation = conservation;
	}
	
	//Gets
	
	public int getMaintance(){
		return maintance;
	}
	
	public int getRestauration(){
		return restauration;
	}
	
	public int getConservation(){
		return conservation;
	}
	
	//Sets 
	
	public void setMaintance(int pMaintance){
		maintance = pMaintance;
	}
	
	public void setRestauration(int pRestauration){
		restauration = pRestauration;
	}
	
	public void setConservation(int pConservation){
		conservation = pConservation;
	}

	@Override
	public String toString() {
		return "- Conservation=" + conservation + 
		"\n- Maintance=" + maintance + 
		"\n- Restauration=" + restauration;
	}

	

}