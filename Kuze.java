/**
 * Kuze Chatbot Engine
 * @author: Tye Tosh
 * Description:
 * 		Kuze is a simple chatbot engine used to generate personalized
 * 		questions, statements, and excitement responses for a 
 * 		job application tracking program
 * */


import java.util.Scanner;

public class Kuze {

		private static final String SENTINEL = "SENTINEL";
		public String [] questions; // Stores chatbot questions with placeholder for personalization
		public String [] statements;// Stores chatbot statements with placeholder for personalization
		public String [] excitements;// Stores chatbot excitement with placeholder for personalization
		private String userAccount; //stores name provided by user
		private String progAccount; //Stores chatbot name
		private int BankSize = 5; //set size of responses - stage pulling from a DB
		private static String progJobDescription;
		
		/* creating global variables to be used in chatbot*/
		
		
		public Kuze() 
		{ //constructor body
			questions = new String[BankSize];
			statements = new String[BankSize];
			excitements = new String[BankSize];
			
			progAccount = "Kuze"; //default chatbot Name
			userAccount = "";
			progJobDescription = "help to track your Job Applications";
 
			populateQuestionsArray();
			populateStatementsArray();
			populateExcitmentsArray();
			
			/*  
			 * Initializes the chatbot with default values and loads
			 * all prompt banks into memory.
			 * 
 			*/
		}
/*
 * 	public static void main(String[] args)
 * 	{
 * 	 TODO Auto-generated method stub
 * 	}
 * 
*/
	
	//setters
	public void setUserAccount(String userAccount)
	{
		this.userAccount = userAccount;
	}
	
	public void setProgAccount(String progAccount)
	{
		this.progAccount = progAccount;
	}
	
	public void populateStatementsArray()
	{
		statements[0] = "userName, I’ve recorded that information for you. progName will keep everything organized.";
		
		statements[1] = "It looks like you’re making progress, userName. progName is here to help you stay on track.";
		statements[2] = "userName, I’ve updated your job application details. Let me know what you want to do next.";
		statements[3] = "I have saved your latest entry, userName. You’re doing great with your job search.";
		statements[4] = "Everything is stored safely, userName. progName will remind you when it’s time to follow up.";
	}
	
	public void populateQuestionsArray()
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
	
	public void populateExcitmentsArray()
	{
		excitements[0] = "Amazing work, userName! I, progName,  am impressed with your consistency.";
		
		excitements[1] = "Great job, userName! progName loves seeing your progress.";
		excitements[2] = "That’s exciting, userName! I can’t wait to help you with the next step.";
		excitements[3] = "Fantastic energy, userName! I am ready for whatever you want to do next.";
		excitements[4] = "You’re on fire today, userName! I am cheering you on.";
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
		String progReply = questions[(int)(Math.random()*(BankSize))];
			return replaceName(progReply);
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
		String progReply = statements[(int)(Math.random()*(BankSize))];
			return replaceName(progReply);
	}
	
	public String getProgramStatementsReply(int index)
	{	//overload- get a specific statement	
		String progReply = statements[index];
			return replaceName(progReply);
	}
	
	public String getProgramStatementsReply(String progReply)
	{//overload - adds message with statement
		progReply += " " + statements[(int)(Math.random()*(BankSize))];
			return replaceName(progReply);
	}
	
	public String getProgramExcitmentsReply()
	{	
		String progReply = excitements[(int)(Math.random()*(BankSize))];
			return replaceName(progReply);
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
		
		progReply += " " + excitements[(int)(Math.random()*(BankSize))];
			return replaceName(progReply);
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
		char usePointer = '-'; //default
		
		/**
		 * Determines the type of user input based on punctuation:
		 * Q = question, E = excitement, S = statement, - = default.
		 * 
		 * @param String statement from the user
		 * @return the type of punctuation used by the user
		 */
		
		if(usr.endsWith("?")) {usePointer ='Q';}
		else if(usr.endsWith("!")){usePointer ='E';}
		else if(usr.endsWith(".")){usePointer ='S';}
		else {usePointer = 'S';}
		
		return usePointer;
	}
	
	
	public boolean progSentinal(String userIsExit)
	{
		/**
		 * Checks whether the user entered the exit keyword.
		 * 
		 * @param userIsExit The user's input.
		 * @return true if the input matches the sentinel value, otherwise false
		 */
		
		if(userIsExit.equalsIgnoreCase(SENTINEL)){return true;}
		else{return false;}
	}
	
	public static void displayProgramExitMessage()
	{
		System.out.println("I See you have entered the exit key. Goodbye !!!");
	}
	
	public static void displayProgramWelcomeMessage()
	{
		System.out.print("Hello, I am a Chatbot, ready to "+ progJobDescription +".\nEnter your name: ");
	}
	
}
