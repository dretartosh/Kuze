package PoliticalApp;
import java.util.ArrayList;
import java.util.*;


public class CountryManager {

		
	private ArrayList<Country> countries;
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
        CountryManager manager = new CountryManager();

        while (true) {
            System.out.println("\n=== COUNTRY MANAGER MENU ===");
            System.out.println("1. Add a new country");
            System.out.println("2. List all countries");
            System.out.println("3. Find a country");
            System.out.println("4. Delete a country");
            System.out.println("5. Update a country");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = Integer.parseInt(sc.nextLine());

            if (choice == 1) {manager.addCountryFromInput();}
            else if (choice == 2) {manager.listAllCountries();}
            else if (choice == 3) 
            {
            	System.out.print("Enter country name: ");String name = sc.nextLine();Country found = manager.findCountryByName(name);
            
                if (found != null) {found.printFullProfile();} 
                else {System.out.println("Country not found.");}
                
            }
            else if (choice == 4) 
            {
            	System.out.print("Enter country name to delete: ");String name = sc.nextLine();
                
            	if (manager.deleteCountry(name)) {System.out.println("Country deleted.");} 
            	else {System.out.println("Country not found.");}
            	
            }
            else if (choice == 5) 
            {
            	System.out.print("Enter country name to update: ");String name = sc.nextLine();

                if (manager.updateCountry(name)) {System.out.println("Country updated.");}
                else {System.out.println("Country not found.");}
                
            }
            else if (choice == 6) {System.out.println("Goodbye.");break;}
            
        }
        
        sc.close();
	}
        
	

	
	public CountryManager()
	{
		countries = new ArrayList<>();
	}
	
	public void addCountry(Country c)
	{
		countries.add(c);
	}
	
	public Country findCountryByName(String name) 
	{
		
        for (Country c : countries) {
            if (c.getCountryName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }
	
	public void listAllCountries() 
	{
        for (Country c : countries) 
        {
            System.out.println(c.getCountryName());
        }
	}
	
	public void addCountryFromInput() {
	    CountryDataCollector collector = new CountryDataCollector();
	    Country c = collector.collectCountry();
	    addCountry(c);
	    System.out.println("Country added successfully.");
	}
	
	public boolean deleteCountry(String name) {
	    for (int i = 0; i < countries.size(); i++) {
	        Country c = countries.get(i);

	        if (c.getCountryName().equalsIgnoreCase(name)) {
	            countries.remove(i);
	            return true;   // deletion successful
	        }
	    }
	    return false;  // not found
	}

	public boolean updateCountry(String name) {
	    Country existing = findCountryByName(name);

	    if (existing == null) {
	        return false;
	    }

	    CountryDataCollector collector = new CountryDataCollector();
	    Country updated = collector.collectCountry();

	    // Replace the old object with the new one
	    int index = countries.indexOf(existing);
	    countries.set(index, updated);

	    return true;
	}
	
	public String getCountryNamesAsString() {
	    if (countries.isEmpty()) {
	        return "I don't have any countries stored yet.";
	    }

	    StringBuilder sb = new StringBuilder("Countries I know:\n");

	    for (Country c : countries) {
	        sb.append("- ").append(c.getCountryName()).append("\n");
	    }

	    return sb.toString();
	}


}
