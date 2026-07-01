/**
 * Kuze Chatbot Engine
 * @author: Tye Tosh
 * Description:
 * 		Kuze is a simple chatbot engine used to generate personalized
 * 		questions, statements, and excitement responses for a 
 * 		job application tracking program
 * */


//import java.util.ArrayList;
import java.util.Scanner;

import PoliticalApp.CountryManager;
import PoliticalApp.Country;

public class Kuze {

		/**
		 * Stores chatbot responses for replaceName() for personalization
		 */
	
		public String [] questions; 
		public String [] statements;
		public String [] excitements;
		public String [] transitions;
		public String [] milestones;
		
		
		private String userAccount; //stores name provided by user
		private String progAccount; //Stores chatbot name
		private char lastUserMood; //default
		
		
		private int BankSize = 5; //set size of responses - stage pulling from a DB
		private int responseCount = 0; //Kuze tracks how many exchanges have happened, useful for triggering milestone messages later (e.g. "That's your 5th application!").
		private int lastQuestionIndex  = -1;
		private int lastStatementIndex = -1;
		private int lastExcitementIndex = -1;
		private int lastTransitionIndex = -1;
		private int lastMilestoneIndex = -1;
		
		private CountryManager manager;
		private KuzeRepository repo;
		 
		
		//replace private static final String SENTINEL = "SENTINEL";
		private static final String[] EXIT_KEYWORD = {"SENTINEL", "exit", "quit", "bye", "goodbye", "agent", "end"};
		private static String progJobDescription;
		
		
		/* creating global variables to be used in chatbot*/
		
		
		public Kuze() /* 1st Constructor */
		{ //constructor body
			questions = new String[BankSize];
			statements = new String[BankSize];
			excitements = new String[BankSize];
			transitions = new String[BankSize];
			milestones = new String[BankSize];
			
			progAccount = "Kuze"; //default chatbot Name
			userAccount = "";
			progJobDescription = "help to track your Job Applications";
			lastUserMood = '-';
 
			populateQuestionsArr();
			populateStatementsArr();
			populateExcitmentsArr();
			populateTransitionsArr();
			populateMilestonesArr();
			
			/*  
			 * Initializes the chatbot with default values and loads
			 * all prompt banks into memory.
			 * 
 			*/
		}
		
		public Kuze(CountryManager manager) /* 2nd Constructor */
		{
			this.manager = manager;
			this.repo = new KuzeRepository();
		}
		
		public Kuze(CountryManager manager, String userName) /* 3rd Constructor */
		{
		    // allows access to the data layer
		    this.manager = manager;
		    this.repo = new KuzeRepository();

		    // Run the full personality setup
		    questions   = new String[BankSize];
		    statements  = new String[BankSize];
		    excitements = new String[BankSize];
		    transitions = new String[BankSize];
		    milestones  = new String[BankSize];

		    progAccount      = "Kuze";
		    userAccount      = userName.toUpperCase();
		    progJobDescription = "help to track your Job Applications";
		    lastUserMood     = '-';

		    populateQuestionsArr();
		    populateStatementsArr();
		    populateExcitmentsArr();
		    populateTransitionsArr();
		    populateMilestonesArr();
		}

	public static void main(String[] args)
	{
	}
 

	
	//setters
	public void setUserAccount(String userAccount)
	{
		this.userAccount = userAccount;
	}
	
	public void setProgAccount(String progAccount)
	{
		this.progAccount = progAccount;
	}
	
	public void populateStatementsArr()
	{
		statements[0] = "userName, I’ve recorded that information for you. progName will keep everything organized.";
		
		statements[1] = "It looks like you’re making progress, userName. progName is here to help you stay on track.";
		statements[2] = "userName, I’ve updated your job application details. Let me know what you want to do next.";
		statements[3] = "I have saved your latest entry, userName. You’re doing great with your job search.";
		statements[4] = "Everything is stored safely, userName. progName will remind you when it’s time to follow up.";
	}
	
	public void populateQuestionsArr()
	{
		questions[0] = "Hi, I am progName. how are you today, userName?";
		
		questions[1] = "userName, would you like to add another job application?";
		questions[2] = "Do you want to enter another job application now, userName?";
		questions[3] = "What company are you applying to next, userName?";
		questions[4] = "userName, when did you submit this application?";
		//questions[5] = " What is the date you applied for this job, userName?";
		//questions[6] = " What is the date you applied for this job, userName?";
		//questions[7] = " What is the date you applied for this job, userName?";
		//questions[8] = " What is the date you applied for this job, userName?";
	}
	
	public void populateExcitmentsArr()
	{
		excitements[0] = "Amazing work, userName! I, progName,  am impressed with your consistency.";
		
		excitements[1] = "Great job, userName! progName loves seeing your progress.";
		excitements[2] = "That’s exciting, userName! I can’t wait to help you with the next step.";
		excitements[3] = "Fantastic energy, userName! I am ready for whatever you want to do next.";
		excitements[4] = "You’re on fire today, userName! I am cheering you on.";
	}
	
	public void populateTransitionsArr()
	{
		transitions[0] = "Got it, userName. Let me ask you something else.";
	    transitions[1] = "Thanks for sharing that, userName. Here's my next question.";
	    transitions[2] = "Noted, userName. Moving on —";
	    transitions[3] = "Understood. Here's what I want to know next, userName.";
	    transitions[4] = "Alright userName, let's keep going.";
	}
	
	public void populateMilestonesArr()
	{
	    
	    milestones[0] = "userName, that's a big step — progName is proud of your progress!";
	    milestones[1] = "Milestone reached, userName! progName has been keeping count.";
	    milestones[2] = "Look at you go, userName! progName knew you had it in you.";
	    milestones[3] = "userName, you've hit a milestone! progName is cheering you on.";
	    milestones[4] = "Another milestone, userName! progName is impressed with your drive.";
	}
	
	//getters
	
	public String getUserAccount()
	{
		return this.userAccount;
	}
	public String getUserAccount(Scanner scnr)
	{
		String userName = scnr.nextLine();
	
		return userName.toUpperCase();
	}
	
	public String getProgAccount()
	{
		return "Kuze"; //default chatbot Name
	}
	public String getProgAccount(Scanner scnr) 
	{
		/**
		 * method overload - allow user to name program
		 * 
		 * If users are allowed to name the chatbot this would allow the user to 
		 * provide a name for the interaction.
		 * 
		 * @param Scanner from JobApplication
		 * @return A fully upper case string that will be replace progName
		 */
		
		String progName = scnr.nextLine();
		
		return progName.toUpperCase();
	}
	
	public String getProgramQuestionsReply()
	{
		//String progReply = questions[(int)(Math.random()*(BankSize))];    - v1.0.0
		//String progReply = questions[(int)(Math.random()*getBankSize(questions))];
		//return replaceName(progReply);
		
		
		lastQuestionIndex   = getUniqueIndex(lastQuestionIndex,   getBankSize(questions));
	    return replaceName(questions[lastQuestionIndex]);
		
		
	}
	public String getProgramQuestionsReply(int index)
	{
		/**
		 * method overload - get a specific question
		 * 
		 * Gets a specific question from the question bank.
		 * 
		 * @param index - of the question to be retrieve.
		 * @returns A full personalized question with placeholder replaced.
		 * */
		
			String progReply = questions[index];
			return replaceName(progReply);
	}
	
	public String getProgramStatementsReply()
	{		
		//String progReply = statements[(int)(Math.random()*(BankSize))];
		//String progReply = statements[(int)(Math.random()*getBankSize(statements))];
		//return replaceName(progReply);
			
			lastStatementIndex = getUniqueIndex(lastStatementIndex, getBankSize(statements));
		    return replaceName(statements[lastStatementIndex]);
	}
	
	public String getProgramStatementsReply(int index)
	{	//overload- get a specific statement	
		String progReply = statements[index];
			return replaceName(progReply);
	}
	
	public String getProgramStatementsReply(String progReply)
	{	//overload - adds message with statement
		progReply += " " + statements[(int)(Math.random()*getBankSize(statements))];
			return replaceName(progReply);
	}
	
	public String getProgramExcitementsReply()
	{	
		//String progReply = excitements[(int)(Math.random()*(BankSize))];
		
		//String progReply = excitements[(int)(Math.random()*getBankSize(excitements))];
			//return replaceName(progReply);
		
		lastExcitementIndex = getUniqueIndex(lastExcitementIndex, getBankSize(excitements));
	    return replaceName(excitements[lastExcitementIndex]);
	}
	
	public String getProgramExcitmentsReply(String progReply)
	{
		/**
		 * method overload- adds message with excitement
		 * 
		 * Gets a specific excitement from the excitement bank.
		 * 
		 * @param progReply - manual Excitement to be added to personalized 
		 * @returns A full amended personalized excitement with placeholder replaced.
		 * */
		//progReply += " " + excitements[(int)(Math.random()*(BankSize))];
		//progReply += " " + excitements[(int)(Math.random()*getBankSize(excitements))];
		
		
				lastExcitementIndex = getUniqueIndex(lastExcitementIndex, getBankSize(excitements));
				progReply += " " + excitements[lastExcitementIndex];
		return replaceName(progReply);
	}
	
	public String getProgramMilestoneReply()
	{
	    /**
	     * Returns a personalized milestone celebration message.
	     * Call this when isMilestoneReached() returns true.
	     *
	     * @return A personalized milestone response
	     */
	    //int index = (int)(Math.random() * getBankSize(milestones));
	    //return replaceName(milestones[index]);
		
		lastMilestoneIndex = getUniqueIndex(lastMilestoneIndex, getBankSize(milestones));
	    return replaceName(milestones[lastMilestoneIndex]);
	}
	
	public String getTransitionsReply()
	{
			/**
			 * Returns a random bridging statement to smooth conversation flow.
			 * Placeholder tokens are replaced via replaceName
			 * 
			 * @return A Kuze personalized transition line
			 */
		
			//String progReply = transitions[(int)(Math.random() * BankSize)];
			//String progReply = transitions[(int)(Math.random()*getBankSize(transitions))];
			//return replaceName(progReply);
			
			lastTransitionIndex = getUniqueIndex(lastTransitionIndex, getBankSize(transitions));
		    return replaceName(transitions[lastTransitionIndex]);
	}
	
	private int getBankSize(String[] bank)
	{
		/**
		 * Returns the usable size of a reponse bank.
		 * Prevents index-out-bounds if bank grow unevenly
		 * 
		 * @param bank the response array to measure
		 * @return length of array
		 */
		
		return bank.length;
	}
	
	

	
	public int getResponseCount()
	{
		
		return responseCount;
	}
	
	public char getLastuserMood()
	{
			
		return lastUserMood;
	}
	
	/**
	 * @deprecated Use getUniquieIndex(int lastIndex, int bankSize)
	 */
	@SuppressWarnings("unused")
	@Deprecated
	private int getUniqueIndex(int lastIndex)
	{
		/**
	     * Returns a random index that differs from the last used index.
	     * Prevents consecutive duplicate responses.
	     *
	     * @param lastIndex the previously used index
	     * @return a new random index guaranteed to differ
	     */
		
		int newIndex;
			do 	{
				newIndex = (int)(Math.random() * BankSize);
				}while(newIndex == lastIndex && BankSize > 1);
			
		//return getUniqueIndex(lastIndex, BankSize);	
		return newIndex;
	}
	
	private int getUniqueIndex(int lastIndex, int bankSize) //oveerload
	{
		/**
	     * Returns a random index that differs from the last used index.
	     * Prevents consecutive duplicate responses.
	     *
	     * @param lastIndex the previously used index
	     * @return a new random index guaranteed to differ
	     */
		
		int newIndex;
			do 	{
				newIndex = (int)(Math.random() * bankSize);
				}while(newIndex == lastIndex && bankSize > 1);
		return newIndex;
	}
	
	
	
	public String getSessionSummary()
	{
	    /**
	     * Returns a formatted summary of the current session state.
	     * Includes user name, chatbot name, response count, and last mood.
	     *
	     * @return A multi-line session summary string
	     */
	    return  "Session Summary\n" +
	            "User     : " + userAccount      + "\n" +
	            "Chatbot  : " + progAccount      + "\n" +
	            "Exchanges: " + responseCount     + "\n" +
	            "Last mood: " + lastUserMood;
	}
	
	public String getGreetingbyMood()
	{
		/**
		 * Returns a response type matched to the user's last detected mood.
		 * E = excitement reply, Q = question reply, S = statement reply.
		 * 
		 * using new switch format
		 * @return A modd-appropriate personal response
		 */
		
		switch(lastUserMood)
		{
			case 'E' -> {return getProgramExcitementsReply();} //must enclose return
			case 'Q' -> { return getProgramQuestionsReply();  }
			default  -> { return getProgramStatementsReply(); }
		}
	}
	
	public String getEchoReply(String userInput)
	{
	    /**
	     * Generates a short echo confirmation of the user's input.
	     * Keeps Kuze feeling attentive and responsive.
	     *
	     * @param userInput the raw string the user entered
	     * @return A personalized echo confirmation string
	     */
		
	    	if (!validateInput(userInput)) { return ""; }
	    return replaceName("I heard you, userName — \"" + userInput.trim() + "\". Let me respond to that.");
	}
		
	//display
	public static void displayProgramExitMessage()
	{
		System.out.println("I see you have entered the exit key. Goodbye !!!");
	}
	
	public static void displayProgramWelcomeMessage()
	{
		System.out.print("Hello, I am a Chatbot, ready to "+ progJobDescription +".\nPlease enter your name to continue: ");
		
			
	}
	
	//validations - Logic Operations
	
	public boolean validateInput (String input)
	{
		/**
		 * Checks user input is not null, empty or whitespace only.
		 * 
		 * @param input - raw sting from scanner
		 * @return true if the input is usable, false otherwise
		 */
		
		return input != null && !input.trim().isEmpty();
	}
	
	public boolean progSentinal(String userIsExit)
	{
		/**
		 * Checks whether the user input matches any recognized  exit keyboard.
		 * Case-insensitive. Catches SENTINEL plus natural exit phrases.
		 * 
		 * @param userIsExit the user's raw input
		 * @return true if input signals an exit intent, otherwise false
		 */
		
				//Kuze release V.1.0.0
				//if(userIsExit.equalsIgnoreCase(SENTINEL)){return true;}
				//else{return false;}
				
				//Kuze release V.1.0.1 - June 30 release
				if(userIsExit == null) {return false;}
					String trim = userIsExit.trim();
						for(String keyword : EXIT_KEYWORD) {
							if(trim.equalsIgnoreCase(keyword)) {return true;}
						}
				return false;
	}
	
	public String replaceName(String promptStatement)
	{
		/**
		 * Replaces placeholder tokens (progName, userName) in the
		 * chatbot's response with actual runtime values.
		 * 
		 * @param promptStatement the message containing placeholders.
		 * @return A fully personalized chatbot message
		 */
		
		if(promptStatement == null){return "";}
		if(progAccount == null){progAccount = getProgAccount();}
					
		promptStatement = promptStatement.replace("progName", progAccount);
		promptStatement = promptStatement.replace("userName", userAccount);
		
		return promptStatement;
	}
	
	public char statementLevel(String usr)
	{
		
		
		/**
		 * Determines the type of user input based on punctuation:
		 * Q = question, E = excitement, S = statement, - = default.
		 * 
		 * @param String statement from the user
		 * @return the type of punctuation used by the user
		 */
		
		if			(usr.endsWith("?")) {lastUserMood ='Q';}
		else if		(usr.endsWith("!")){lastUserMood ='E';}
		else if		(usr.endsWith(".")){lastUserMood ='S';}
		else 		{lastUserMood = 'S';}
		
		return lastUserMood;
	}
	
	public void incrementResponseCount()
	{
		responseCount++;
	}
	
	public boolean isMilestoneReached(int milestone)
	{
		/**
	     * Checks whether the response count has hit a given milestone.
	     * Useful for triggering special messages at round numbers.
	     *
	     * @param milestone the count to check against
	     * @return true if responseCount equals milestone
	     */
		
		return responseCount == milestone;
	}
	
	public String answerCountryQuery(String countryName) {
	    Country c = manager.findCountryByName(countryName);

	    if (c == null) {
	        return "I don't have data for " + countryName + " yet.";
	    }

	    // Build a natural language response
	    return "Here is what I know about " + c.getCountryName() + ":\n" +
	           "- Capital: " + c.getGeography().getCapitalCity() + "\n" +
	           "- Region: " + c.getRegion() + "\n" +
	           "- Government: " + c.getPoliticalLandscape().getGovernmentType() + "\n" +
	           "- Dominant Parties: " + 
	                String.join(", ", c.getPoliticalLandscape().getDominantParties()) + "\n" +
	           "- Climate Risk Index: " + c.getTrendTrackingData().getClimateRiskIndex();
	}
	
	public String chat(String userInput) {

	    // If user asks about a country
	    if (userInput.toLowerCase().startsWith("tell me about")) {
	        String name = userInput.substring(14).trim();
	        return answerCountryQuery(name);
	    }

	    if (userInput.toLowerCase().startsWith("what is the capital of")) {
	        String name = userInput.substring(22).trim();
	        Country c = manager.findCountryByName(name);

	        if (c == null) return "I don't have data for " + name + ".";
	        return "The capital of " + name + " is " + c.getGeography().getCapitalCity();
	    }
	    
	    if (userInput.toLowerCase().startsWith("election insight for")) {
	        String name = userInput.substring(20).trim();
	        return getElectionInsight(name);
	    }


	    if (userInput.equalsIgnoreCase("list countries")) {
	        return manager.getCountryNamesAsString();
	    }

	    return "I'm not sure how to answer that yet.";
	}
	
	private String getElectionInsight(String name) {

	    Country c = manager.findCountryByName(name);

	    if (c == null) {
	        return "I don't have data for " + name + ".";
	    }

	    double pmi = c.calculatePoliticalMarketIndex();
	    String trend = c.getIndexTrend();

	    return "Here are some insights for " + c.getCountryName() + ":\n" +
	           "- Political Market Index: " + pmi + "\n" +
	           "- Trend: " + trend + "\n" +
	           "- Stability: " + c.getPoliticalLandscape().getPoliticalStabilityIndex() + "\n" +
	           "- Corruption (lower is better): " + c.getPoliticalLandscape().getCorruptionIndex() + "\n" +
	           "- Environmental Stress: " + c.getTrendTrackingData().getClimateRiskIndex() + "\n" +
	           "These indicators can influence public sentiment, but they do not predict election outcomes.";
	}
	
	public void initialize() {
			repo = new KuzeRepository(); //create repo and load defaults & files
			
			Runtime.getRuntime().addShutdownHook(new Thread(() -> { //shutdown hook
			repo.saveAllBanks();
	    }));
	}
	
	public void start()
	{
		
	}


	
}
