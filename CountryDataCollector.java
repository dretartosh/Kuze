package PoliticalApp;


import java.util.Scanner;
import java.time.LocalDateTime;

public class CountryDataCollector {

    private Scanner sc;

    public CountryDataCollector() {
        sc = new Scanner(System.in);
    }

    // ============================
    // Collect Country Identity
    // ============================
    public Country collectCountry() {

        System.out.println("=== Enter Country Identity Information ===");

        System.out.print("Country ID (number): ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Country Name: ");
        String name = sc.nextLine();

        System.out.print("Short Country Name: ");
        String shortName = sc.nextLine();

        System.out.print("ISO Code (2 letters): ");
        String iso2 = sc.nextLine();

        System.out.print("ISO Code (3 letters): ");
        String iso3 = sc.nextLine();

        System.out.print("Region: ");
        String region = sc.nextLine();

        System.out.print("Sub-Region: ");
        String subRegion = sc.nextLine();

        // Collect sub-objects
        Geography geo = collectGeography();
        PoliticalLandscape pol = collectPoliticalLandscape();
        DataTrendTrackingData meta = collectTrendMetadata();

        // Build final Country object
        return new Country(
                id,
                iso2,
                iso3,
                name,
                shortName,
                region,
                subRegion,
                geo,
                pol,
                meta
        );
    }

    // ============================
    // Collect Geography
    // ============================
    public Geography collectGeography() {

        System.out.println("\n=== Enter Geography Information ===");

        System.out.print("Capital City: ");
        String capital = sc.nextLine();

        System.out.print("Area (km²): ");
        double area = Double.parseDouble(sc.nextLine());

        System.out.print("Population Total: ");
        double population = Double.parseDouble(sc.nextLine());

        System.out.print("Population Growth Rate (%): ");
        double growth = Double.parseDouble(sc.nextLine());

        return new Geography(capital, area, population, growth);
    }

    // ============================
    // Collect Political Landscape
    // ============================
    public PoliticalLandscape collectPoliticalLandscape() {

        System.out.println("\n=== Enter Political Landscape Information ===");

        System.out.print("Government Type: ");
        String govType = sc.nextLine();

        System.out.print("Head of Government: ");
        String headGov = sc.nextLine();

        System.out.print("Head of State: ");
        String headState = sc.nextLine();

        System.out.print("Number of Dominant Parties: ");
        int count = Integer.parseInt(sc.nextLine());

        String[] parties = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Party " + (i + 1) + ": ");
            parties[i] = sc.nextLine();
        }

        System.out.print("Political Stability Index (0–1): ");
        double stability = Double.parseDouble(sc.nextLine());

        System.out.print("Corruption Index (0–1): ");
        double corruption = Double.parseDouble(sc.nextLine());

        return new PoliticalLandscape(
                govType,
                headGov,
                headState,
                parties,
                stability,
                corruption
        );
    }

    // ============================
    // Collect Trend Metadata
    // ============================
    public DataTrendTrackingData collectTrendMetadata() {

        System.out.println("\n=== Enter Trend & Metadata Information ===");

        System.out.print("Data Source (API, Manual, Dataset): ");
        String source = sc.nextLine();

        System.out.print("Confidence Score (0–1): ");
        double confidence = Double.parseDouble(sc.nextLine());

        System.out.print("Climate Risk Index (0–10): ");
        double climate = Double.parseDouble(sc.nextLine());

        System.out.print("Number of Environmental Issues: ");
        int count = Integer.parseInt(sc.nextLine());

        String[] issues = new String[count];
        for (int i = 0; i < count; i++) {
            System.out.print("Issue " + (i + 1) + ": ");
            issues[i] = sc.nextLine();
        }

        System.out.print("Disaster Frequency Score (0–10): ");
        double disaster = Double.parseDouble(sc.nextLine());

        // Build metadata object
        DataTrendTrackingData meta = new DataTrendTrackingData(
                issues, LocalDateTime.now(),
                source,
                confidence
        );

        meta.setClimateRiskIndex(climate);
        meta.setMajorEnvironmentalIssues(issues);
        meta.setDisasterFrequencyScore(disaster);

        return meta;
    }
}
