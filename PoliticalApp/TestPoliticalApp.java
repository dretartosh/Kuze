package PoliticalApp;


public class TestPoliticalApp {
    public static void main(String[] args) {

    	 //CountryDataCollector collector = new CountryDataCollector();
    	 //Country c = collector.collectCountry();
    	
    	 //System.out.println("\n\n=== FULL PROFILE OUTPUT ===");
    	 //c.printFullProfile();
    	 
    	 
//        // 1. Create Geography object
//        //Geography geo = new Geography("Kingston",10991.0,2900000,0.3);
//
//        // 2. Create PoliticalLandscape object
//        //String[] parties = {"JLP", "PNP"};
//        
//        //PoliticalLandscape pol = new PoliticalLandscape("Parliamentary Democracy","Prime Minister","Governor General",parties, 0.65, 0.45);
//
//        // 3. Create Trend Metadata object
//        
//        DataTrendTrackingData meta = new DataTrendTrackingData(parties, java.time.LocalDateTime.now(),"Manual Entry",0.95);
//        
//        meta.setClimateRiskIndex(7.5);
//        meta.setMajorEnvironmentalIssues(new String[]{"Hurricanes", "Flooding"});
//        meta.setDisasterFrequencyScore(6.2);
//
//        // 4. Create Country object
//        Country jamaica = new Country(1,"JM","JAM","Jamaica","Jam","Caribbean","West Indies", geo, pol, meta);
//
//        // 5. Print full profile
//       jamaica.printFullProfile();
    	
    	CountryManager manager = new CountryManager();
    		
    		Country c1 = new Country();
    		c1.setCountryName("Jamaica");
    		
    		Country c2 = new Country();
    		c2.setCountryName("Canada");
    		
    		manager.addCountry(c1);
    		manager.addCountry(c2);
    		
    		manager.listAllCountries();
    		
    		Country found = manager.findCountryByName("Jamaica");
    		System.out.println("Found: " + found.getCountryName());
        
        
    }
}

