package PoliticalApp;

import java.time.LocalDateTime;

public class DataTrendTrackingData {

	private LocalDateTime lastUpdated;
	private String dataSource; // API, dataset, manual entry, etc.
	private double confidenceScore; // 0.0–1.0 confidence in data quality
	
	private double climateRiskIndex;
	private String [] majorEnvironmentalIssues;
	private double disasterFrequencyScore;
	
	
	public static void main(String[] args) 
	{
		
		

	}
	
	public DataTrendTrackingData() 
	{
		climateRiskIndex = 0.0;
		disasterFrequencyScore = 0.0;
		majorEnvironmentalIssues = new String [] {"Unknown"};
		
	}

    public DataTrendTrackingData(String[] majorEnvironmentalIssues, LocalDateTime lastUpdated, String dataSource, Double confidenceScore) 
    {
        this.lastUpdated = lastUpdated;
        this.dataSource = dataSource;
        this.confidenceScore = confidenceScore;
        this.majorEnvironmentalIssues = majorEnvironmentalIssues;
    }

    
    /*		getters				*/
    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }
    public String getDataSource() {
        return dataSource;
    }
    public Double getConfidenceScore() {
        return confidenceScore;
    }
    
    public double getClimateRiskIndex()
    {
    	return this.climateRiskIndex;
    }
    public String [] getMajorEnvironmentalIssues()
    {
    	return majorEnvironmentalIssues;
    }
    
    public double getDisasterFrequencyScore()
    {
    	return this.disasterFrequencyScore;
    }

    /*		setters				*/
    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }
    
    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }
    
    public void setMajorEnvironmentalIssues(String [] majorEnvironmentalIssues)
    {
    	this.majorEnvironmentalIssues = majorEnvironmentalIssues;
    }
    
    public void setDisasterFrequencyScore(double disasterFrequencyScore)
    {
    	this.disasterFrequencyScore = disasterFrequencyScore;
    }
    
    public void setClimateRiskIndex(double climateRiskIndex) {
        this.climateRiskIndex = climateRiskIndex;
    }


}
