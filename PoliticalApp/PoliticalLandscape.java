package PoliticalApp;

public class PoliticalLandscape {
	private String governmentType; //convert to array
	private String headOfGovernment;
	private String headOfState;
	private String [] dominantParties;
	private double politicalStabilityIndex;
	private double corruptionIndex;
	
	
	
	public static void main(String[] args) 
	{
		

	}
	
	public PoliticalLandscape()
	{
		this.governmentType = ""; //convert to array
		this.headOfGovernment = "";
		this.headOfState = "";
		//this.dominantParties = new String[dominantPartiesIndex];
		//default values
		this.dominantParties = new String[] {"Unknown"};
		
		this.politicalStabilityIndex = 0.0;
		this.corruptionIndex = 0.0;
	}
	
	public PoliticalLandscape(String governmentType,String headOfGovernment,String headOfState,String[] dominantParties,double politicalStabilityIndex, double corruptionIndex)
	{
		this.governmentType = governmentType;
		this.headOfGovernment = headOfGovernment;
		this.headOfState = headOfState;
		this.politicalStabilityIndex = politicalStabilityIndex;
		this.corruptionIndex = corruptionIndex;
		this.dominantParties = dominantParties;
	}
	
	/*		Setters			*/
	public void setGovernmentType(String gType)
	{
		this.governmentType = gType;
	}
	
	public void setHeadOfGovernment(String headGovernment)
	{
		this.headOfGovernment = headGovernment;
	}
	
	public void setheadOfState(String headOfState)
	{
		this.headOfState = headOfState;
	}
	

	public void setPoliticalStabilityIndex(double stabilityIndex)
	{
		this.politicalStabilityIndex = stabilityIndex;
	}
	
	public void setCorruptionIndex(double corruptIndex)
	{
		this.corruptionIndex = corruptIndex;
	}
	

	
	/*		getters			*/
	public String getGovernmentType()
	{
		return this.governmentType;
	}
	
	public String getHeadOfGovernment()
	{
		return this.headOfGovernment;
	}
	
	public String getHeadOfState()
	{
		return this.headOfState;
	}
	
	public void setDominantParties(String [] dominantParties) {
		this.dominantParties = dominantParties;
	}
	
	public double getPoliticalStabilityIndex()
	{
		return this.politicalStabilityIndex;
	}
	
	public double getCorruptionIndex()
	{
		return this.corruptionIndex;
	}

	public String [] getDominantParties() {
		return dominantParties;
	}


}