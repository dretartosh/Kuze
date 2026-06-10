package PoliticalApp;

import java.util.Arrays;

public class Country {

	/*	Core ID and Classification	*/
	private int id;
	private String isoCode2; //Two-letter ISO code 
	private String isoCode3; //Three-letter ISO code
	private String countryName;
	private String shortCountryName;
	private String region;
	private String subRegion;
	
	private double lastIndexScore = 0.0;

	
	
	private Geography populationGeographyData;
	private PoliticalLandscape politicalMapping;
	private DataTrendTrackingData trendTrackingData;
	
	public static void main(String[] args) 
	{
		

	}
	public Country()
	{
		id = 0;
		isoCode2 = "";
		isoCode3 = "";
		countryName = "";
		shortCountryName = "";
		region = "";
		subRegion =  "";
	}
	public Country
	(
			int id, 
			String isoCode2, 
			String isoCode3, 
			String countryName,
			String shortCountryName, 
			String region, 
			String subRegion, 
			Geography populationGeographyData, 
			PoliticalLandscape politicalMapping, 
			DataTrendTrackingData trendTrackingData
	)
	
	{
		this.id = id;
		this.isoCode2 = isoCode2;
		this.isoCode3 = isoCode3;
		this.countryName = countryName;
		this.shortCountryName = shortCountryName;
		this.region = region;
		this.subRegion = subRegion;
		this.populationGeographyData = populationGeographyData;
		this.politicalMapping = politicalMapping;
		this.trendTrackingData = trendTrackingData;
	}
	
	/*		Setters			*/
	public void setCountryID(int id)
	{
		this.id = id;
	}
	
	public void setCountryISOCode2(String code2)
	{
		this.isoCode2 = code2;
	}
	
	public void setCountryISOCode3(String code3)
	{
		this.isoCode3 = code3;
	}
	
	public void setCountryName(String cName)
	{
		this.countryName = cName;
	}
	
	public void setShortCountryName (String shortCName)
	{
		this.shortCountryName = shortCName;
	}
	
	public void setRegion (String region)
	{
		this.region = region;
	}
	
	public void setSubRegion(String subRegion)
	{
		this.subRegion = subRegion;
	}
	
	/*		Getters			*/
	public int getCountryID()
	{
		return this.id;
	}
	
	public String getCountryISOCode2()
	{
		return this.isoCode2;
	}
	
	public String getCountryISOCode3()
	{
		return this.isoCode3;
	}
	
	public String getCountryName()
	{
		return this.countryName;
	}
	
	public String getShortCountryName()
	{
		return this.shortCountryName;
	}
	
	public String getRegion()
	{
		return this.region;
	}
	
	public String getSubRegion()
	{
		return this.subRegion;
	}
	
	public void printFullProfile()
	{
		System.out.println ("===== FULL POLITICAL PROFILE =====");
		
		System.out.println("\n--- Country Identity ---");
	    System.out.println("Country Name: " + countryName);
	    System.out.println("Short Name: " + shortCountryName);
	    System.out.println("ISO Code 2: " + isoCode2);
	    System.out.println("ISO Code 3: " + isoCode3);
	    System.out.println("Region: " + region);
	    System.out.println("Sub-Region: " + subRegion);
	    
	    System.out.println("\n--- Geography ---");
	    if (populationGeographyData != null) {
	        System.out.println("Capital City: " + populationGeographyData.getCapitalCity());
	        System.out.println("Area (km²): " + populationGeographyData.getAreaKiloMetersSquared());
	        System.out.println("Population Total: " + populationGeographyData.getPopulationTotal());
	        System.out.println("Population Growth Rate: " + populationGeographyData.getPopulationGrowthRate());
	    }
	    
	    System.out.println("\n--- Political Landscape ---");
	    if (politicalMapping != null) {
	        System.out.println("Government Type: " + politicalMapping.getGovernmentType());
	        System.out.println("Head of Government: " + politicalMapping.getHeadOfGovernment());
	        System.out.println("Head of State: " + politicalMapping.getHeadOfState());
	        System.out.println("Dominant Parties: " + Arrays.toString(politicalMapping.getDominantParties()));
	        System.out.println("Political Stability Index: " + politicalMapping.getPoliticalStabilityIndex());
	        System.out.println("Corruption Index: " + politicalMapping.getCorruptionIndex());
	    }
	    
	    System.out.println("\n--- Environmental & Risk Indicators ---");
	    if (trendTrackingData != null) {
	        System.out.println("Climate Risk Index: " + trendTrackingData.getClimateRiskIndex());
	        System.out.println("Major Environmental Issues: " + Arrays.toString(trendTrackingData.getMajorEnvironmentalIssues()));
	        System.out.println("Disaster Frequency Score: " + trendTrackingData.getDisasterFrequencyScore());
	    }
	    
	    System.out.println("\n--- Data Metadata ---");
	    if (trendTrackingData != null) {
	        System.out.println("Last Updated: " + trendTrackingData.getLastUpdated());
	        System.out.println("Data Source: " + trendTrackingData.getDataSource());
	        System.out.println("Confidence Score: " + trendTrackingData.getConfidenceScore());
	    }

	    System.out.println("======================================");
	}
	public Geography getGeography() {
		return populationGeographyData;
	}
	
	public void setGeography(Geography populationGeographyData) {
	    this.populationGeographyData = populationGeographyData;
	}

	
	public DataTrendTrackingData getTrendTrackingData() {
	    return trendTrackingData;
	}
	public void setTrendTrackingData(DataTrendTrackingData trendTrackingData) {
	    this.trendTrackingData = trendTrackingData;
	}

	public PoliticalLandscape getPoliticalLandscape() {
	    return politicalMapping;
	}

	public void setPoliticalLandscape(PoliticalLandscape politicalMapping) {
	    this.politicalMapping = politicalMapping;
	}

	public double calculatePoliticalMarketIndex() {

	    double stability = politicalMapping.getPoliticalStabilityIndex(); // 0–1
	    double corruption = 1 - politicalMapping.getCorruptionIndex();    // invert
	    double climate = 1 - trendTrackingData.getClimateRiskIndex() / 10;
	    double disaster = 1 - trendTrackingData.getDisasterFrequencyScore() / 10;

	    // Weighted formula (adjustable)
	    double score =
	            (stability * 0.35) +
	            (corruption * 0.25) +
	            (climate * 0.20) +
	            (disaster * 0.20);

	    return score * 100; // 0–100 scale
	}

	public double updatePoliticalIndex() {
	    double newScore = calculatePoliticalMarketIndex();
	    double change = newScore - lastIndexScore;
	    lastIndexScore = newScore;
	    return change;
	}
	
	public String getIndexTrend() {
	    double newScore = calculatePoliticalMarketIndex();
	    double change = newScore - lastIndexScore;

	    if (change > 0) {
	        return "▲ Up " + String.format("%.2f", change);
	    } 
	    else if (change < 0) {
	        return "▼ Down " + String.format("%.2f", Math.abs(change));
	    } 
	    else {
	        return "→ No Change";
	    }
	}



}
