package PoliticalApp;

public class Geography {
	
	private String capitalCity;
	private double areaKm2;
	private double populationTotal;
	private double populationGrowthRate;

	public static void main(String[] args) 
	{
		

	}
	
	public Geography()
	{
		capitalCity = "";
		areaKm2 = 0.0;
		populationTotal = 0.0;
		populationGrowthRate = 0.0;
	}
	
	public Geography(String capitalCity, double areaKm2, double populationTotal, double populationGrowthRate)
	{
		this.capitalCity = capitalCity;
		this.areaKm2 = areaKm2;
		this.populationTotal = populationTotal;
		this.populationGrowthRate = populationGrowthRate;
	}
	
	/*		Setters				*/
	public void setCapitalCity(String cCity)
	{
		this.capitalCity = cCity;
	}
	
	public void setAreaKiloMetersSquared(double aKm)
	{
		this.areaKm2 = aKm;
	}
	
	public void setPopulationTotal(double pTotal)
	{
		this.populationTotal = pTotal;
	}
	
	public void setPopulationGrowthRate(double pGrowthRate)
	{
		this.populationGrowthRate = pGrowthRate;
	}
	
	
	/*		getters				*/
	
	public String getCapitalCity()
	{
		return this.capitalCity;
	}
	
	public double getAreaKiloMetersSquared()
	{
		return this.areaKm2;
	}
	
	public double getPopulationTotal()
	{
		return this.populationTotal;
	}
	
	public double getPopulationGrowthRate()
	{
		return this.populationGrowthRate;
	}
}
