/**
 * KuzeRepository
 * @author: Tye Tosh
 * Description:
 *      Manages all response banks for the Kuze chatbot engine.
 *      Holds, populates, and provides access to the five ArrayList banks.
 *      Designed to be injected into Kuze.java keeping the engine lightweight.
 *      File I/O methods will be added here in a future release.
 */

import java.io.*;
import java.util.ArrayList;


public class KuzeRepository {
	
	// =====================
    // Response Banks
    // =====================
	
	private ArrayList<String> questions  = new ArrayList<>();
    private ArrayList<String> statements  = new ArrayList<>();
    private ArrayList<String> excitements = new ArrayList<>();
    private ArrayList<String> transitions = new ArrayList<>();
    private ArrayList<String> milestones  = new ArrayList<>();

	public static void main(String[] args) 
	{
		
	}
	
	
    
    public KuzeRepository() {
    	//1. populate defaults
        populateQuestionsArr();
        populateStatementsArr();
        populateExcitmentsArr();
        populateTransitionsArr();
        populateMilestonesArr();
        
        //2. load from file
        loadAllBanks();
    }
    
    private void populateQuestionsArr() {
        questions.add("Hi, I am progName. how are you today, userName?");
        questions.add("userName, would you like to add another job application?");
        questions.add("Do you want to enter another job application now, userName?");
        questions.add("What company are you applying to next, userName?");
        questions.add("userName, when did you submit this application?");
    }
    
    private void populateStatementsArr() {
        statements.add("userName, I've recorded that information for you. progName will keep everything organized.");
        statements.add("It looks like you're making progress, userName. progName is here to help you stay on track.");
        statements.add("userName, I've updated your job application details. Let me know what you want to do next.");
        statements.add("I have saved your latest entry, userName. You're doing great with your job search.");
        statements.add("Everything is stored safely, userName. progName will remind you when it's time to follow up.");
    }
    
    private void populateExcitmentsArr() {
        excitements.add("Amazing work, userName! I, progName, am impressed with your consistency.");
        excitements.add("Great job, userName! progName loves seeing your progress.");
        excitements.add("That's exciting, userName! I can't wait to help you with the next step.");
        excitements.add("Fantastic energy, userName! I am ready for whatever you want to do next.");
        excitements.add("You're on fire today, userName! I am cheering you on.");
    }

    private void populateTransitionsArr() {
        transitions.add("Got it, userName. Let me ask you something else.");
        transitions.add("Thanks for sharing that, userName. Here's my next question.");
        transitions.add("Noted, userName. Moving on —");
        transitions.add("Understood. Here's what I want to know next, userName.");
        transitions.add("Alright userName, let's keep going.");
    }

    private void populateMilestonesArr() {
        milestones.add("userName, that's a big step — progName is proud of your progress!");
        milestones.add("Milestone reached, userName! progName has been keeping count.");
        milestones.add("Look at you go, userName! progName knew you had it in you.");
        milestones.add("userName, you've hit a milestone! progName is cheering you on.");
        milestones.add("Another milestone, userName! progName is impressed with your drive.");
    }
    
    
    /** 
     * =====================
     * 		Bank Size
     * =====================
     */
    
    public int getBankSize(ArrayList<String> bank) {
        return bank.size();
    }
    
    // =====================
    // 		Bank Getters
    // =====================
    public ArrayList<String> getQuestions()   { return questions;   }
    public ArrayList<String> getStatements()  { return statements;  }
    public ArrayList<String> getExcitements() { return excitements; }
    public ArrayList<String> getTransitions() { return transitions; }
    public ArrayList<String> getMilestones()  { return milestones;  }
    
 // =====================
    // Get Response by Index
    // =====================

    public String getQuestion(int index)   { return questions.get(index);   }
    public String getStatement(int index)  { return statements.get(index);  }
    public String getExcitement(int index) { return excitements.get(index); }
    public String getTransition(int index) { return transitions.get(index); }
    public String getMilestone(int index)  { return milestones.get(index);  }


    // =====================
    // Add Response at Runtime
    // =====================

    public void addQuestion(String response)   { questions.add(response);   }
    public void addStatement(String response)  { statements.add(response);  }
    public void addExcitement(String response) { excitements.add(response); }
    public void addTransition(String response) { transitions.add(response); }
    public void addMilestone(String response)  { milestones.add(response);  }


    // =====================
    // Clear Banks
    // =====================

    public void clearQuestions()   { questions.clear();   }
    public void clearStatements()  { statements.clear();  }
    public void clearExcitements() { excitements.clear(); }
    public void clearTransitions() { transitions.clear(); }
    public void clearMilestones()  { milestones.clear();  }


    // =====================
    // Future File I/O - Stage Two
    // loadBankFromFile(String filePath, ArrayList<String> bank)
    // saveBankToFile(String filePath, ArrayList<String> bank)
    // =====================
    
    public void saveBankToFile(String fileName, ArrayList<String> bank)
    {
    	BufferedWriter writer = null;
    	
    	try 
    	{
    		
			writer = new BufferedWriter(new FileWriter(fileName));
			
			for (String reply: bank)
			{
				writer.write(reply);
				writer.newLine();
			}
    		
    	}
    	catch(IOException e) 
    	{
    		System.out.println("Error saving bank: " + fileName);
    	}
    	finally 
    	{
    		try {
    			if(writer != null) writer.close();
    			}
    		catch(IOException e)
    		{
    			System.out.println("Error closing writer.");
    		}
    	}
    }
    
    public void loadBankFromFile(String fileName, ArrayList<String> bank)
    {
    	File file = new File(fileName);
    		if(!file.exists()) {return;} //No files yet - keeps defaults
    		
    	BufferedReader reader = null;
    	try {
    		reader = new BufferedReader(new FileReader(file));
    		bank.clear(); //overwrites defaults
    		
    		String line;
    		while((line = reader.readLine()) != null) {bank.add(line);}
    	}
    	catch(IOException e) {
    		System.out.println("Error loading bank: " + fileName);
    	}
    	finally {
    		try {if(reader !=null) reader.close();}
    		catch(IOException e){System.out.println("Error closing reader.");}
    	}
    }
    
 // =====================
 // Load All Banks
 // =====================
    public void loadAllBanks() 
    {
     loadBankFromFile("questions.txt", questions);
     loadBankFromFile("statements.txt", statements);
     loadBankFromFile("excitements.txt", excitements);
     loadBankFromFile("transitions.txt", transitions);
     loadBankFromFile("milestones.txt", milestones);
    }

 // =====================
 // Save All Banks
 // =====================
    public void saveAllBanks() 
    {
     saveBankToFile("questions.txt", questions);
     saveBankToFile("statements.txt", statements);
     saveBankToFile("excitements.txt", excitements);
     saveBankToFile("transitions.txt", transitions);
     saveBankToFile("milestones.txt", milestones);

     System.out.println("All banks saved.");
    }
    
}
